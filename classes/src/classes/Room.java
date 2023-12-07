package classes;

public class Room 
{
	private int code;
	private Timetable timeTable;
	
	public Room() 
	{
		this.code = 0;
		this.timeTable = new Timetable();
	}
	
	public Room(int code, Timetable timeTable) 
	{
		this.code = code;
		this.timeTable = timeTable;
	}
	
	public int getCode() 
	{
        return code;
    }

    public void setCode(int code) 
    {
        this.code = code;
    }

    public Timetable getTimeTable() 
    {
        return timeTable;
    }

    public void setTimeTable(Timetable timeTable) 
    {
        this.timeTable = timeTable;
    }
}
