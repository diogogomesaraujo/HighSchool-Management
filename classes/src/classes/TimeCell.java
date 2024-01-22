package classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Represents a time slot in a school timetable. It includes the time period, day of the week,
 * and optionally the subject and class assigned to this time slot. The class also provides
 * functionality to manage these attributes.
 */
public class TimeCell implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<LocalTime> timePeriod;
	private String dayOfWeek;
	private SchoolClass schoolClass;
	private Subject subject;
    private Room room;
	private boolean hasClass;
	
	/**
     * Constructs a TimeCell with specified time period and day of the week.
     * Initializes the cell without a subject and class.
     *
     * @param timePeriod The time period of the cell.
     * @param dayOfWeek The day of the week for this cell.
     */
	public TimeCell(ArrayList<LocalTime> timePeriod, String dayOfWeek) 
	{
		this.timePeriod = timePeriod;
		this.dayOfWeek = dayOfWeek;
		this.hasClass = false;
	}
	
	/**
     * Constructs a TimeCell with specified time period, day of the week, subject, and school class.
     *
     * @param timePeriod The time period of the cell.
     * @param dayOfWeek The day of the week for this cell.
     * @param subject The subject scheduled in this cell.
     * @param schoolClass The class scheduled in this cell.
     */
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

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }

    /**
     * Builds a string representation of the TimeCell including its time period and subject name.
     *
     * @return The string representation of the TimeCell.
     */
    public String build() 
    {
    	if(subject != null) return timePeriodText() + subject.getSubjectName();
    	else return timePeriodText();
    }
    
    /**
     * Writes the timetable to the standard output, displaying the schedule for each day.
     *
     * @param timetable The list of TimeCells representing the timetable.
     */
    public static void writeTimetable(ArrayList<TimeCell> timetable) 
    {	
    	int inc = 0;
    	
    	System.out.println("\n======= Horário =======\n");
    	
    	for(int day = 0; day < DaysOfWeek.getUsefulDays().size(); day++) 
    	{
    		System.out.println(DaysOfWeek.getUsefulDays().get(day) + ":\n");
    		
    		for(int period = 0; period < 6; period++) 
        	{
    			System.out.println(timetable.get(inc).build());
    			
    			inc++;
        	}

            System.out.println();
    	}
    	
    	System.out.println("\n======= Sucedido ========");
    }
    
    /**
     * Builds an empty timetable with predefined time slots and days of the week.
     *
     * @return An ArrayList of TimeCells representing the empty timetable.
     */
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
    
    /**
     * Generates a text representation of the time period.
     *
     * @return A string representing the time period in the format "HH:MM/HH:MM".
     */
    public String timePeriodText() 
    {
    	String text = "(" + timePeriod.get(0).getHour() + ":" +timePeriod.get(0).getMinute()
				+ "/" + timePeriod.get(1).getHour() + ":" +timePeriod.get(1).getMinute()
				+ ") ";
    	
    	return text;
    }
}
