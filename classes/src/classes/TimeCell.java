package classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.io.Serializable;

public class TimeCell implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<LocalTime> timePeriod;
	private String dayOfWeek;
	private SchoolClass schoolClass;
	private Subject subject;
	private boolean hasClass;
	
	public TimeCell(ArrayList<LocalTime> timePeriod, String dayOfWeek) 
	{
		this.timePeriod = timePeriod;
		this.dayOfWeek = dayOfWeek;
		this.hasClass = false;
	}
	
	public TimeCell(ArrayList<LocalTime> timePeriod, String dayOfWeek, Subject subject, SchoolClass schoolClass) 
	{
		this.timePeriod = timePeriod;
		this.dayOfWeek = dayOfWeek;
		this.subject = subject;
		this.schoolClass = schoolClass;
	}
	
	public void setTimePeriod(ArrayList<LocalTime> timePeriod) 
    {
        this.timePeriod = timePeriod;
    }

    public ArrayList<LocalTime> getTimePeriod() 
    {
        return timePeriod;
    }
    
    public void setDayOfWeek(String dayOfWeek) 
    {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeek() 
    {
        return dayOfWeek;
    }

    public void setSubject(Subject subject) 
    {
        this.subject = subject;
    }

    public Subject getSubject() 
    {
        return this.subject;
    }
    
    public void setHasClass(boolean hasClass) 
    {
        this.hasClass = hasClass;
    }

    public boolean getHasClass() 
    {
        return hasClass;
    }
    
    public void setSchoolClass(SchoolClass schoolClass) 
    {
        this.schoolClass = schoolClass;
    }

    public SchoolClass getSchoolClass() 
    {
        return schoolClass;
    }
    
    public String build() 
    {
    	if(subject != null) return timePeriodText() + subject.getSubjectName();
    	else return timePeriodText();
    }
    
    public static void writeTimetable(ArrayList<TimeCell> timetable) 
    {	
    	int inc = 0;
    	
    	System.out.println("\n======= Horário =======\n");
    	
    	for(int day = 0; day < DaysOfWeek.getUsefulDays().size(); day++) 
    	{
    		System.out.println(DaysOfWeek.getUsefulDays().get(day) + ":");
    		
    		for(int period = 0; period < 6; period++) 
        	{
    			System.out.println(timetable.get(inc).build());
    			
    			inc++;
        	}
    		
    	}
    	
    	System.out.println("\n======= Sucedido ========");
    }
    
    public static ArrayList<TimeCell> buildEmptyTimetable() 
    {
    	ArrayList<TimeCell> timetable = new ArrayList<TimeCell>();
    	
    	for(int day = 0; day < DaysOfWeek.getUsefulDays().size(); day++) 
    	{
    		LocalTime startTime = LocalTime.of(8, 30);
    		
    		for(int period = 0; period < 6; period++) 
        	{
    			ArrayList<LocalTime> timePeriod = new ArrayList<LocalTime>();
    			
    			timePeriod.add(startTime);
    			timePeriod.add(startTime.plusMinutes(90));
    			
        		timetable.add(new TimeCell(timePeriod, DaysOfWeek.getUsefulDays().get(day)));
        		startTime = startTime.plusMinutes(90);
        	}
    	}
    	
    	return timetable;
    }
    
    public String timePeriodText() 
    {
    	String text = "(" + timePeriod.get(0).getHour() + ":" +timePeriod.get(0).getMinute()
				+ "/" + timePeriod.get(1).getHour() + ":" +timePeriod.get(1).getMinute()
				+ ") ";
    	
    	return text;
    }
}
