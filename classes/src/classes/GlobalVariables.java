package classes;

/**
 * A utility class to hold global variables for the application. Currently, it manages
 * a single character variable, which can be incremented and accessed statically.
 * This class is useful in scenarios where a global state needs to be shared across 
 * different parts of the application.
 */
public class GlobalVariables 
{
	/** The global character variable, initially set to 'A' (ASCII 65). */
	public static char letter = 65;
	
	/**
     * Increments the global character variable by one.
     * For example, if the current value is 'A', it will be updated to 'B'.
     */
	public static void updateLetter() 
    {
    	letter += 1;
    }
	
	/**
     * Retrieves the current value of the global character variable.
     *
     * @return The current character value.
     */
	 public static char getLetter() 
	 {
		 return letter;
	 }
	 
	 /**
	 * Sets the global character variable to a specified value.
	 *
	 * @param id The new character value to set.
	 */
	 public static void setLetter(char id) 
	 {
	    letter = id;
	 }
}
