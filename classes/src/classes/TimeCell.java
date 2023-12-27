package classes;

import java.time.LocalTime;
import java.util.ArrayList;

public class TimeCell 
{
	private ArrayList<LocalTime> timePeriod;
	private String dayOfWeek;
	private SchoolClass schoolClass;
	private Room room;
	private Subject subject;
	
	public TimeCell(ArrayList<LocalTime> timePeriod, String dayOfWeek) 
	{
		this.timePeriod = timePeriod;
		this.dayOfWeek = dayOfWeek;
	}
	
	public TimeCell(ArrayList<LocalTime> timePeriod, String dayOfWeek, Room room, Subject subject, SchoolClass schoolClass) 
	{
		this.timePeriod = timePeriod;
		this.dayOfWeek = dayOfWeek;
		this.room = room;
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

    public void setRoom(Room room) 
    {
        this.room = room;
    }

    public Room getRoom() 
    {
        return this.room;
    }


    public void setSubject(Subject subject) 
    {
        this.subject = subject;
    }

    public Subject getSubject() 
    {
        return this.subject;
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
    	String text = "(" + timePeriod.get(0).getHour() + ":" +timePeriod.get(0).getMinute()
    				+ "/" + timePeriod.get(1).getHour() + ":" +timePeriod.get(1).getMinute()
    				+ ") " + subject + " - " + room.getCode();
    	return text;
    }
}
