package classes;

public class GlobalVariables 
{
	public static char letter = 65;
	
	public static void updateLetter() 
    {
    	letter += 1;
    }
	
	 public static char getLetter() {
	        return letter;
	    }

	    public static void setLetter(char id) {
	        letter = id;
	    }
}
