package classes;

import java.util.ArrayList;

public class Room
{
    private String number;
    private String typeOfRoom;
    private int capacity;
    private ArrayList<TimeCell> timetable;

    public Room(String number, String typeOfRoom, int capacity, ArrayList<TimeCell> timetable)
    {
        this.number = number;
        this.typeOfRoom = typeOfRoom;
        this.capacity = capacity;
        this.timetable = timetable;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public ArrayList<TimeCell> getTimetable()
    {
        return timetable;
    }

    public void setTimetable(ArrayList<TimeCell> timetable)
    {
        this.timetable = timetable;
    }

    public String getTypeOfRoom()
    {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom)
    {
        this.typeOfRoom = typeOfRoom;
    }
    
    public int getCapacity() 
    {
    	return capacity;
    }
    
    public void setCapacity(int capacity) 
    {
    	this.capacity = capacity;
    }
}
