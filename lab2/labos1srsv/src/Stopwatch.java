


public class Stopwatch {
	
	
		private long start;
	    

	    public Stopwatch() {
	        
	    } 

	    public void Start() {
	    	start = System.currentTimeMillis();
	    }
	   
	   
	    public double elapsedTime() {
	        long now = System.currentTimeMillis();
	        return (now - start) / 1000.0;
	    }
	    
	    public void Restart() {
	    	start = System.currentTimeMillis();
	    }
	    
	    
	
}
