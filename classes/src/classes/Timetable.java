package classes;
import java.util.*;

public class Timetable // implement matrixes 
{
	private ArrayList<Subject> subjects;
	private Hour hour;
	
	public Timetable(Hour hour, ArrayList<Subject> subjects) 
	{
		this.subjects = subjects;
		this.hour = hour;
	}
	
	public Hour getHour() 
	{
        return hour;
    }

    public void setHour(Hour hour) 
    {
        this.hour = hour;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) 
    {
        this.subjects = subjects;
    }
}
