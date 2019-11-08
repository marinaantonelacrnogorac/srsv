


public class Pjesak {
	
	public int brzina;
	public char smjer;
	public char znak;
	public int xPozicija;
	public int yPozicija;
	public boolean gibanje = false;
	public double vrijemeKretanja = 0;
	public char pozicija;
	
	public Pjesak(int brzina, char smjer, char znak, char pozicija) {
		this.brzina = brzina;
		this.smjer = smjer;
		this.znak = znak;
		this.pozicija = pozicija;
	}
	
	/*public void Kretanje() {
		if(smjer == 'v') {
			yPozicija++;
		}else if(smjer == '^') {
			yPozicija--;
		}
		
	}
	
	public void Ispis() {
		System.out.println("Brzina: " + brzina + "Smjer: " +smjer+" Znak" +znak);
	}*/
}
