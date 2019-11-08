

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
		
		
		ArrayList<Pjesak> pjesakDoljeD = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakGoreD = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakDoljeL = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakGoreL = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakDesnoG = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakDesnoD = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakLijevoG = new ArrayList<Pjesak>();
		ArrayList<Pjesak> pjesakLijevoD = new ArrayList<Pjesak>();
		
		
		
		ArrayList<Objekti> objektDesno = new ArrayList<Objekti>();
		ArrayList<Objekti> objektLijevo = new ArrayList<Objekti>();
		ArrayList<Objekti> objektDolje = new ArrayList<Objekti>();
		ArrayList<Objekti> objektGore = new ArrayList<Objekti>();
		
        Thread dretva = new Thread(semafor);
        vrijeme.Start();
        dretva.start();
		
		
		
		while(true) {
		if(true) {	
//			if(Cesta.SlobodnoDesno() > 4) {
//				int random = rn.nextInt(100)+1;
//				if(random >= 1 && random <= 5) {
//					int idObjekta = rn.nextInt(9)+1;
//					if(nePostojiObjekt(objektDesno,objektLijevo, objektGore, objektDolje, idObjekta)) {
//						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
//						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
//					}
//				}
//				else if(random >=6 && random <= 10) {
//					int idObjekta = rn.nextInt(10)+61;
//					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje,  idObjekta)) {
//						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
//						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
//					}
//				}
//				else if(random >=11 && random <= 90) {
//					int idObjekta = rn.nextInt(41)+10;
//					if(nePostojiObjekt(objektDesno,objektLijevo, objektGore, objektDolje, idObjekta)) {
//						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
//						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
//					}
//				}else {
//					int idObjekta = rn.nextInt(10)+51;
//					if(nePostojiObjekt(objektDesno,objektLijevo, objektGore, objektDolje, idObjekta)) {
//						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
//						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
//					}
//				}
//				
//			}
			if(Cesta.SlobodnoDesno() > 4) {
				int random = rn.nextInt(100)+1;
				if(random >= 1 && random <= 5) {
					int idObjekta = rn.nextInt(9)+1;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore,objektDolje, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}
				else if(random >=6 && random <= 10) {
					int idObjekta = rn.nextInt(10)+61;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}
				else if(random >=11 && random <= 90) {
					int idObjekta = rn.nextInt(41)+10;
					if(nePostojiObjekt(objektDesno,objektLijevo, objektGore, objektDolje, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}else {
					int idObjekta = rn.nextInt(10)+51;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje, idObjekta)) {
						objektDesno.add(new Objekti(idObjekta, rn.nextInt(20)+20, '>' ));
						dodjeliPozicijuObjektu((Objekti)objektDesno.get(objektDesno.size()-1));
					}
				}
				
			}
			
			
//			if(Cesta.SlobodnoLijevo() > 4) {
//				int random = rn.nextInt(100)+1;
//				if(random >= 1 && random <= 5) {
//					int idObjekta = rn.nextInt(9)+1;
//					if(nePostojiObjekt(objektDesno,objektLijevo, objektGore, objektDolje, idObjekta)) {
//						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
//						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
//					}
//				}
//				else if(random >=6 && random <= 10) {
//					int idObjekta = rn.nextInt(10)+61;
//					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje,  idObjekta)) {
//						objektLijevo.add(new Objekti(idObjekta,  rn.nextInt(20)+20, '<' ));
//						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
//					}
//				}
//				else if(random >=11 && random <= 90) {
//					int idObjekta = rn.nextInt(41)+10;
//					if(nePostojiObjekt(objektDesno,objektLijevo, objektGore, objektDolje, idObjekta)) {
//						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
//						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
//					}
//				}else {
//					int idObjekta = rn.nextInt(10)+51;
//					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje,  idObjekta)) {
//						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
//						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
//					}
//				}
//				
//			}
			if(Cesta.SlobodnoLijevo() > 4) {
				int random = rn.nextInt(100)+1;
				if(random >= 1 && random <= 5) {
					int idObjekta = rn.nextInt(9)+1;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje, idObjekta) ) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}
				else if(random >=6 && random <= 10) {
					int idObjekta = rn.nextInt(10)+61;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}
				else if(random >=11 && random <= 90) {
					int idObjekta = rn.nextInt(41)+10;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}else {
					int idObjekta = rn.nextInt(10)+51;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore, objektDolje, idObjekta)) {
						objektLijevo.add(new Objekti(idObjekta, rn.nextInt(20)+20, '<' ));
						dodjeliPozicijuObjektu((Objekti)objektLijevo.get(objektLijevo.size()-1));
					}
				}
				
			}
			
			if(Cesta.SlobodnoDolje() > 4) {
				int random = rn.nextInt(100)+1;
				if(random >= 1 && random <= 5) {
					int idObjekta = rn.nextInt(9)+1;
					if(nePostojiObjekt(objektDesno, objektLijevo, objektGore,objektDolje, idObjekta)) {
						objektDolje.add(new Objekti(idObjekta,rn.nextInt(20)+20, 'v'));
						dodjeliPozicijuObjektu((Objekti)objektDolje.get(objektDolje.size()-1));
					}
				}
				else if(random >= 6 && random <= 10) {
					int idObjekta = rn.nextInt(10)+61;
					if(nePostojiObjekt(objektDesno, objektLijevo, objektGore,objektDolje, idObjekta)) {
						objektDolje.add(new Objekti(idObjekta,rn.nextInt(20)+20, 'v'));
						dodjeliPozicijuObjektu((Objekti)objektDolje.get(objektDolje.size()-1));
					}
				}
				else if(random >= 11 && random <= 90) {
					int idObjekta = rn.nextInt(41)+10;
					if(nePostojiObjekt(objektDesno, objektLijevo, objektGore,objektDolje, idObjekta)) {
						objektDolje.add(new Objekti(idObjekta,rn.nextInt(20)+20, 'v'));
						dodjeliPozicijuObjektu((Objekti)objektDolje.get(objektDolje.size()-1));
					}
				}
				else{
					int idObjekta = rn.nextInt(10)+51;
					if(nePostojiObjekt(objektDesno, objektLijevo, objektGore,objektDolje, idObjekta)) {
						objektDolje.add(new Objekti(idObjekta,rn.nextInt(20)+20, 'v'));
						dodjeliPozicijuObjektu((Objekti)objektDolje.get(objektDolje.size()-1));
					}
				}
			}
			
			if(Cesta.SlobodnoGore() > 4) {
				int random = rn.nextInt(100)+1;
				if(random >= 1 && random <= 5) {
					int idObjekta = rn.nextInt(9)+1;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore,objektDolje, idObjekta)) {
						objektGore.add(new Objekti(idObjekta,rn.nextInt(20)+20, '^'));
						dodjeliPozicijuObjektu((Objekti)objektGore.get(objektGore.size()-1));
					}
				}
				else if(random >= 6 && random <= 10) {
					int idObjekta = rn.nextInt(10)+61;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore,objektDolje, idObjekta)) {
						objektGore.add(new Objekti(idObjekta,rn.nextInt(20)+20, '^'));
						dodjeliPozicijuObjektu((Objekti)objektGore.get(objektGore.size()-1));
					}
				}
				else if(random >= 11 && random <= 90) {
					int idObjekta = rn.nextInt(41)+10;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore,objektDolje, idObjekta)) {
						objektGore.add(new Objekti(idObjekta,rn.nextInt(20)+20, '^'));
						dodjeliPozicijuObjektu((Objekti)objektGore.get(objektGore.size()-1));
					}
				}
				else {
					int idObjekta = rn.nextInt(10)+51;
					if(nePostojiObjekt(objektDesno,objektLijevo,objektGore,objektDolje, idObjekta)) {
						objektGore.add(new Objekti(idObjekta,rn.nextInt(20)+20, '^'));
						dodjeliPozicijuObjektu((Objekti)objektGore.get(objektGore.size()-1));
					}
				}
			}
			
			if(Cesta.raskrizje[11][24] == '-') {
				char pom = (char)(rn.nextInt(26)+65);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakDoljeL.add(new Pjesak((int)rn.nextInt(5)+1, 'v', pom, 'L'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakDoljeL.get(pjesakDoljeL.size()-1));
				}
			}
			
			if(Cesta.raskrizje[19][22] == '-') {
				char pom = (char) (rn.nextInt(26)+65);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakGoreL.add(new Pjesak((int)rn.nextInt(5)+1, '^', pom, 'L'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakGoreL.get(pjesakGoreL.size()-1));
				}
			}
			
			if(Cesta.raskrizje[11][42] == '-') {
				char pom = (char) (rn.nextInt(26)+65);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakDoljeD.add(new Pjesak((int)rn.nextInt(5)+1, 'v', pom, 'R'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakDoljeD.get(pjesakDoljeD.size()-1));
				}
			}
			
			if(Cesta.raskrizje[19][40] == '-') {
				char pom = (char) (rn.nextInt(26)+65);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakGoreD.add(new Pjesak((int)rn.nextInt(5)+1, '^', pom, 'R'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakGoreD.get(pjesakGoreD.size()-1));
				}
			}
			
			if(Cesta.raskrizje[11][26] == '|') {
				char pom = (char)(rn.nextInt(26)+97);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakDesnoG.add(new Pjesak((int)rn.nextInt(5)+1, '>' ,pom, 'U'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakDesnoG.get(pjesakDesnoG.size()-1));
				}
			}
			
			if(Cesta.raskrizje[10][38] == '|') {
				char pom = (char) (rn.nextInt(26)+97);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakLijevoG.add(new Pjesak((int)rn.nextInt(5)+1, '<' , pom, 'U'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakLijevoG.get(pjesakLijevoG.size()-1));
				}
			}
			
			if(Cesta.raskrizje[19][26] == '|') {
				char pom = (char)(rn.nextInt(26)+97);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakDesnoD.add(new Pjesak((int)rn.nextInt(5)+1, '>' , pom, 'D'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakDesnoD.get(pjesakDesnoD.size()-1));
				}
			}
			
			if(Cesta.raskrizje[20][38] == '|') {
				char pom = (char)(rn.nextInt(26)+97);
				if(nePostojiPjesak(pjesakDoljeD,pjesakGoreD,pjesakDoljeL,pjesakDoljeD, pjesakDesnoD, pjesakDesnoG, pjesakLijevoD,pjesakLijevoG,pom)) {
					pjesakLijevoD.add(new Pjesak((int)rn.nextInt(5)+1, '<', pom, 'D'));
					dodjeliPozicijuPjesaku((Pjesak)pjesakLijevoD.get(pjesakLijevoD.size()-1));
				}
			}
			
			
		}
			
		
			Thread.sleep(500);
			
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
			Cesta.ispisiRaskizje();
			System.out.println("horizontalno: " + semafor.pjesak);
			System.out.println("vertikalno: " + semafor.objekti);
			
			for(int i = 0; i < pjesakDoljeL.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Pjesak)pjesakDoljeL.get(i)).gibanje == true) {
					if(((Pjesak)pjesakDoljeL.get(i)).xPozicija >= 13) {
						((Pjesak)pjesakDoljeL.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDoljeL.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDoljeL.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakDoljeL.get(i)).xPozicija >= 19) {
							Cesta.raskrizje[((Pjesak)pjesakDoljeL.get(i)).xPozicija][24] = '-';
							pjesakDoljeL.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[((Pjesak)pjesakDoljeL.get(i)).xPozicija+1][24] == '-' || Cesta.raskrizje[((Pjesak)pjesakDoljeL.get(i)).xPozicija+1][24] == ' ') {
							Cesta.raskrizje[((Pjesak)pjesakDoljeL.get(i)).xPozicija][24] = '-';
							((Pjesak)pjesakDoljeL.get(i)).xPozicija++;
							Cesta.raskrizje[((Pjesak)pjesakDoljeL.get(i)).xPozicija][24] = ((Pjesak)pjesakDoljeL.get(i)).znak;
							((Pjesak)pjesakDoljeL.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
				}
			}
			
			for(int i = 0; i < pjesakGoreL.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Pjesak)pjesakGoreL.get(i)).gibanje == true) {
					if(((Pjesak)pjesakGoreL.get(i)).xPozicija <= 17) {
						((Pjesak)pjesakGoreL.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakGoreL.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakGoreL.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakGoreL.get(i)).xPozicija <= 11) {
							Cesta.raskrizje[((Pjesak)pjesakGoreL.get(i)).xPozicija][22] = '-';
							pjesakGoreL.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[((Pjesak)pjesakGoreL.get(i)).xPozicija-1][22] == '-' || Cesta.raskrizje[((Pjesak)pjesakGoreL.get(i)).xPozicija-1][22] == ' ') {
							Cesta.raskrizje[((Pjesak)pjesakGoreL.get(i)).xPozicija][22] = '-';
							((Pjesak)pjesakGoreL.get(i)).xPozicija--;
							Cesta.raskrizje[((Pjesak)pjesakGoreL.get(i)).xPozicija][22] = ((Pjesak)pjesakGoreL.get(i)).znak;
							((Pjesak)pjesakGoreL.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
				}
			}
			
			for(int i = 0; i < pjesakDoljeD.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Pjesak)pjesakDoljeD.get(i)).gibanje == true) {
					if(((Pjesak)pjesakDoljeD.get(i)).xPozicija >= 13) {
						((Pjesak)pjesakDoljeD.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDoljeD.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDoljeD.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakDoljeD.get(i)).xPozicija >= 19) {
							Cesta.raskrizje[((Pjesak)pjesakDoljeD.get(i)).xPozicija][42] = '-';
							pjesakDoljeD.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[((Pjesak)pjesakDoljeD.get(i)).xPozicija+1][42] == '-' || Cesta.raskrizje[((Pjesak)pjesakDoljeD.get(i)).xPozicija+1][42] == ' ') {
							Cesta.raskrizje[((Pjesak)pjesakDoljeD.get(i)).xPozicija][42] = '-';
							((Pjesak)pjesakDoljeD.get(i)).xPozicija++;
							Cesta.raskrizje[((Pjesak)pjesakDoljeD.get(i)).xPozicija][42] = ((Pjesak)pjesakDoljeD.get(i)).znak;
							((Pjesak)pjesakDoljeD.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
				}
			}
			
			for(int i = 0; i < pjesakGoreD.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Pjesak)pjesakGoreD.get(i)).gibanje == true) {
					if(((Pjesak)pjesakGoreD.get(i)).xPozicija <= 17) {
						((Pjesak)pjesakGoreD.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakGoreD.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakGoreD.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakGoreD.get(i)).xPozicija <= 11) {
							Cesta.raskrizje[((Pjesak)pjesakGoreD.get(i)).xPozicija][40] = '-';
							pjesakGoreD.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[((Pjesak)pjesakGoreD.get(i)).xPozicija-1][40] == '-' || Cesta.raskrizje[((Pjesak)pjesakGoreD.get(i)).xPozicija-1][40] == ' ') {
							Cesta.raskrizje[((Pjesak)pjesakGoreD.get(i)).xPozicija][40] = '-';
							((Pjesak)pjesakGoreD.get(i)).xPozicija--;
							Cesta.raskrizje[((Pjesak)pjesakGoreD.get(i)).xPozicija][40] = ((Pjesak)pjesakGoreD.get(i)).znak;
							((Pjesak)pjesakGoreD.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
				}
			}
			
//			for(int i = 0; i < pjesakDesnoG.size(); i++) {
//				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakDesnoG.get(i)).gibanje == true) {
//					if(((Pjesak)pjesakDesnoG.get(i)).yPozicija >= 14) {
//						((Pjesak)pjesakDesnoG.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDesnoG.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDesnoG.get(i)).brzina) / 4)) {
//						if(((Pjesak)pjesakDesnoG.get(i)).yPozicija >= 38) {
//							Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija] = '|';
//							pjesakDesnoG.remove(0);
//							i--;
//							break;
//						}
//						if(Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija+1] == '-' || Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija+1] == ' ') {
//							Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija] = '|';
//							((Pjesak)pjesakDesnoG.get(i)).yPozicija++;
//							Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija] = ((Pjesak)pjesakDesnoG.get(i)).znak;
//							((Pjesak)pjesakDesnoG.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
//						}
//					}
//				}
//			}
			for(int i = 0; i < pjesakDesnoG.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakDesnoG.get(i)).gibanje == true) {
					if(((Pjesak)pjesakDesnoG.get(i)).yPozicija >= 14) {
						((Pjesak)pjesakDesnoG.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDesnoG.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDesnoG.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakDesnoG.get(i)).yPozicija >= 38) {
							Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija] = '|';
							pjesakDesnoG.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija + 1] == '|' || Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija + 1] == ' ') {
							Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija] = '|';
							((Pjesak)pjesakDesnoG.get(i)).yPozicija++;
							Cesta.raskrizje[19][((Pjesak)pjesakDesnoG.get(i)).yPozicija] = ((Pjesak)pjesakDesnoG.get(i)).znak;
							((Pjesak)pjesakDesnoG.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
						
				}
			}
			
//			for(int i = 0; i < pjesakLijevoG.size(); i++) {
//				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakLijevoG.get(i)).gibanje == true) {
//					if(((Pjesak)pjesakLijevoG.get(i)).yPozicija <= 35) {
//						((Pjesak)pjesakLijevoG.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() - ((Pjesak)pjesakLijevoG.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakLijevoG.get(i)).brzina) / 4)) {
//						if(((Pjesak)pjesakLijevoG.get(i)).yPozicija <= 26) {
//							Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija] = '|';
//							pjesakLijevoG.remove(0);
//							i--;
//							break;
//						}
//						if(Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija-1] == '-' || Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija-1] == ' ') {
//							Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija] = '|';
//							((Pjesak)pjesakLijevoG.get(i)).yPozicija--;
//							Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija] = ((Pjesak)pjesakLijevoG.get(i)).znak;
//							((Pjesak)pjesakLijevoG.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
//						}
//					}
//				}
//			}
//			
			for(int i = 0; i < pjesakLijevoG.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakLijevoG.get(i)).gibanje == true) {
					if(((Pjesak)pjesakLijevoG.get(i)).yPozicija <= 35) {
						((Pjesak)pjesakLijevoG.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakLijevoG.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakLijevoG.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakLijevoG.get(i)).yPozicija <= 26) {
							Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija] = '|';
							pjesakLijevoG.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija - 1] == '|' || Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija - 1] == ' ') {
							Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija] = '|';
							((Pjesak)pjesakLijevoG.get(i)).yPozicija--;
							Cesta.raskrizje[10][((Pjesak)pjesakLijevoG.get(i)).yPozicija] = ((Pjesak)pjesakLijevoG.get(i)).znak;
							((Pjesak)pjesakLijevoG.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
						
				}
			}
//			for(int i = 0; i < pjesakDesnoD.size(); i++) {
//				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakDesnoD.get(i)).gibanje == true) {
//					if(((Pjesak)pjesakDesnoD.get(i)).yPozicija >= 14) {
//						((Pjesak)pjesakDesnoD.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDesnoD.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDesnoD.get(i)).brzina) / 4)) {
//						if(((Pjesak)pjesakDesnoD.get(i)).yPozicija >= 38) {
//							Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija] = '|';
//							pjesakDesnoD.remove(0);
//							i--;
//							break;
//						}
//						if(Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija+1] == '-' || Cesta.raskrizje[19][((Pjesak)pjesakDesnoD.get(i)).yPozicija+1] == ' ') {
//							Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija] = '|';
//							((Pjesak)pjesakDesnoD.get(i)).yPozicija++;
//							Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija] = ((Pjesak)pjesakDesnoD.get(i)).znak;
//							((Pjesak)pjesakDesnoD.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
//						}
//					}
//				}
//			}
			for(int i = 0; i < pjesakDesnoD.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakDesnoD.get(i)).gibanje == true) {
					if(((Pjesak)pjesakDesnoD.get(i)).yPozicija >= 14) {
						((Pjesak)pjesakDesnoD.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakDesnoD.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakDesnoD.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakDesnoD.get(i)).yPozicija >= 38) {
							Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija] = '|';
							pjesakDesnoD.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija + 1] == '|' || Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija + 1] == ' ') {
							Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija] = '|';
							((Pjesak)pjesakDesnoD.get(i)).yPozicija++;
							Cesta.raskrizje[11][((Pjesak)pjesakDesnoD.get(i)).yPozicija] = ((Pjesak)pjesakDesnoD.get(i)).znak;
							((Pjesak)pjesakDesnoD.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
						
				}
			}
			
//			for(int i = 0; i < pjesakLijevoD.size(); i++) {
//				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakLijevoD.get(i)).gibanje == true) {
//					if(((Pjesak)pjesakLijevoD.get(i)).yPozicija <= 35) {
//						((Pjesak)pjesakLijevoD.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() - ((Pjesak)pjesakLijevoD.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakLijevoD.get(i)).brzina) / 4)) {
//						if(((Pjesak)pjesakLijevoD.get(i)).yPozicija <= 26) {
//							Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija] = '|';
//							pjesakLijevoD.remove(0);
//							i--;
//							break;
//						}
//						if(Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija-1] == '-' || Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija-1] == ' ') {
//							Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija] = '|';
//							((Pjesak)pjesakLijevoD.get(i)).yPozicija--;
//							Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija] = ((Pjesak)pjesakLijevoD.get(i)).znak;
//							((Pjesak)pjesakLijevoD.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
//						}
//					}
//				}
//			}
			for(int i = 0; i < pjesakLijevoD.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Pjesak)pjesakLijevoD.get(i)).gibanje == true) {
					if(((Pjesak)pjesakLijevoD.get(i)).yPozicija <= 35) {
						((Pjesak)pjesakLijevoD.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Pjesak)pjesakLijevoD.get(i)).vrijemeKretanja > (double)((float)(((Pjesak)pjesakLijevoD.get(i)).brzina) / 4)) {
						if(((Pjesak)pjesakLijevoD.get(i)).yPozicija <= 26) {
							Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija] = '|';
							pjesakLijevoD.remove(0);
							i--;
							break;
						}
						if(Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija - 1] == '|' || Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija - 1] == ' ') {
							Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija] = '|';
							((Pjesak)pjesakLijevoD.get(i)).yPozicija--;
							Cesta.raskrizje[20][((Pjesak)pjesakLijevoD.get(i)).yPozicija] = ((Pjesak)pjesakLijevoD.get(i)).znak;
							((Pjesak)pjesakLijevoD.get(i)).vrijemeKretanja = vrijeme.elapsedTime();
						}
					}
						
				}
			}
			
			
			
			
			
			
			
			
//			for(int i = 0; i < objektDesno.size(); i++) {
//				if(semafor.objekti == "zeleno" || ((Objekti)objektDesno.get(i)).gibanje == true) {
//					if(((Objekti)objektDesno.get(i)).yPozicija >= 20){
//						((Objekti)objektDesno.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() - ((Objekti)objektDesno.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektDesno.get(i)).brzina)) {
//						if(((Objekti)objektDesno.get(i)).yPozicija >= 64) {
//							Cesta.raskrizje[5][((Objekti)objektDesno.get(i)).yPozicija] = ' ';
//						}
//						if(((Objekti)objektDesno.get(i)).yPozicija >= 64 || Cesta.raskrizje[14][((Objekti)objektDesno.get(i)).yPozicija + 1] == ' ' || Cesta.raskrizje[14][((Objekti)objektDesno.get(i)).yPozicija + 1] == '-'|| Cesta.raskrizje[14][((Objekti)objektDesno.get(i)).yPozicija + 1] == '|') {
//							pomakniObjektDesno(((Objekti)objektDesno.get(i)),vrijeme.elapsedTime());
//							if(((Objekti)objektDesno.get(i)).duljina == 0) {
//								objektDesno.remove(0);
//							}						
//							
//						}
//					}
//				}
//			}
//			
			for(int i = 0; i < objektDesno.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Objekti)objektDesno.get(i)).gibanje == true) {
					if(((Objekti)objektDesno.get(i)).yPozicija >= 20){
						((Objekti)objektDesno.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Objekti)objektDesno.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektDesno.get(i)).brzina)) {
						if(((Objekti)objektDesno.get(i)).yPozicija >= 64) {
							Cesta.raskrizje[5][((Objekti)objektDesno.get(i)).yPozicija] = ' ';
						}
						if(((Objekti)objektDesno.get(i)).yPozicija >= 64 || Cesta.raskrizje[14][((Objekti)objektDesno.get(i)).yPozicija + 1] == ' ' || Cesta.raskrizje[14][((Objekti)objektDesno.get(i)).yPozicija + 1] == '-' || Cesta.raskrizje[14][((Objekti)objektDesno.get(i)).yPozicija + 1] == '|') {
							pomakniObjektDesno(((Objekti)objektDesno.get(i)),vrijeme.elapsedTime());
							if(((Objekti)objektDesno.get(i)).duljina == 0) {
								objektDesno.remove(0);
							}						
							
						}
					}
				}
			}
			
//			for(int i = 0; i < objektLijevo.size(); i++) {
//				if(semafor.objekti == "zeleno" || ((Objekti)objektLijevo.get(i)).gibanje == true) {
//					if(((Objekti)objektLijevo.get(i)).yPozicija < 43){
//						((Objekti)objektLijevo.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() - ((Objekti)objektLijevo.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektLijevo.get(i)).brzina)) {
//						if(((Objekti)objektLijevo.get(i)).yPozicija <= 0) {
//							Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija] = ' ';
//						}
//						if(((Objekti)objektLijevo.get(i)).yPozicija <= 0 || Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija - 1] == ' ' || Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija - 1] == '-' || Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija - 1] == '|'){
//							pomakniObjektLijevo(((Objekti)objektLijevo.get(i)),vrijeme.elapsedTime());
//							if(((Objekti)objektLijevo.get(i)).duljina == 0) {
//								objektLijevo.remove(0);
//							}						
//							
//						}
//					}
//				}
//			}
			
			for(int i = 0; i < objektLijevo.size(); i++) {
				if(semafor.objekti == "zeleno" || ((Objekti)objektLijevo.get(i)).gibanje == true) {
					if(((Objekti)objektLijevo.get(i)).yPozicija <= 43){
						((Objekti)objektLijevo.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Objekti)objektLijevo.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektLijevo.get(i)).brzina)) {
						if(((Objekti)objektLijevo.get(i)).yPozicija <= 0) {
							Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija] = ' ';
						}
						if(((Objekti)objektLijevo.get(i)).yPozicija <= 0 || Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija - 1] == ' ' || Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija - 1] == '-' || Cesta.raskrizje[16][((Objekti)objektLijevo.get(i)).yPozicija - 1] == '|') {
							pomakniObjektLijevo(((Objekti)objektLijevo.get(i)),vrijeme.elapsedTime());
							if(((Objekti)objektLijevo.get(i)).duljina == 0) {
								objektLijevo.remove(0);
							}						
							
						}
					}
				}
			}
			
			for(int i = 0; i < objektDolje.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Objekti)objektDolje.get(i)).gibanje==true) {
					if(((Objekti)objektDolje.get(i)).xPozicija >= 9){
						((Objekti)objektDolje.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() / ((Objekti)objektDolje.get(i)).vrijemeKretanja > (double)((float)4/((Objekti)objektDolje.get(i)).brzina)) {
						if(((Objekti)objektDolje.get(i)).xPozicija >= 30) {
							Cesta.raskrizje[((Objekti)objektDolje.get(i)).xPozicija][30] = ' ';
						}
					if(((Objekti)objektDolje.get(i)).xPozicija >= 30 || Cesta.raskrizje[((Objekti)objektDolje.get(i)).xPozicija+1][30] == ' ' || Cesta.raskrizje[((Objekti)objektDolje.get(i)).xPozicija+1][30] == '-' || Cesta.raskrizje[((Objekti)objektDolje.get(i)).xPozicija+1][30] == '|'  ) {
						pomakniObjektDolje(((Objekti)objektDolje.get(i)),vrijeme.elapsedTime());
						if(((Objekti)objektDolje.get(i)).duljina == 0) {
							objektDolje.remove(0);
						}
					}
					}
				}
			}
			
			
			
//			for(int i = 0; i < objektGore.size(); i++) {
//				if(semafor.pjesak == "zeleno" || ((Objekti)objektGore.get(i)).gibanje==true) {
//					if(((Objekti)objektGore.get(i)).xPozicija <= 21){
//						((Objekti)objektGore.get(i)).gibanje = true;
//					}
//					if(vrijeme.elapsedTime() / ((Objekti)objektGore.get(i)).vrijemeKretanja > (double)((float)4/((Objekti)objektGore.get(i)).brzina)) {
//						if(((Objekti)objektGore.get(i)).xPozicija <= 0) {
//							Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija][34] = ' ';
//						}
//					if(((Objekti)objektGore.get(i)).xPozicija <= 0 || Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija-1][34] == ' ' || Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija-1][34] == '-' || Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija-1][34] == '|'  ) {
//						pomakniObjektGore(((Objekti)objektGore.get(i)),vrijeme.elapsedTime());
//						if(((Objekti)objektGore.get(i)).duljina == 0) {
//							objektGore.remove(0);
//						}
//					}
//					}
//				}
//			}
			for(int i = 0; i < objektGore.size(); i++) {
				if(semafor.pjesak == "zeleno" || ((Objekti)objektGore.get(i)).gibanje == true) {
					if(((Objekti)objektGore.get(i)).xPozicija <= 21){
						((Objekti)objektGore.get(i)).gibanje = true;
					}
					if(vrijeme.elapsedTime() - ((Objekti)objektGore.get(i)).vrijemeKretanja > (double)((float) 4 / ((Objekti)objektGore.get(i)).brzina)) {
						if(((Objekti)objektGore.get(i)).xPozicija <= 0) {
							Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija][34] = ' ';
						}
						if(((Objekti)objektGore.get(i)).xPozicija <= 0 || Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija - 1][34] == ' ' || Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija - 1][34] == '-' || Cesta.raskrizje[((Objekti)objektGore.get(i)).xPozicija - 1][34] == '|') {
							pomakniObjektGore(((Objekti)objektGore.get(i)),vrijeme.elapsedTime());
							if(((Objekti)objektGore.get(i)).duljina == 0) {
								objektGore.remove(0);
							}						
							
						}
					}
				}
			}
			
			
			
			
		}
		
		
	}

	

	private static void dodjeliPozicijuPjesaku(Pjesak pjesak) {
		if(pjesak.pozicija == 'L') {
			if(Cesta.raskrizje[13][24] == '-' && pjesak.smjer == 'v') {
				pjesak.xPozicija = 13;
				pjesak.yPozicija = 24;
				Cesta.raskrizje[13][24] = pjesak.znak;
			}
			else if(Cesta.raskrizje[12][24] == '-' && pjesak.smjer == 'v') {
				pjesak.xPozicija = 12;
				pjesak.yPozicija = 24;
				Cesta.raskrizje[12][24] = pjesak.znak;
			}
			else if(Cesta.raskrizje[11][24] == '-' && pjesak.smjer == 'v') {
				pjesak.xPozicija = 11;
				pjesak.yPozicija = 24;
				Cesta.raskrizje[11][24] = pjesak.znak;
			}
			if(Cesta.raskrizje[17][22] == '-' && pjesak.smjer == '^') {
				pjesak.xPozicija = 17;
				pjesak.yPozicija = 22;
				Cesta.raskrizje[17][22] = pjesak.znak;
			}
			else if(Cesta.raskrizje[18][22] == '-' && pjesak.smjer == '^') {
				pjesak.xPozicija = 18;
				pjesak.yPozicija = 22;
				Cesta.raskrizje[18][22] = pjesak.znak;
			}
			else if(Cesta.raskrizje[19][22] == '-' && pjesak.smjer == '^') {
				pjesak.xPozicija = 19;
				pjesak.yPozicija = 22;
				Cesta.raskrizje[19][22] = pjesak.znak;
			}
		}
		else if(pjesak.pozicija == 'R') {
			if(Cesta.raskrizje[13][42] == '-' && pjesak.smjer == 'v') {
				pjesak.xPozicija = 13;
				pjesak.yPozicija = 42;
				Cesta.raskrizje[13][42] = pjesak.znak;
			}
			else if(Cesta.raskrizje[12][42] == '-' && pjesak.smjer == 'v') {
				pjesak.xPozicija = 12;
				pjesak.yPozicija = 42;
				Cesta.raskrizje[12][42] = pjesak.znak;
			}
			else if(Cesta.raskrizje[11][42] == '-' && pjesak.smjer == 'v') {
				pjesak.xPozicija = 11;
				pjesak.yPozicija = 42;
				Cesta.raskrizje[11][42] = pjesak.znak;
			}
			if(Cesta.raskrizje[17][40] == '-' && pjesak.smjer == '^') {
				pjesak.xPozicija = 17;
				pjesak.yPozicija = 40;
				Cesta.raskrizje[17][40] = pjesak.znak;
			}
			else if(Cesta.raskrizje[18][40] == '-' && pjesak.smjer == '^') {
				pjesak.xPozicija = 18;
				pjesak.yPozicija = 40;
				Cesta.raskrizje[18][40] = pjesak.znak;
			}
			else if(Cesta.raskrizje[19][40] == '-' && pjesak.smjer == '^') {
				pjesak.xPozicija = 19;
				pjesak.yPozicija = 40;
				Cesta.raskrizje[19][40] = pjesak.znak;
			}
		}
		else if(pjesak.pozicija == 'U') {
			if(Cesta.raskrizje[11][28] == '|' && pjesak.smjer == '>') {
				pjesak.xPozicija = 11;
				pjesak.yPozicija = 28;
				Cesta.raskrizje[11][28] = pjesak.znak;
			}
			else if(Cesta.raskrizje[11][27] == '|' && pjesak.smjer == '>') {
				pjesak.xPozicija = 11;
				pjesak.yPozicija = 27;
				Cesta.raskrizje[11][27] = pjesak.znak;
			}
			else if(Cesta.raskrizje[11][26] == '|' && pjesak.smjer == '>') {
				pjesak.xPozicija = 11;
				pjesak.yPozicija = 26;
				Cesta.raskrizje[11][26] = pjesak.znak;
			}
			if(Cesta.raskrizje[10][36] == '|' && pjesak.smjer == '<') {
				pjesak.xPozicija = 10;
				pjesak.yPozicija = 36;
				Cesta.raskrizje[10][36] = pjesak.znak;
			}
			else if(Cesta.raskrizje[10][37] == '|' && pjesak.smjer == '<') {
				pjesak.xPozicija = 10;
				pjesak.yPozicija = 37;
				Cesta.raskrizje[10][37] = pjesak.znak;
			}
			else if(Cesta.raskrizje[10][38] == '|' && pjesak.smjer == '<') {
				pjesak.xPozicija = 10;
				pjesak.yPozicija = 38;
				Cesta.raskrizje[10][38] = pjesak.znak;
			}
		}
		else if(pjesak.pozicija == 'D') {
			if(Cesta.raskrizje[19][28] == '|' && pjesak.smjer == '>') {
				pjesak.xPozicija = 19;
				pjesak.yPozicija = 28;
				Cesta.raskrizje[19][28] = pjesak.znak;
			}
			else if(Cesta.raskrizje[19][27] == '|' && pjesak.smjer == '>') {
				pjesak.xPozicija = 19;
				pjesak.yPozicija = 27;
				Cesta.raskrizje[19][27] = pjesak.znak;
			}
			else if(Cesta.raskrizje[19][26] == '|' && pjesak.smjer == '>') {
				pjesak.xPozicija = 19;
				pjesak.yPozicija = 26;
				Cesta.raskrizje[19][26] = pjesak.znak;
			}
			if(Cesta.raskrizje[20][36] == '|' && pjesak.smjer == '<') {
				pjesak.xPozicija = 20;
				pjesak.yPozicija = 36;
				Cesta.raskrizje[20][36] = pjesak.znak;
			}
			else if(Cesta.raskrizje[20][37] == '|' && pjesak.smjer == '<') {
				pjesak.xPozicija = 20;
				pjesak.yPozicija = 37;
				Cesta.raskrizje[20][37] = pjesak.znak;
			}
			else if(Cesta.raskrizje[20][38] == '|' && pjesak.smjer == '<') {
				pjesak.xPozicija = 20;
				pjesak.yPozicija = 38;
				Cesta.raskrizje[20][38] = pjesak.znak;
			}
		}
			
	}
	
	private static void dodjeliPozicijuObjektu(Objekti objekt) {
//		if(objekt.smjer == '>') {
//			int slobodnoDesno = 0;
//			while(Cesta.raskrizje[14][slobodnoDesno] == ' ') {
//				slobodnoDesno++;
//			}
//			if(slobodnoDesno >= objekt.duljina) {
//				Cesta.raskrizje[14][slobodnoDesno-1] = '>';
//				objekt.yPozicija = slobodnoDesno - 1;
//				if(objekt.duljina == 2) {
//					Cesta.raskrizje[14][slobodnoDesno-2] = (char)(objekt.id + 48);
//				}
//				else if(objekt.duljina == 3) {
//					Cesta.raskrizje[14][slobodnoDesno-3] = (char)(objekt.id/10 + 48);
//					Cesta.raskrizje[14][slobodnoDesno-2] = (char)(objekt.id%10 + 48);
//				}
//				else if(objekt.duljina == 4) {
//					Cesta.raskrizje[14][slobodnoDesno-4] = (char)(objekt.id/10 + 48);
//					Cesta.raskrizje[14][slobodnoDesno-3] = (char)(objekt.id%10 + 48);
//					Cesta.raskrizje[14][slobodnoDesno-2] = '*';
//				}
//				else if(objekt.duljina == 5) {
//					Cesta.raskrizje[14][slobodnoDesno-5] = (char)(objekt.id/10 + 48);
//					Cesta.raskrizje[14][slobodnoDesno-4] = (char)(objekt.id%10 + 48);
//					Cesta.raskrizje[14][slobodnoDesno-3] = '*';
//					Cesta.raskrizje[14][slobodnoDesno-2] = '*';
//				}
//			}
//		}
		if(objekt.smjer == '>') {
			int slobodnoDesno = 0;
			while(Cesta.raskrizje[14][slobodnoDesno] == ' ') {
				slobodnoDesno++;
			}
			if(slobodnoDesno >= objekt.duljina) {
				Cesta.raskrizje[14][slobodnoDesno-1] = '>';
				objekt.yPozicija = slobodnoDesno - 1;
				if(objekt.duljina == 2) {
					Cesta.raskrizje[14][slobodnoDesno-2] = (char)(objekt.id + 48);
				}
				else if(objekt.duljina == 3) {
					Cesta.raskrizje[14][slobodnoDesno-3] = (char)(objekt.id/10 + 48);
					Cesta.raskrizje[14][slobodnoDesno-2] = (char)(objekt.id%10 + 48);
				}
				else if(objekt.duljina == 4) {
					Cesta.raskrizje[14][slobodnoDesno-4] = (char)(objekt.id/10 + 48);
					Cesta.raskrizje[14][slobodnoDesno-3] = (char)(objekt.id%10 + 48);
					Cesta.raskrizje[14][slobodnoDesno-2] = '*';
				}
				else if(objekt.duljina == 5) {
					Cesta.raskrizje[14][slobodnoDesno-5] = (char)(objekt.id/10 + 48);
					Cesta.raskrizje[14][slobodnoDesno-4] = (char)(objekt.id%10 + 48);
					Cesta.raskrizje[14][slobodnoDesno-3] = '*';
					Cesta.raskrizje[14][slobodnoDesno-2] = '*';
				}
			}
		}
//		else if(objekt.smjer == '<') {
//			int slobodnoLijevo = 0;
//			int pom = 64;
//			while(Cesta.raskrizje[16][pom] == ' ') {
//				slobodnoLijevo++;
//				pom--;
//			}
//			if(slobodnoLijevo >= objekt.duljina) {
//				Cesta.raskrizje[16][64-slobodnoLijevo+1] = '<';
//				objekt.yPozicija = 64-slobodnoLijevo+1;
//				if(objekt.duljina == 2) {
//					Cesta.raskrizje[16][44-slobodnoLijevo+2] = (char)(objekt.id + 48);
//				}
//				else if(objekt.duljina == 3) {
//					Cesta.raskrizje[16][44-slobodnoLijevo+3] = (char)(objekt.id%10 + 48);
//					Cesta.raskrizje[16][44-slobodnoLijevo+2] = (char)(objekt.id/10 + 48);
//				}
//				else if(objekt.duljina == 4) {
//					Cesta.raskrizje[16][44-slobodnoLijevo+4] = (char)(objekt.id%10 + 48);
//					Cesta.raskrizje[16][44-slobodnoLijevo+3] = (char)(objekt.id/10 + 48);
//					Cesta.raskrizje[16][44-slobodnoLijevo+2] = '*';
//				}
//				else if(objekt.duljina == 5) {
//					Cesta.raskrizje[16][44-slobodnoLijevo+5] = (char)(objekt.id%10 + 48);
//					Cesta.raskrizje[16][44-slobodnoLijevo+4] = (char)(objekt.id/10 + 48);
//					Cesta.raskrizje[16][44-slobodnoLijevo+3] = '*';
//					Cesta.raskrizje[16][44-slobodnoLijevo+2] = '*';
//				}
//			}
//		}
		
		else if(objekt.smjer == '<') {
			int slobodnoLijevo = 0;
			int pom = 64;
			while(Cesta.raskrizje[16][pom] == ' ') {
				slobodnoLijevo++;
				pom--;
				}
			if(slobodnoLijevo >= objekt.duljina) {
				Cesta.raskrizje[16][64-slobodnoLijevo+1] = '<';
				objekt.yPozicija = 64-slobodnoLijevo+1;
				if(objekt.duljina == 2) {
					Cesta.raskrizje[16][64-slobodnoLijevo+2] = (char)(objekt.id + 48);
				}
				else if(objekt.duljina == 3) {
					Cesta.raskrizje[16][64-slobodnoLijevo+3] = (char)(objekt.id%10 + 48);
					Cesta.raskrizje[16][64-slobodnoLijevo+2] = (char)(objekt.id/10 + 48);
				}
				else if(objekt.duljina == 4) {
					Cesta.raskrizje[16][64-slobodnoLijevo+4] = (char)(objekt.id%10 + 48);
					Cesta.raskrizje[16][64-slobodnoLijevo+3] = (char)(objekt.id/10 + 48);
					Cesta.raskrizje[16][64-slobodnoLijevo+2] = '*';
				}
				else if(objekt.duljina == 5) {
					Cesta.raskrizje[16][64-slobodnoLijevo+5] = (char)(objekt.id%10 + 48);
					Cesta.raskrizje[16][64-slobodnoLijevo+4] = (char)(objekt.id/10 + 48);
					Cesta.raskrizje[16][64-slobodnoLijevo+3] = '*';
					Cesta.raskrizje[16][64-slobodnoLijevo+2] = '*';
				}
			}
		}
		
		else if(objekt.smjer == 'v') {
			int slobodnoDolje = 0;
			while(Cesta.raskrizje[slobodnoDolje][30] == ' ') {
				slobodnoDolje++;
			}
			if(slobodnoDolje >= objekt.duljina) {
				Cesta.raskrizje[slobodnoDolje-1][30] = 'v';
				objekt.xPozicija=slobodnoDolje-1;
				if(objekt.duljina==2) {
					Cesta.raskrizje[slobodnoDolje-2][30]=(char)(objekt.id+48);
				}
				else if(objekt.duljina == 3) {
					Cesta.raskrizje[slobodnoDolje-3][30]=(char)(objekt.id/10+48);
					Cesta.raskrizje[slobodnoDolje-2][30]=(char)(objekt.id%10+48);
				}
				else if(objekt.duljina==4) {
					Cesta.raskrizje[slobodnoDolje-4][30]=(char)(objekt.id/10+48);
					Cesta.raskrizje[slobodnoDolje-3][30]=(char)(objekt.id%10+48);
					Cesta.raskrizje[slobodnoDolje-2][30]='*';
				}
				else if(objekt.duljina==5) {
					Cesta.raskrizje[slobodnoDolje-5][30]=(char)(objekt.id/10+48);
					Cesta.raskrizje[slobodnoDolje-4][30]=(char)(objekt.id%10+48);
					Cesta.raskrizje[slobodnoDolje-3][30]='*';
					Cesta.raskrizje[slobodnoDolje-2][30]='*';
				}
			}
		}
		
		else if(objekt.smjer == '^') {
			int slobodnoGore = 0;
			int pom = 30;
			while(Cesta.raskrizje[pom][30] == ' ') {
				slobodnoGore++;
				pom--;
			}
			if(slobodnoGore >= objekt.duljina) {
				Cesta.raskrizje[30-slobodnoGore+1][34]= '^';
				objekt.xPozicija = 30 - slobodnoGore+1;
				if(objekt.duljina == 2) {
					Cesta.raskrizje[30-slobodnoGore+2][34] = (char)(objekt.id+48);
				}
				else if(objekt.duljina==3) {
					Cesta.raskrizje[30-slobodnoGore+2][34] = (char)(objekt.id/10+48);
					Cesta.raskrizje[30-slobodnoGore+3][34] = (char)(objekt.id%10+48);
				}
				else if(objekt.duljina == 4) {
				Cesta.raskrizje[30-slobodnoGore+2][34] = '*';
					Cesta.raskrizje[30-slobodnoGore+3][34] = (char)(objekt.id/10+48);
					Cesta.raskrizje[30-slobodnoGore+4][34] = (char)(objekt.id%10+48);
				}
				else if(objekt.duljina == 5) {
					Cesta.raskrizje[30-slobodnoGore+2][34] = '*';
					Cesta.raskrizje[30-slobodnoGore+3][34] = '*';
					Cesta.raskrizje[30-slobodnoGore+4][34] = (char)(objekt.id/10+48);
					Cesta.raskrizje[30-slobodnoGore+5][34] = (char)(objekt.id%10+48);
				}
			}
		}
		
		
	}
	
//	private static void pomakniObjektDesno(Objekti objekt, double vrijeme) {
//		if(objekt.yPozicija >= 64) {
//			Cesta.raskrizje[14][objekt.yPozicija] = ' ';
//		}
//		else {
//			Cesta.raskrizje[14][objekt.yPozicija+1] = Cesta.raskrizje[14][objekt.yPozicija];
//		}
//		
//		if(objekt.duljina == 2) {
//			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
//		}
//		else if(objekt.duljina == 3) {
//			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
//			Cesta.raskrizje[14][objekt.yPozicija-1] = Cesta.raskrizje[14][objekt.yPozicija-2];
//		}
//		else if(objekt.duljina == 4) {
//			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
//			Cesta.raskrizje[14][objekt.yPozicija-1] = Cesta.raskrizje[14][objekt.yPozicija-2];
//			Cesta.raskrizje[14][objekt.yPozicija-2] = Cesta.raskrizje[14][objekt.yPozicija-3];			
//		}
//		else if(objekt.duljina == 5) {
//			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
//			Cesta.raskrizje[14][objekt.yPozicija-1] = Cesta.raskrizje[14][objekt.yPozicija-2];
//			Cesta.raskrizje[14][objekt.yPozicija-2] = Cesta.raskrizje[14][objekt.yPozicija-3];
//			Cesta.raskrizje[14][objekt.yPozicija-3] = Cesta.raskrizje[14][objekt.yPozicija-4];
//		}
//		Cesta.raskrizje[14][objekt.yPozicija-objekt.duljina+1] = ' ';
//		if(objekt.yPozicija >= 64) {
//			objekt.yPozicija--;
//			objekt.duljina--;
//		}
//		objekt.yPozicija++;
//		objekt.vrijemeKretanja = vrijeme;
//
//		
//	}
//	
	private static void pomakniObjektDesno(Objekti objekt, double vrijeme) {
		if(objekt.yPozicija >= 64) {
			Cesta.raskrizje[14][objekt.yPozicija] = ' ';
		}
		else {
			Cesta.raskrizje[14][objekt.yPozicija+1] = Cesta.raskrizje[14][objekt.yPozicija];
		}
		
		if(objekt.duljina == 2) {
			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
		}
		else if(objekt.duljina == 3) {
			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
			Cesta.raskrizje[14][objekt.yPozicija-1] = Cesta.raskrizje[14][objekt.yPozicija-2];
		}
		else if(objekt.duljina == 4) {
			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
			Cesta.raskrizje[14][objekt.yPozicija-1] = Cesta.raskrizje[14][objekt.yPozicija-2];
			Cesta.raskrizje[14][objekt.yPozicija-2] = Cesta.raskrizje[14][objekt.yPozicija-3];			
		}
		else if(objekt.duljina == 5) {
			Cesta.raskrizje[14][objekt.yPozicija] = Cesta.raskrizje[14][objekt.yPozicija-1];
			Cesta.raskrizje[14][objekt.yPozicija-1] = Cesta.raskrizje[14][objekt.yPozicija-2];
			Cesta.raskrizje[14][objekt.yPozicija-2] = Cesta.raskrizje[14][objekt.yPozicija-3];
			Cesta.raskrizje[14][objekt.yPozicija-3] = Cesta.raskrizje[14][objekt.yPozicija-4];
		}
		Cesta.raskrizje[14][objekt.yPozicija-objekt.duljina+1] = ' ';
		if(objekt.yPozicija >= 64) {
			objekt.yPozicija--;
			objekt.duljina--;
		}
		objekt.yPozicija++;
		objekt.vrijemeKretanja = vrijeme;

		
	}
	
	
	

//	private static void pomakniObjektLijevo(Objekti objekt, double vrijeme) {
//		if(objekt.yPozicija <= 0) {
//			Cesta.raskrizje[16][objekt.yPozicija] = ' ';
//		}
//		else {
//			Cesta.raskrizje[16][objekt.yPozicija-1] = Cesta.raskrizje[16][objekt.yPozicija];
//		}
//		
//		if(objekt.duljina == 2) {
//			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
//		}
//		else if(objekt.duljina == 3) {
//			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
//			Cesta.raskrizje[16][objekt.yPozicija+1] = Cesta.raskrizje[16][objekt.yPozicija+2];
//		}
//		else if(objekt.duljina == 4) {
//			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
//			Cesta.raskrizje[16][objekt.yPozicija+1] = Cesta.raskrizje[16][objekt.yPozicija+2];
//			Cesta.raskrizje[16][objekt.yPozicija+2] = Cesta.raskrizje[16][objekt.yPozicija+3];
//		}
//		else if(objekt.duljina == 5) {
//			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
//			Cesta.raskrizje[16][objekt.yPozicija+1] = Cesta.raskrizje[16][objekt.yPozicija+2];
//			Cesta.raskrizje[16][objekt.yPozicija+2] = Cesta.raskrizje[16][objekt.yPozicija+3];
//			Cesta.raskrizje[16][objekt.yPozicija+3] = Cesta.raskrizje[16][objekt.yPozicija+4];
//		}
//		
//		Cesta.raskrizje[16][objekt.yPozicija+objekt.duljina-1] = ' ';
//		if(objekt.yPozicija <= 0) {
//			objekt.yPozicija++;
//			objekt.duljina--;
//		}
//		objekt.yPozicija--;
//		objekt.vrijemeKretanja = vrijeme;
//		
//	}
	private static void pomakniObjektLijevo(Objekti objekt, double vrijeme) {
		if(objekt.yPozicija <= 0) {
			Cesta.raskrizje[16][objekt.yPozicija] = ' ';
		}
		else {
			Cesta.raskrizje[16][objekt.yPozicija-1] = Cesta.raskrizje[16][objekt.yPozicija];
		}
		
		if(objekt.duljina == 2) {
			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
		}
		else if(objekt.duljina == 3) {
			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
			Cesta.raskrizje[16][objekt.yPozicija+1] = Cesta.raskrizje[16][objekt.yPozicija+2];
		}
		else if(objekt.duljina == 4) {
			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
			Cesta.raskrizje[16][objekt.yPozicija+1] = Cesta.raskrizje[16][objekt.yPozicija+2];
			Cesta.raskrizje[16][objekt.yPozicija+2] = Cesta.raskrizje[16][objekt.yPozicija+3];
		}
		else if(objekt.duljina == 5) {
			Cesta.raskrizje[16][objekt.yPozicija] = Cesta.raskrizje[16][objekt.yPozicija+1];
			Cesta.raskrizje[16][objekt.yPozicija+1] = Cesta.raskrizje[16][objekt.yPozicija+2];
			Cesta.raskrizje[16][objekt.yPozicija+2] = Cesta.raskrizje[16][objekt.yPozicija+3];
			Cesta.raskrizje[16][objekt.yPozicija+3] = Cesta.raskrizje[16][objekt.yPozicija+4];
		}
		
		Cesta.raskrizje[16][objekt.yPozicija+objekt.duljina-1] = ' ';
		if(objekt.yPozicija <= 0) {
			objekt.yPozicija++;
			objekt.duljina--;
		}
		objekt.yPozicija--;
		objekt.vrijemeKretanja = vrijeme;
		
	}
	private static void pomakniObjektDolje(Objekti objekt, double vrijeme) {
		if(objekt.xPozicija >= 30) {
			Cesta.raskrizje[objekt.xPozicija][30] = ' ';
		} 
		else {
			Cesta.raskrizje[objekt.xPozicija+1][30] = Cesta.raskrizje[objekt.xPozicija][30];
		}
		if(objekt.duljina == 2) {
			Cesta.raskrizje[objekt.xPozicija][30] = Cesta.raskrizje[objekt.xPozicija-1][30];
		}
		else if(objekt.duljina == 3) {
			Cesta.raskrizje[objekt.xPozicija][30] = Cesta.raskrizje[objekt.xPozicija-1][30];
			Cesta.raskrizje[objekt.xPozicija-1][30] = Cesta.raskrizje[objekt.xPozicija-2][30];
		}
		else if(objekt.duljina == 4) {
			Cesta.raskrizje[objekt.xPozicija][30] = Cesta.raskrizje[objekt.xPozicija-1][30];
			Cesta.raskrizje[objekt.xPozicija-1][30] = Cesta.raskrizje[objekt.xPozicija-2][30];
			Cesta.raskrizje[objekt.xPozicija-2][30] = Cesta.raskrizje[objekt.xPozicija-3][30];
		}
		else if(objekt.duljina == 5) {
			Cesta.raskrizje[objekt.xPozicija][30] = Cesta.raskrizje[objekt.xPozicija-1][30];
			Cesta.raskrizje[objekt.xPozicija-1][30] = Cesta.raskrizje[objekt.xPozicija-2][30];
			Cesta.raskrizje[objekt.xPozicija-2][30] = Cesta.raskrizje[objekt.xPozicija-3][30];
			Cesta.raskrizje[objekt.xPozicija-3][30] = Cesta.raskrizje[objekt.xPozicija-4][30];
		}
		Cesta.raskrizje[objekt.xPozicija-objekt.duljina+1][30]=' ';
		if(objekt.xPozicija >= 30) {
			objekt.xPozicija--;
			objekt.duljina--;
		}
		objekt.xPozicija++;
		objekt.vrijemeKretanja=vrijeme;
	}

//	private static void pomakniObjektGore(Objekti objekt, double vrijeme) {
//		if(objekt.xPozicija <= 0) {
//			Cesta.raskrizje[objekt.xPozicija][34] = ' ';
//		}
//		else {
//			Cesta.raskrizje[objekt.xPozicija-1][34]=Cesta.raskrizje[objekt.xPozicija][34];
//		}
//		
//		if(objekt.duljina==2) {
//			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
//		}
//		else if(objekt.duljina == 3) {
//			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
//			Cesta.raskrizje[objekt.xPozicija+1][34]=Cesta.raskrizje[objekt.xPozicija+2][34];
//		}
//		else if(objekt.duljina==4) {
//			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
//			Cesta.raskrizje[objekt.xPozicija+1][34]=Cesta.raskrizje[objekt.xPozicija+2][34];
//			Cesta.raskrizje[objekt.xPozicija+2][34]=Cesta.raskrizje[objekt.xPozicija+3][34];
//		}
//		else if(objekt.duljina==5) {
//			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
//			Cesta.raskrizje[objekt.xPozicija+1][34]=Cesta.raskrizje[objekt.xPozicija+2][34];
//			Cesta.raskrizje[objekt.xPozicija+2][34]=Cesta.raskrizje[objekt.xPozicija+3][34];
//			Cesta.raskrizje[objekt.xPozicija+3][34]=Cesta.raskrizje[objekt.xPozicija+4][34];
//		}
//		Cesta.raskrizje[objekt.xPozicija+objekt.duljina-1][34]=' ';
//		if(objekt.xPozicija<=0) {
//			objekt.xPozicija++;
//			objekt.duljina--;
//		}
//		objekt.xPozicija--;
//		objekt.vrijemeKretanja = vrijeme;
//		
//	}
	private static void pomakniObjektGore(Objekti objekt, double vrijeme) {
		if(objekt.xPozicija <= 0) {
			Cesta.raskrizje[objekt.xPozicija][34] = ' ';
		} 
		else {
			Cesta.raskrizje[objekt.xPozicija-1][34] = Cesta.raskrizje[objekt.xPozicija][34];
		}
		if(objekt.duljina == 2) {
			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
		}
		if(objekt.duljina == 3) {
			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
			Cesta.raskrizje[objekt.xPozicija+1][34]=Cesta.raskrizje[objekt.xPozicija+2][34];
		}
		if(objekt.duljina == 4) {
			Cesta.raskrizje[objekt.xPozicija][30]=Cesta.raskrizje[objekt.xPozicija+1][34];
			Cesta.raskrizje[objekt.xPozicija+1][34]=Cesta.raskrizje[objekt.xPozicija+2][34];
			Cesta.raskrizje[objekt.xPozicija+2][34]=Cesta.raskrizje[objekt.xPozicija+3][34];
		}
		else if(objekt.duljina == 5) {
			Cesta.raskrizje[objekt.xPozicija][34]=Cesta.raskrizje[objekt.xPozicija+1][34];
			Cesta.raskrizje[objekt.xPozicija+1][34]=Cesta.raskrizje[objekt.xPozicija+2][34];
			Cesta.raskrizje[objekt.xPozicija+2][34]=Cesta.raskrizje[objekt.xPozicija+3][34];
			Cesta.raskrizje[objekt.xPozicija+3][34]=Cesta.raskrizje[objekt.xPozicija+4][34];
		}
		Cesta.raskrizje[objekt.xPozicija + objekt.duljina - 1][34] = ' ';
		if(objekt.xPozicija <= 0) {
			objekt.xPozicija++;
			objekt.duljina--;
		}
		objekt.xPozicija--;
		objekt.vrijemeKretanja = vrijeme;
		
	}

	
	
	private static boolean nePostojiPjesak(ArrayList p1, ArrayList p2, ArrayList p3, ArrayList p4, ArrayList p5, ArrayList p6, ArrayList p7, ArrayList p8, char pom) {
		for(int i = 0; i < p1.size(); i++) {
			if(((Pjesak)p1.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p2.size(); i++) {
			if(((Pjesak)p2.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p3.size(); i++) {
			if(((Pjesak)p3.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p4.size(); i++) {
			if(((Pjesak)p4.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p5.size(); i++) {
			if(((Pjesak)p5.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p6.size(); i++) {
			if(((Pjesak)p6.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p7.size(); i++) {
			if(((Pjesak)p7.get(i)).znak == pom) {
				return false;
			}
		}
		for(int i = 0; i < p8.size(); i++) {
			if(((Pjesak)p8.get(i)).znak == pom) {
				return false;
			}
		}
		return true;
		
		
		
	}

	private static boolean nePostojiObjekt(ArrayList objektDesno, ArrayList objektLijevo, ArrayList objektGore, ArrayList objektDolje,int idObjekta) {
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
		for(int i = 0; i < objektGore.size(); i++) {
			if(((Objekti)objektGore.get(i)).id == idObjekta) {
				return false;
			}
		}
		for(int i = 0; i < objektDolje.size(); i++) {
			if(((Objekti)objektDolje.get(i)).id == idObjekta) {
				return false;
			}
		}
		return true;
		
		
		
	}
	
	
	 
}