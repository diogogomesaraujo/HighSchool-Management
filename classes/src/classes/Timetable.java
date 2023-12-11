package classes;

import java.util.*;

public class Timetable
{
    private ArrayList<ArrayList<TimeCell>> schedule;
    
    public Timetable() 
    {
    	schedule = new ArrayList<ArrayList<TimeCell>>();
    }
    
    public Timetable(ArrayList<ArrayList<TimeCell>> schedule) 
    {
        this.schedule = schedule;
    }
    
    public void writeTable() 
    {
    	for(int i = 0; i < schedule.get(i).size(); i++) // for each of line
    	{
    		for(int j = 0; j < schedule.size(); j++) // for each column
    		{
    			schedule.get(i).get(j).writeTimeCell();
    		}
    		
    		System.out.println("");
    	} 
    }
}