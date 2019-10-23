

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Simulacija {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Random rn = new Random();
		Stopwatch vrijeme = new Stopwatch();
		Semafor semafor = new Semafor();
		ArrayList<Pjesak> pjesakDolje = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakGore = new ArrayList<Pjesak>();
		ArrayList<Objekti> objektDesno = new ArrayList<Objekti>();
		ArrayList<Objekti> objektLijevo = new ArrayList<Objekti>();
        Thread dretva = new Thread(semafor);
        dretva.start();
		
		
		vrijeme.Start();
		//dretva.Start();
		
		while(true) {
			
			if(Cesta.SlobodnoDesno() > 4) {
				int random = rn.nextInt(100)+1;
				if(random >= 1 && random <= 5) {
					int idObjekta = rn.nextInt(9)+1;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}
				else if(random >=6 && random <= 10) {
					int idObjekta = rn.nextInt(10)+61;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}
				else if(random >=11 && random <= 90) {
					int idObjekta = rn.nextInt(41)+10;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}else {
					int idObjekta = rn.nextInt(10)+51;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}
				
			}
			
			
			if(Cesta.SlobodnoLijevo() > 4) {
				int random = rn.nextInt(100)+1;
				if(random >= 1 && random <= 5) {
					int idObjekta = rn.nextInt(9)+1;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(15)+15, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}
				else if(random >=6 && random <= 10) {
					int idObjekta = rn.nextInt(10)+61;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(15)+15, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}
				else if(random >=11 && random <= 90) {
					int idObjekta = rn.nextInt(41)+10;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(15)+15, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}else {
					int idObjekta = rn.nextInt(10)+51;
					if(nePostojiObjekt(objektDesno,objektLijevo, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(15)+15, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}
				
			}
			
			if(Cesta.cesta[0][23] == '-'){
				char pom = (char) (rn.nextInt(26)+65);
				if(nePostojiPjesak(pjesakDolje,pjesakGore,pom)) {
					pjesakDolje.add(new Pjesak((int)rn.nextInt(5)+1, 'v', pom));
					dodjeliPozicijuPjesaku((Pjesak)pjesakDolje.get(pjesakDolje.size()-1));
				}
			}
			
			if(Cesta.cesta[8][21] == '-'){
				char pom = (char) (rn.nextInt(26)+65);
				if(nePostojiPjesak(pjesakDolje,pjesakGore,pom)) {
					pjesakGore.add(new Pjesak((int)rn.nextInt(5)+1, '^', pom));
					dodjeliPozicijuPjesaku((Pjesak)pjesakGore.get(pjesakGore.size()-1));
				}
			}
			
			Thread.sleep(100);
			
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		

			Cesta.ispisiCestu();
			System.out.println(semafor.pjesak);
			System.out.println(semafor.objekti);
			
			for(int i = 0; i < pjesakDolje.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Pjesak)pjesakDolje.get(i)).gibanje == true) {
					if(((Pjesak)pjesakDolje.get(i)).xPozicija >= 2) {
						((Pjesak)pjesakDolje.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDolje.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDolje.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakDolje.get(i)).xPozicija >= 8) {
							Cesta.cesta[((Pjesak)pjesakDolje.get(i)).xPozicija][23] = '-';
							pjesakDolje.remove(0);
							i--;
							break;
						}
						if(Cesta.cesta[((Pjesak)pjesakDolje.get(i)).xPozicija + 1][23] == '-' || Cesta.cesta[((Pjesak)pjesakDolje.get(i)).xPozicija + 1][23] == ' ') {
							Cesta.cesta[((Pjesak)pjesakDolje.get(i)).xPozicija][23] = '-';
							((Pjesak)pjesakDolje.get(i)).xPozicija++;
							Cesta.cesta[((Pjesak)pjesakDolje.get(i)).xPozicija][23] = ((Pjesak)pjesakDolje.get(i)).znak;
							((Pjesak)pjesakDolje.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
						
				}
			}
			for(int i = 0; i < pjesakGore.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Pjesak)pjesakGore.get(i)).gibanje == true) {
					if(((Pjesak)pjesakGore.get(i)).xPozicija <= 6) {
						((Pjesak)pjesakGore.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakGore.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakGore.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakGore.get(i)).xPozicija <= 0) {
							Cesta.cesta[((Pjesak)pjesakGore.get(i)).xPozicija][21] = '-';
							pjesakGore.remove(0);
							i--;
							break;
						}
						if(Cesta.cesta[((Pjesak)pjesakGore.get(i)).xPozicija - 1][21] == '-' || Cesta.cesta[((Pjesak)pjesakGore.get(i)).xPozicija - 1][21] == ' ') {
							Cesta.cesta[((Pjesak)pjesakGore.get(i)).xPozicija][21] = '-';
							((Pjesak)pjesakGore.get(i)).xPozicija--;
							Cesta.cesta[((Pjesak)pjesakGore.get(i)).xPozicija][21] = ((Pjesak)pjesakGore.get(i)).znak;
							((Pjesak)pjesakGore.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
						
				}
			}
			
			for(int i = 0; i < objektDesno.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Objekti)objektDesno.get(i)).gibanje == true) {
					if(((Objekti)objektDesno.get(i)).yPozicija > 20){
						((Objekti)objektDesno.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Objekti)objektDesno.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektDesno.get(i)).brzina)) {
						if(((Objekti)objektDesno.get(i)).yPozicija >= 44) {
							Cesta.cesta[5][((Objekti)objektDesno.get(i)).yPozicija] = ' ';
						}
						if(((Objekti)objektDesno.get(i)).yPozicija >= 44 || Cesta.cesta[5][((Objekti)objektDesno.get(i)).yPozicija + 1] == ' ' || Cesta.cesta[5][((Objekti)objektDesno.get(i)).yPozicija + 1] == '-') {
							pomakniObjektDesno(((Objekti)objektDesno.get(i)),vrijeme.elapsedTime());
							if(((Objekti)objektDesno.get(i)).duljina == 0) {
								objektDesno.remove(0);
							}						
							
						}
					}
				}
			}
			
			for(int i = 0; i < objektLijevo.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Objekti)objektLijevo.get(i)).gibanje == true) {
					if(((Objekti)objektLijevo.get(i)).yPozicija < 24){
						((Objekti)objektLijevo.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Objekti)objektLijevo.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektLijevo.get(i)).brzina)) {
						if(((Objekti)objektLijevo.get(i)).yPozicija <= 0) {
							Cesta.cesta[3][((Objekti)objektLijevo.get(i)).yPozicija] = ' ';
						}
						if(((Objekti)objektLijevo.get(i)).yPozicija <= 0 || Cesta.cesta[3][((Objekti)objektLijevo.get(i)).yPozicija - 1] == ' ' || Cesta.cesta[3][((Objekti)objektLijevo.get(i)).yPozicija - 1] == '-') {
							pomakniObjektLijevo(((Objekti)objektLijevo.get(i)),vrijeme.elapsedTime());
							if(((Objekti)objektLijevo.get(i)).duljina == 0) {
								objektLijevo.remove(0);
							}						
							
						}
					}
				}
			}
			
			
			
			
			
			
			
			
		}
		
		
	}

	private static void dodjeliPozicijuPjesaku(Pjesak pjesak) {
		if(Cesta.cesta[2][23] == '-' && pjesak.smjer == 'v') {
			pjesak.xPozicija = 2;
			pjesak.yPozicija = 23;
			Cesta.cesta[2][23] = pjesak.znak;
		}
		else if(Cesta.cesta[1][23] == '-' && pjesak.smjer == 'v') {
			pjesak.xPozicija = 1;
			pjesak.yPozicija = 23;
			Cesta.cesta[1][23] = pjesak.znak;
		}
		else if(Cesta.cesta[0][23] == '-' && pjesak.smjer == 'v') {
			pjesak.xPozicija = 0;
			pjesak.yPozicija = 23;
			Cesta.cesta[0][23] = pjesak.znak;
		}
		
		if(Cesta.cesta[6][21] == '-' && pjesak.smjer == '^') {
			pjesak.xPozicija = 6;
			pjesak.yPozicija = 21;
			Cesta.cesta[6][21] = pjesak.znak;
		}
		else if(Cesta.cesta[7][21] == '-' && pjesak.smjer == '^') {
			pjesak.xPozicija = 7;
			pjesak.yPozicija = 21;
			Cesta.cesta[7][21] = pjesak.znak;
		}
		else if(Cesta.cesta[8][21] == '-' && pjesak.smjer == '^') {
			pjesak.xPozicija = 8;
			pjesak.yPozicija = 21;
			Cesta.cesta[8][21] = pjesak.znak;
		}
			
	}
	
	private static void dodjeliPozicijuObjektu(Objekti objekt) {
		if(objekt.smjer == '>') {
			int slobodnoDesno = 0;
			while(Cesta.cesta[5][slobodnoDesno] == ' ') {
				slobodnoDesno++;
			}
			if(slobodnoDesno >= objekt.duljina) {
				Cesta.cesta[5][slobodnoDesno-1] = '>';
				objekt.yPozicija = slobodnoDesno - 1;
				if(objekt.duljina == 2) {
					Cesta.cesta[5][slobodnoDesno-2] = (char)(objekt.id + 48);
				}
				else if(objekt.duljina == 3) {
					Cesta.cesta[5][slobodnoDesno-3] = (char)(objekt.id/10 + 48);
					Cesta.cesta[5][slobodnoDesno-2] = (char)(objekt.id%10 + 48);
				}
				else if(objekt.duljina == 4) {
					Cesta.cesta[5][slobodnoDesno-4] = (char)(objekt.id/10 + 48);
					Cesta.cesta[5][slobodnoDesno-3] = (char)(objekt.id%10 + 48);
					Cesta.cesta[5][slobodnoDesno-2] = '*';
				}
				else if(objekt.duljina == 5) {
					Cesta.cesta[5][slobodnoDesno-5] = (char)(objekt.id/10 + 48);
					Cesta.cesta[5][slobodnoDesno-4] = (char)(objekt.id%10 + 48);
					Cesta.cesta[5][slobodnoDesno-3] = '*';
					Cesta.cesta[5][slobodnoDesno-3] = '*';
				}
			}
		}
		else if(objekt.smjer == '<') {
			int slobodnoLijevo = 0;
			int pom = 44;
			while(Cesta.cesta[3][pom] == ' ') {
				slobodnoLijevo++;
				pom--;
			}
			if(slobodnoLijevo >= objekt.duljina) {
				Cesta.cesta[3][44-slobodnoLijevo+1] = '<';
				objekt.yPozicija = 44-slobodnoLijevo+1;
				if(objekt.duljina == 2) {
					Cesta.cesta[3][44-slobodnoLijevo+2] = (char)(objekt.id + 48);
				}
				else if(objekt.duljina == 3) {
					Cesta.cesta[3][44-slobodnoLijevo+3] = (char)(objekt.id%10 + 48);
					Cesta.cesta[3][44-slobodnoLijevo+2] = (char)(objekt.id/10 + 48);
				}
				else if(objekt.duljina == 4) {
					Cesta.cesta[3][44-slobodnoLijevo+4] = (char)(objekt.id%10 + 48);
					Cesta.cesta[3][44-slobodnoLijevo+3] = (char)(objekt.id/10 + 48);
					Cesta.cesta[3][44-slobodnoLijevo+2] = '*';
				}
				else if(objekt.duljina == 5) {
					Cesta.cesta[3][44-slobodnoLijevo+5] = (char)(objekt.id%10 + 48);
					Cesta.cesta[3][44-slobodnoLijevo+4] = (char)(objekt.id/10 + 48);
					Cesta.cesta[3][44-slobodnoLijevo+3] = '*';
					Cesta.cesta[3][44-slobodnoLijevo+2] = '*';
				}
			}
		}
		
	}
	
	private static void pomakniObjektDesno(Objekti objekt, double vrijeme) {
		if(objekt.yPozicija >= 44) {
			Cesta.cesta[5][objekt.yPozicija] = ' ';
		}
		else {
			Cesta.cesta[5][objekt.yPozicija+1] = Cesta.cesta[5][objekt.yPozicija];
		}
		
		if(objekt.duljina == 2) {
			Cesta.cesta[5][objekt.yPozicija] = Cesta.cesta[5][objekt.yPozicija-1];
		}
		else if(objekt.duljina == 3) {
			Cesta.cesta[5][objekt.yPozicija] = Cesta.cesta[5][objekt.yPozicija-1];
			Cesta.cesta[5][objekt.yPozicija-1] = Cesta.cesta[5][objekt.yPozicija-2];
		}
		else if(objekt.duljina == 4) {
			Cesta.cesta[5][objekt.yPozicija] = Cesta.cesta[5][objekt.yPozicija-1];
			Cesta.cesta[5][objekt.yPozicija-1] = Cesta.cesta[5][objekt.yPozicija-2];
			Cesta.cesta[5][objekt.yPozicija-2] = Cesta.cesta[5][objekt.yPozicija-3];			
		}
		else if(objekt.duljina == 5) {
			Cesta.cesta[5][objekt.yPozicija] = Cesta.cesta[5][objekt.yPozicija-1];
			Cesta.cesta[5][objekt.yPozicija-1] = Cesta.cesta[5][objekt.yPozicija-2];
			Cesta.cesta[5][objekt.yPozicija-2] = Cesta.cesta[5][objekt.yPozicija-3];
			Cesta.cesta[5][objekt.yPozicija-3] = Cesta.cesta[5][objekt.yPozicija-4];
		}
		Cesta.cesta[5][objekt.yPozicija-objekt.duljina+1] = ' ';
		if(objekt.yPozicija >= 44) {
			objekt.yPozicija--;
			objekt.duljina--;
		}
		objekt.yPozicija++;
		objekt.vrijemeKretanja = vrijeme;

		
	}
	
	
	
	

	private static void pomakniObjektLijevo(Objekti objekt, double vrijeme) {
		if(objekt.yPozicija <= 0) {
			Cesta.cesta[3][objekt.yPozicija] = ' ';
		}
		else {
			Cesta.cesta[3][objekt.yPozicija-1] = Cesta.cesta[3][objekt.yPozicija];
		}
		
		if(objekt.duljina == 2) {
			Cesta.cesta[3][objekt.yPozicija] = Cesta.cesta[3][objekt.yPozicija+1];
		}
		else if(objekt.duljina == 3) {
			Cesta.cesta[3][objekt.yPozicija] = Cesta.cesta[3][objekt.yPozicija+1];
			Cesta.cesta[3][objekt.yPozicija+1] = Cesta.cesta[3][objekt.yPozicija+2];
		}
		else if(objekt.duljina == 4) {
			Cesta.cesta[3][objekt.yPozicija] = Cesta.cesta[3][objekt.yPozicija+1];
			Cesta.cesta[3][objekt.yPozicija+1] = Cesta.cesta[3][objekt.yPozicija+2];
			Cesta.cesta[3][objekt.yPozicija+2] = Cesta.cesta[3][objekt.yPozicija+3];
		}
		else if(objekt.duljina == 5) {
			Cesta.cesta[3][objekt.yPozicija] = Cesta.cesta[3][objekt.yPozicija+1];
			Cesta.cesta[3][objekt.yPozicija+1] = Cesta.cesta[3][objekt.yPozicija+2];
			Cesta.cesta[3][objekt.yPozicija+2] = Cesta.cesta[3][objekt.yPozicija+3];
			Cesta.cesta[3][objekt.yPozicija+3] = Cesta.cesta[3][objekt.yPozicija+4];
		}
		
		Cesta.cesta[3][objekt.yPozicija+objekt.duljina-1] = ' ';
		if(objekt.yPozicija <= 0) {
			objekt.yPozicija++;
			objekt.duljina--;
		}
		objekt.yPozicija--;
		objekt.vrijemeKretanja = vrijeme;
		
	}

	
	private static boolean nePostojiPjesak(ArrayList pjesakDolje, ArrayList pjesakGore, char pom) {
		for(int i = 0; i < pjesakDolje.size(); i++) {
			if(((Pjesak)pjesakDolje.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < pjesakGore.size(); i++) {
			if(((Pjesak)pjesakGore.get(i)).znak == pom) {
				return false;
			}
		}
		return true;
	}

	private static boolean nePostojiObjekt(ArrayList objektDesno, ArrayList objektLijevo, int idObjekta) {
		for(int i = 0; i < objektDesno.size(); i++) {
			if(((Objekti)objektDesno.get(i)).id == idObjekta) {
				return false;
			}
		}
		for(int i = 0; i < objektLijevo.size(); i++) {
			if(((Objekti)objektLijevo.get(i)).id == idObjekta) {
				return false;
			}
		}
		return true;
	}
	
	
	 
}