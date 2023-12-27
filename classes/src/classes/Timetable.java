package classes;

import java.util.*;
import java.time.LocalTime;

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
    
    public ArrayList<ArrayList<TimeCell>> getSchedule()
    {
    	return schedule;
    }
    
    public void setSchedule(ArrayList<ArrayList<TimeCell>> schedule)
    {
    	this.schedule = schedule;
    }
    
    public static Timetable buildEmptyTimetable() 
    {
    	Timetable timetable = new Timetable();
    	int periodsPerDay = 5; 
    	
    	for(int i = 0; i < DaysOfWeek.getUsefulDays().size(); i++) 
    	{
    		LocalTime startTime = LocalTime.of(8, 30);
    		ArrayList<TimeCell> dailySchedule = new ArrayList<>();
    		
            for (int period = 0; period < periodsPerDay; period++) 
            {
                ArrayList<LocalTime> timePeriod = new ArrayList<>();
                timePeriod.add(startTime);
                timePeriod.add(startTime.plusMinutes(90)); //1:30 hours classes
                
                TimeCell timeCell = new TimeCell(timePeriod, DaysOfWeek.getUsefulDays().get(i)); // Other parameters can be added as needed
                dailySchedule.add(timeCell);
            }
            
            timetable.getSchedule().add(dailySchedule);
    	}
    	
    	return timetable;
    }
    
    public void build() 
    {
    	System.out.println("\n====== Questionário ======\n");
    	
    	for(int day = 0; day < DaysOfWeek.getUsefulDays().size(); day++) 
    	{
    		int periodsPerDay = 5; 
    		
    		for (int period = 0; period < periodsPerDay; period++) 
    		{
    			schedule.get(day).get(period).build();
    		}
    		
    		System.out.println();
    	}
    	
    	System.out.println("\n======= Terminado ========\n");
    }
}