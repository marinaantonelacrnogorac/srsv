


public class Cesta {
	
	public static char[][] cesta = new char[][]
			{
        		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        		{'=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=',' ','-',' ','-',' ','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','='},
        		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        		{' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' '},
        		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        		{'=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=',' ','-',' ','-',' ','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','=','='},
        		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			};
	        
	  public static void ispisiCestu() {
		  for(int i = 0; i < 9; i++) {
			  for(int j = 0; j < 45; j++) {
				  System.out.print(cesta[i][j]);
			  }
			  System.out.println();
		  }
	  }
	  
	  public static int SlobodnoDesno() {
		  int slobodnoDesno = 0;
		  while(Cesta.cesta[5][slobodnoDesno] == ' ') {
			  slobodnoDesno++;
		  }
		  return slobodnoDesno;
	  }
	  
	  public static int SlobodnoLijevo() {
		  int slobodnoLijevo = 0;
		  int tmp = 44;
		  while(Cesta.cesta[3][tmp] == ' ') {
			  slobodnoLijevo++;
			  tmp--;			  
		  }
		  return slobodnoLijevo;
	  }
	 
	 
}
