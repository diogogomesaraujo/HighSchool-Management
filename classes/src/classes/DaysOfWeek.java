package classes;

import java.util.*;

/**
 * Interface defining constants for days of the week in Portuguese and providing a method
 * to retrieve a list of these days. This interface can be used for applications where
 * days of the week need to be referenced in a consistent manner.
 */
public interface DaysOfWeek 
{
	/** Constant for Monday. */
	public static final String monday = "Segunda-Feira";
	
	/** Constant for Tuesday. */
	public static final String tuesday = "Terça-Feira";
	
	/** Constant for Wednesday. */
	public static final String wednesday = "Quarta-Feira";
	
	 /** Constant for Thursday. */
	public static final String thursday = "Quinta-Feira";
	
	/** Constant for Friday. */
	public static final String friday = "Sexta-Feira";
	
	/**
     * Provides an ArrayList of strings representing the weekdays.
     * The list includes Monday to Friday in Portuguese.
     *
     * @return An ArrayList of String containing the weekdays.
     */
    public static ArrayList<String> getUsefulDays()
    {
    	return new ArrayList<>(Arrays.asList("Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Seixa-Feira"));
    }
}
