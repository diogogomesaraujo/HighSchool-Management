package classes;

import java.util.*;
import java.time.LocalDateTime;

public class TimeCell 
{
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	private Room room;
	private ArrayList<Class> classes;
	private ArrayList<Subject> subjects;
	
	public TimeCell() 
	{
		this.startTime = LocalDateTime.now();
		this.finishTime = LocalDateTime.now();
		this.room = new Room();
		this.classes = new ArrayList<Class>();
		this.subjects = new ArrayList<Subject>();
	}
	
	public TimeCell(LocalDateTime startTime, LocalDateTime finishTime, Room room, ArrayList<Class> classes, ArrayList<Subject> subjects) 
	{
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.room = room;
		this.classes = classes;
		this.subjects = subjects;
	}
	
	public void setStartTime(LocalDateTime startTime) 
	{
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() 
    {
        return this.startTime;
    }

    public void setFinishTime(LocalDateTime finishTime) 
    {
        this.finishTime = finishTime;
    }

    public LocalDateTime getFinishTime() 
    {
        return this.finishTime;
    }

    public void setRoom(Room room) 
    {
        this.room = room;
    }

    public Room getRoom() 
    {
        return this.room;
    }

    public void setClasses(ArrayList<Class> classes) 
    {
        this.classes = classes;
    }

    public ArrayList<Class> getClasses() 
    {
        return this.classes;
    }

    public void setSubjects(ArrayList<Subject> subjects) 
    {
        this.subjects = subjects;
    }

    public ArrayList<Subject> getSubjects() 
    {
        return this.subjects;
    }
}
