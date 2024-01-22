package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable
{
    private static final long serialVersionUID = 1L;
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

    public static Room aRoom(ArrayList<Room> availableRooms)
    {
        String s = "";

        while(true)
        {
            try
            {
                for(int i = 0; i < availableRooms.size(); i++)
                {
                    Room room = availableRooms.get(i);
                    System.out.println((i + 1) + ". " + room.getNumber() + " (" + room.getTypeOfRoom() + ")");
                    // Optionally, you could add an auxNumber to Room class similar to Subject class
                }

                System.out.print("\n-> ");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                s = in.readLine();

                for(int i = 0; i < availableRooms.size(); i++)
                {
                    if(s.equalsIgnoreCase(Integer.toString(i + 1)))
                    {
                        return availableRooms.get(i);
                    }
                }

                System.out.println("\nOpção Inválida!");
            }

            catch(IOException e)
            {
                System.out.println("\nInput Inválido!");
            }
        }
    }
}
