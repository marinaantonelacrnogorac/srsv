package srsv3;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.swing.Timer;

public class Lift {

	
	ReentrantLock lock = new ReentrantLock();
	
	private int trenutniKat;
	private double trenutniKatIndex;
	private ArrayList<Integer> popisKatova;
	private Direction smjerLifta;
	private ElevatorStatus statusLifta;
	
	private int maxLjudi;
	private ArrayList<Putnik> popisLjudiuLiftu;
	private boolean popunjen;
	private boolean otvorenaVrata;
	
	
//	private Timer vrijemeLifta;
	
	public Lift(int pocetniKat, int maxLjudi) {
		this.trenutniKat=pocetniKat;
		this.trenutniKatIndex=(float)pocetniKat;
		this.popisKatova = new ArrayList<Integer>();
		this.smjerLifta = Direction.None;
		this.statusLifta = ElevatorStatus.Idle;
		
		this.maxLjudi = maxLjudi;
		this.popisLjudiuLiftu = new ArrayList<Putnik>();
		this.popunjen=false;
		this.otvorenaVrata=true;
		
//		this.vrijemeLifta.start();
		
	}
	
	
	private boolean putnikZeliIzaciNaOvomKatu() {
		for(Putnik PutnikULiftu : popisLjudiuLiftu){
			if(PutnikULiftu.GetOznaceniKat() == this.trenutniKat) {
				return true;
			}
		
		}
		return false;	
	}
	
	public int GetTrenutniKat() {
		return trenutniKat;
	}
	
	public double GetTrenutniKatIndex() {
		return trenutniKatIndex;
	}
	
	private int GetSljedeciKatZaPosjetit() {
		
	        if(popisKatova.size() > 0) {
	        	return this.popisKatova.get(0);
	        }
	        else {
	        	return 0;
	        }
	    
		
	}
	
	public ArrayList<Integer> GetPopisKatovaZaPosjetit(){
		
	        return popisKatova;
	   
	}
	
	private void osvjeziSmjer() {
		if(GetSljedeciKatZaPosjetit() == 0) {
			this.smjerLifta = Direction.None;
			return;
		}
		
		if(trenutniKat < GetSljedeciKatZaPosjetit()) {
			this.smjerLifta = Direction.Up;
		}
		else {
			this.smjerLifta = Direction.Down;
		}
	}
	
	public boolean dodajNovogPutnika(Putnik noviPutnik, int oznaceniKat) {
		if(!popunjen && ((GetStatusLifta() == ElevatorStatus.Idle) || (GetStatusLifta() == ElevatorStatus.WaitingForPassengersToGetInAndGetOut))){
//			this.ResetTimerLifta();
			
			this.popisLjudiuLiftu.add(noviPutnik);
			this.dodajNoviKat(oznaceniKat);
			
			if(this.popisLjudiuLiftu.size() >= this.maxLjudi) {
				this.popunjen=true;
				this.setStatusLifta(ElevatorStatus.PreparingForJob);
			}
			return true;
			} else {
				return false;
			}
	}
	
	public void dodajNoviKat(int noviKat) {
		
	       if(GetPopisKatovaZaPosjetit().contains(noviKat)) {
	    	   return;
	       }
	       
	       if(this.trenutniKat < noviKat) {
	    	   for(int i = this.trenutniKat+1; i <= noviKat; i++) {
	    		   if(!GetPopisKatovaZaPosjetit().contains(i)) {
	    			   GetPopisKatovaZaPosjetit().add(i);
	    		   }
	    	   }
	       }
	       
	       
	       if(this.trenutniKat > noviKat) {
	    	   for(int i = this.trenutniKat-1; i >= noviKat; i--) {
	    		   if(!GetPopisKatovaZaPosjetit().contains(i)) {
	    			   GetPopisKatovaZaPosjetit().add(i);
	    		   }
	    	   }
	       }
	       
	     osvjeziSmjer();
	       
	   
		
	}
	
	public void ukloniPutnika(Putnik putnik) {
		
	        this.popisLjudiuLiftu.remove(putnik);
	        this.popunjen=false;
	   
	}
	
	public void ResetTimerLifta() {
		
//	        this.vrijemeLifta.restart();	        
	   
	}
	
	public void idiNaSljedeciKat() throws InterruptedException {
		this.otvorenaVrata=false;
		if(smjerLifta == Direction.Down) {
			this.setStatusLifta(ElevatorStatus.GoingDown);
			this.trenutniKatIndex-=0.5;
			Thread.sleep(500);
			this.trenutniKatIndex-=0.5;			
		} else if(smjerLifta == Direction.Up) {
			this.setStatusLifta(ElevatorStatus.GoingUp);
			this.trenutniKatIndex += 0.5;
			Thread.sleep(500);
			this.trenutniKatIndex += 0.5;
		}
		
		this.trenutniKat=GetSljedeciKatZaPosjetit();
		this.setStatusLifta(ElevatorStatus.Idle);
		
		this.popisKatova.remove(0);
		osvjeziSmjer();
	}
	
	private void zavrsiOdlazakNaSljedeciKat() {
		this.otvorenaVrata = true;
		setStatusLifta(ElevatorStatus.WaitingForPassengersToGetInAndGetOut);
		
		ArrayList<Putnik> ljudiULiftu = new ArrayList<Putnik>(popisLjudiuLiftu);
		
		for(Putnik covjekuLiftu : ljudiULiftu){
			covjekuLiftu.liftJeDosaoNaSljedeciKat();
		}
		
//		this.vrijemeLifta.start();		
		
	}
	
	public ElevatorStatus GetStatusLifta() {
		
	        return this.statusLifta;
	    
	}
	
	private void setStatusLifta(ElevatorStatus Status) {
		
	       this.statusLifta= Status;
	   
	}
	
	public void PripremiLiftZaSljedeciKat() throws InterruptedException {
		setStatusLifta(ElevatorStatus.PreparingForJob);
		
//		this.vrijemeLifta.stop();
		this.otvorenaVrata=false;
		idiNaSljedeciKat();
	}
	
	public Direction GetSmjerLifta() {
		
	        return smjerLifta;
	    
	}
	
	public int GetMaxLjudi() {
		return maxLjudi;
	}
	
	public boolean GetStanjeVrata() {
		return otvorenaVrata;
	}
	
	public void SetStanjeVrata(boolean stanje) {
		this.otvorenaVrata=stanje;
	}
	
	public ArrayList<Putnik> GetPopisLjudi(){
		return popisLjudiuLiftu;
	}	
	
	
	public void GoToDesignatedFloor(int floor) throws InterruptedException {
		this.otvorenaVrata=false;
		while(this.trenutniKat!=floor) {
			if(this.trenutniKat>floor) {
				this.smjerLifta=Direction.Down;
				this.setStatusLifta(ElevatorStatus.GoingDown);
				this.trenutniKatIndex-=0.5;
				Thread.sleep(700);
				this.trenutniKatIndex-=0.5;
			} 
			else if(this.trenutniKat<floor){
				this.smjerLifta=Direction.Up;
				this.setStatusLifta(ElevatorStatus.GoingUp);
				this.trenutniKatIndex+=0.5;
				Thread.sleep(700);
				this.trenutniKatIndex+=0.5;
			}
			this.trenutniKat=(int)trenutniKatIndex;
			Thread.sleep(500);
		}
		this.setStatusLifta(ElevatorStatus.Idle);
		osvjeziSmjer();
		this.otvorenaVrata=true;
		return;
	}
}
