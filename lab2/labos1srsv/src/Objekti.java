


public class Objekti {
	
	public int id;
	public int duljina;
	public int brzina;
	public char smjer;
	public boolean gibanje=false;
	public int xPozicija;
	public int yPozicija;
	public double vrijemeKretanja=0;
	
	public Objekti(int id, int brzina, char smjer) {
		
		this.id = id;
		this.brzina = brzina;
		this.smjer = smjer;
		
		if(id >= 1 && id <= 9) {
			duljina = 2;
		}
		else if(id >= 10 && id <= 50) {
			duljina = 3;
		}
		else if(id >= 51 && id <= 60) {
			duljina = 4;
		}
		else {
			duljina = 5;
		}
	}

}
