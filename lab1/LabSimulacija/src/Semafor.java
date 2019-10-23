


public class Semafor implements Runnable {
	
	public static String objekti = "crveno";
	public static String pjesak = "crveno";
	//public Stopwatch vrijeme = new Stopwatch();
	
	
//	public void svjetla() throws InterruptedException {
//	
//		while(true) {
//			objekti = "crveno";
//			pjesak = "crveno";
//			Thread.sleep(5000);
//			objekti = "zeleno";
//			pjesak = "crveno";
//			Thread.sleep(15000);
//			objekti = "crveno";
//			pjesak = "crveno";
//			Thread.sleep(5000);
//			objekti="crveno";
//			pjesak="zeleno";
//			Thread.sleep(15000);
//		}
//	
//	}


	@Override
	public void run() {
		while(true) {
			objekti = "crveno";
			pjesak = "crveno";
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objekti = "zeleno";
			pjesak = "crveno";
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objekti = "crveno";
			pjesak = "crveno";
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objekti="crveno";
			pjesak="zeleno";
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*public void lights() {
		
		vrijeme.Start();
		while(true) {
			if(vrijeme.elapsedTime() < 5 || (vrijeme.elapsedTime() >= 20 && vrijeme.elapsedTime() < 25)) {
				objekti = "crveno";
				pjesak = "crveno";
			} else if (vrijeme.elapsedTime() >= 5 && vrijeme.elapsedTime() < 20) {
				objekti = "crveno";
				pjesak = "zeleno";
			} else if(vrijeme.elapsedTime() >= 25 && vrijeme.elapsedTime() <= 40) {
				objekti = "zeleno";
				pjesak = "crveno";
			} else if(vrijeme.elapsedTime() > 40) {
				vrijeme.Restart();
			}
		}
		
	}
	
	*/
	
	
		
}
