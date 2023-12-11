package classes;

import java.time.LocalDateTime;

public class TimeCell 
{
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	private Room room;
	private Class studentClass;
	private Subject subject;
	
	public TimeCell() 
	{
		this.startTime = LocalDateTime.now();
		this.finishTime = LocalDateTime.now();
		this.room = new Room();
		this.studentClass = new Class();
		this.subject = new Subject();
	}
	
	public TimeCell(LocalDateTime startTime, LocalDateTime finishTime, Room room, Class studentClass, Subject subject) 
	{
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.room = room;
		this.studentClass = studentClass;
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

    public void setStudentClass(Class studentClass) 
    {
        this.studentClass = studentClass;
    }

    public Class getStudentClasses() 
    {
        return this.studentClass;
    }

    public void setSubjects(Subject subject) 
    {
        this.subject = subject;
    }

    public Subject getSubject() 
    {
        return this.subject;
    }
    
    public void writeTimeCell() 
    {
    	System.out.println(startTime.getHour() + ":" + startTime.getMinute() + " / " + finishTime.getHour() + ":" + finishTime.getMinute() + " - Disciplina - " + studentClass.getLetter() + " - Sala - " + room.getCode());
    }
}
