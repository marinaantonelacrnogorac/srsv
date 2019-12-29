package srsv3;

import java.util.Random;

public class Putnik {

	
	private char znak;
	private int trenutniKat;
	private int oznaceniKat;
	public Direction SmjerPutnika;
	private PassengerStatus statusPutnika;
	
	private Lift mojLift;
	
	public Putnik(int trenutniKat, int oznaceniKat) {
		this.trenutniKat=trenutniKat;
		this.statusPutnika=PassengerStatus.WaitingForAnElevator;
		this.oznaceniKat=oznaceniKat;
		
		Random random = new Random();
		int slovo = random.nextInt(90)+65;
		this.znak = (char) slovo;
	}
	
	private void udjiULift(Lift lift) {
		this.mojLift=lift;
	}
	
	public void liftJeDosaoNaSljedeciKat() {
		if(this.mojLift.GetTrenutniKat() == this.oznaceniKat) {
			this.statusPutnika=PassengerStatus.LeavingTheBuilding;
			//ThreadPool.QueueUserWorkItem(delegate { GetOutOfTheElevator(this.myElevator); });
		}
	}
	
	private void izadjiIzLifta(Lift lift) {
		lift.ukloniPutnika(this);
	}
	
	private void OsvjeziSmjerPutnika() {
		if(trenutniKat < oznaceniKat) {
			this.SmjerPutnika=Direction.Up;
		}
		else {
			this.SmjerPutnika=Direction.Down;
		}
		
	}
	
	
	private boolean ElevatorsDireectionIsNoneOrOk(Lift lift) {
		if(lift.GetSmjerLifta()==this.SmjerPutnika) {
			return true;
		}else if(lift.GetSmjerLifta() == Direction.None) {
			return true;
		}
		return false;
	}
	
	public int GetOznaceniKat() {
		return this.oznaceniKat;
	}
	
	public int GetTrenutniKat() {
		return this.trenutniKat;
	}
	
	public char GetZnak() {
		return this.znak;
	}
	
}
