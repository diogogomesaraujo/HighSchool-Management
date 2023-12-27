package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Room 
{
	private String code;
	private String type;
	private Timetable timeTable;
	
	public Room() 
	{
		this.code = "";
		this.timeTable = new Timetable();
	}
	
	public Room(String code, String type) 
	{
		this.code = code;
		this.type = type;
	}
	
	public String getCode() 
	{
        return code;
    }

    public void setCode(String code) 
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
    
    public String getType() 
	{
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    
    public static Room aRoom() 
	{
		String s = "";
		
		while(true) 
		{
			try 
			{
				System.out.print("(");
				
				for(int i = 0; i < PredefinedRooms.rooms.size(); i++) 
				{
					System.out.print(PredefinedRooms.rooms.get(i).getType());
					
					if(i >= PredefinedRooms.rooms.size() - 1) System.out.print("/");
				}
				
				System.out.print(") ");
				
				System.out.print("(Masculino/Feminino) ");
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				for(int i = 0; i < PredefinedRooms.rooms.size(); i++)
				{
					if(PredefinedRooms.rooms.get(i).getCode().equals(s) && PredefinedRooms.rooms.get(i).getType().equals(s)) 
					{
						return PredefinedRooms.rooms.get(i);
					}
				}
				
				System.out.println("Sala Inválida!");
			}
			
			catch (IOException e)
			{
				System.out.print("Erro de Input!");
				System.out.println();
			}
		}
	}
}
