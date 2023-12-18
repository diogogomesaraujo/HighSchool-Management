package classes;

import java.util.*;

public class Timetable
{
    private ArrayList<ArrayList<TimeCell>> schedule;
    
    public Timetable() 
    {
    	schedule = new ArrayList<ArrayList<TimeCell>>();
    }
    
    public Timetable(ArrayList<ArrayList<TimeCell>> schedule) 
    {
        this.schedule = schedule;
    }
    
    public void writeTable() 
    {
    	ArrayList<Integer> columnWidths = new ArrayList<>();
        for (ArrayList<TimeCell> row : schedule) 
        {
            for (int i = 0; i < row.size(); i++) 
            {
                int length = row.get(i).toString().length();
                
                if (columnWidths.size() <= i) 
                {
                    columnWidths.add(length);
                } 
                
                else if (length > columnWidths.get(i)) 
                {
                    columnWidths.set(i, length);
                }
            }
        }
        
        ArrayList<String> usefulDays = DaysOfWeek.getUsefulDays();
    	
    	for(int i = 0; i < schedule.get(i).size(); i++) // for each of line
    	{	
    		System.out.print(usefulDays.get(i));
    		
    		for(int aux = 0; aux < (columnWidths.get(i) - usefulDays.get(i).length()); i++)System.out.print(" ");
    		
    		for(int j = 0; j < schedule.size(); j++) // for each column
    		{
    			int space = columnWidths.get(j) - schedule.get(i).get(j).toString().length() + 1;
    			
    			System.out.print(schedule.get(i).get(j).toString());
    			for (int aux = 0; aux < space; aux++) System.out.print(" ");
    		}
    		
    		System.out.println();
    	} 
    }
}