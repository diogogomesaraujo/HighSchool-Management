package classes;

import java.util.*;

public interface DaysOfWeek 
{
	public static final String monday = "Segunda-Feira";
	public static final String tuesday = "Terça-Feira";
	public static final String wednesday = "Quarta-Feira";
	public static final String thursday = "Quinta-Feira";
	public static final String friday = "Sexta-Feira";
	
    public static ArrayList<String> getUsefulDays()
    {
    	return new ArrayList<>(Arrays.asList("Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Seixa-Feira"));
    }
}
