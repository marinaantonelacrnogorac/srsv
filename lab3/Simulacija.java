package srsv3;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Simulacija {
	
	//private final static Object locker = new Object();
	
	ReentrantLock lock = new ReentrantLock();
	
	public static ArrayList<Putnik> popisSvih = new ArrayList<Putnik>();
	public static ArrayList<Putnik> popisKat1 = new ArrayList<Putnik>();
	public static ArrayList<Putnik> popisKat2 = new ArrayList<Putnik>();
	public static ArrayList<Putnik> popisKat3 = new ArrayList<Putnik>();
	public static ArrayList<Putnik> popisKat4 = new ArrayList<Putnik>();

	static Lift lift = new Lift(1,6);
	
	public static void main(String[] args) throws InterruptedException, IOException {
		GeneratePutnik();
		Crtanje();
		ispisiKatove();
		ispisiLift();
		liftLogic();
		enterLift();
	}
	
	public static void GeneratePutnik() throws InterruptedException {
		
		while(true) {
			Random random = new Random();
			int trenutniKat=random.nextInt(4)+1;
			int oznaceniKat=random.nextInt(3)+1;
			if(trenutniKat==oznaceniKat) {
				oznaceniKat++;
			}
			
			Putnik tmp = new Putnik(trenutniKat, oznaceniKat);
			
		        popisSvih.add(tmp);
		        switch(tmp.GetTrenutniKat()) {
		        case 1:
		        	if(popisKat1.size()<10) {
		        		popisKat1.add(tmp);
		        	} 
		        	else {
		        		popisKat1.remove(tmp);
		        	}
		        	break;
		        	
		        	
		        case 2:
		        	if(popisKat2.size()<10) {
		        		popisKat2.add(tmp);
		        	} 
		        	else {
		        		popisKat2.remove(tmp);
		        	}
		        	break;
		        	
		        case 3:
		        	if(popisKat3.size()<10) {
		        		popisKat3.add(tmp);
		        	} 
		        	else {
		        		popisKat3.remove(tmp);
		        	}
		        	break;
		        	
		        case 4:
		        	if(popisKat4.size()<10) {
		        		popisKat4.add(tmp);
		        	} 
		        	else {
		        		popisKat4.remove(tmp);
		        	}
		        	break;
		        		
		        }
		    
//		    Thread.sleep(2800);
			
		}
	}
	
	public static void Crtanje() throws InterruptedException {
		
		while(true) {
//			Thread.sleep(300);
			
		       int i = 11;
		       for(Putnik temp : popisKat1){
		    	   Global.lift[7][i] = temp.GetZnak();
		    	   i--;
		       }
		       i = 11;
		       for(Putnik temp : popisKat2) {
		    	   Global.lift[5][i] = temp.GetZnak();
		    	   i--;
		       }
		       i = 11;
		       for(Putnik temp : popisKat3) {
		    	   Global.lift[3][i] = temp.GetZnak();
		    	   i--;
		       }
		       i = 11;
		       for(Putnik temp : popisKat4) {
		    	   Global.lift[1][i] = temp.GetZnak();
		    	   i--;
		       }
		    
		}
	}
	
	public static void ispisiKatove() throws InterruptedException, IOException {
		char vrata;
		char smjer;
		while(true) {
			
			if(lift.GetStanjeVrata()) {
				vrata='O';
			} else {
				vrata = 'Z';
			}
			
			if(lift.GetSmjerLifta() == Direction.Up) {
				smjer='G';
			} else {
				smjer='D';
			}
			
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("              Lift1      Lift2");
			System.out.println("Smjer/vrata:    " + smjer + "" +vrata);
			
		        for(int i= 0; i < Global.lift.length;i++) {
		        	for(int j=0; i < Global.lift[0].length; j++) {
		        		System.out.println(Global.lift[i][j]);
		        	}
		        	System.out.println();
		        }
		        
		        System.out.println("Putnici");
		        
		        for(Putnik temp : popisSvih) {
		        	System.out.println(temp.GetZnak());
		        }
		        System.out.println("\nOd:      ");
		        
		        for(Putnik temp : popisSvih) {
		        	System.out.println(temp.GetTrenutniKat());
		        }
		        System.out.println("\nOd:      ");
		        
		        for(Putnik temp : popisSvih) {
		        	System.out.println(temp.GetOznaceniKat());
		        }
		        System.out.println();
		        System.out.println(lift.GetSmjerLifta());
		        System.out.println(lift.GetStatusLifta());
		        System.out.println(lift.GetStanjeVrata());
		        System.out.println(lift.GetTrenutniKat());
		        
		    
//		    Thread.sleep(200);
		
		}
	}
	
	public static void ispisiLift() throws InterruptedException {
		while(true) {
//			Thread.sleep(200);
			
			
		        for(int ii = 1; ii < 8; ii++) {
		        	for(int jj=13; jj < 21; jj++) {
		        		Global.lift[ii][jj] = ' ';
		        	}
		        }
		        ArrayList<Putnik> tempPutnik= lift.GetPopisLjudi();
		        double tempKat = lift.GetTrenutniKatIndex();
		        int i=14;
		        if(tempKat == 1.0) {
		        	Global.lift[7][13]='[';
		        	Global.lift[7][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[7][i] = temp.GetZnak();
		        		i++;
		        	}
		        } else if(tempKat==1.5) {
		        	Global.lift[6][13] = '[';
		        	Global.lift[6][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[6][i]=temp.GetZnak();
		        		i++;
		        	} 
		        } else if(tempKat==2.0) {
		        	Global.lift[5][13] = '[';
		        	Global.lift[5][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[5][i] = temp.GetZnak();
		        		i++;
		        	}
		        } else if(tempKat == 2.5) {
		        	Global.lift[4][13] = '[';
		        	Global.lift[4][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[4][i] = temp.GetZnak();
		        		i++;
		        	}
		        } else if(tempKat == 3.0) {
		        	Global.lift[3][13] = '[';
		        	Global.lift[3][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[3][i] = temp.GetZnak();
		        		i++;
		        	}
		        } else if(tempKat == 3.5) {
		        	Global.lift[2][13] = '[';
		        	Global.lift[2][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[2][i] = temp.GetZnak();
		        		i++;
		        	}
		        } else if(tempKat==4.0) {
		        	Global.lift[1][13] = '[';
		        	Global.lift[1][13+lift.GetMaxLjudi()+1]=']';
		        	for(Putnik temp : tempPutnik) {
		        		Global.lift[1][i] = temp.GetZnak();
		        		i++;
		        	}
		        }
		   
		}
		
	}
	
	public static void liftLogic() throws InterruptedException {
		while(true) {
		
			if(lift.GetPopisLjudi().size()!= 0) {
				lift.idiNaSljedeciKat();
			}
			lift.SetStanjeVrata(true);
//			Thread.sleep(5000);
			ArrayList<Putnik> izadji = lift.GetPopisLjudi();
			for(Putnik izbaci : izadji) {
				if(izbaci.GetOznaceniKat() == lift.GetTrenutniKat()) {
					lift.ukloniPutnika(izbaci);
				}
			}
		}
	}
	
	
	public static void enterLift() {
		while(true) {
			
			switch(lift.GetTrenutniKat()) {
			case 1:
				
			        for(Putnik temp : popisKat1) {
			        	if((temp.SmjerPutnika == lift.GetSmjerLifta() || lift.GetSmjerLifta() == Direction.None) && lift.GetStanjeVrata()) {
			        		if(lift.dodajNovogPutnika(temp, temp.GetOznaceniKat())) {
			        			popisKat1.remove(temp);
			        			break;
			        		}
			        	}
			        	
			        }

			        break;
			   
			    
			case 2:
				
			        for(Putnik temp : popisKat2) {
			        	if((temp.SmjerPutnika == lift.GetSmjerLifta() || lift.GetSmjerLifta() == Direction.None) && lift.GetStanjeVrata()) {
			        		if(lift.dodajNovogPutnika(temp, temp.GetOznaceniKat())) {
			        			popisKat2.remove(temp);
			        			break;
			        		}
			        	}
			        }
			        break;
			   
			    
			case 3:
				
			        for(Putnik temp : popisKat3) {
			        	if((temp.SmjerPutnika == lift.GetSmjerLifta() || lift.GetSmjerLifta() == Direction.None) && lift.GetStanjeVrata()) {
			        		if(lift.dodajNovogPutnika(temp, temp.GetOznaceniKat())) {
			        			popisKat3.remove(temp);
			        			break;
			        		}
			        	}
			        }
			        break;
			   
			    
			case 4:
				
			        for(Putnik temp : popisKat4) {
			        	if((temp.SmjerPutnika == lift.GetSmjerLifta() || lift.GetSmjerLifta() == Direction.None) && lift.GetStanjeVrata()) {
			        		if(lift.dodajNovogPutnika(temp, temp.GetOznaceniKat())) {
			        			popisKat4.remove(temp);
			        			break;
			        		}
			        	}
			        }
			        break;
			   
			}
			
		}
		
	}
	 


}


