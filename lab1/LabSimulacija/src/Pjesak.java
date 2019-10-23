


public class Pjesak {
	
	public int brzina;
	public char smjer;
	public char znak;
	public int xPozicija;
	public int yPozicija;
	public boolean gibanje = false;
	public double vrijemeKretanja = 0;
	
	public Pjesak(int brzina, char smjer, char znak) {
		this.brzina = brzina;
		this.smjer = smjer;
		this.znak = znak;
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
