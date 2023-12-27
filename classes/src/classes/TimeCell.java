package classes;

import java.time.LocalDateTime;

public class TimeCell 
{
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	private Room room;
	private Subject subject;
	
	public TimeCell() 
	{
		this.startTime = LocalDateTime.now();
		this.finishTime = LocalDateTime.now();
		this.room = new Room();
	}
	
	public TimeCell(LocalDateTime startTime, LocalDateTime finishTime, Room room, Subject subject) 
	{
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.room = room;
		this.subject = subject;
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


    public void setSubjects(Subject subject) 
    {
        this.subject = subject;
    }

    public Subject getSubject() 
    {
        return this.subject;
    }
    
    public String toString() 
    {
    	return " - Disciplina - " + " - Sala - " + room.getCode();
    }
}
