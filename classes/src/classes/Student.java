package classes;

import java.util.*;
import java.time.LocalDateTime;

public class Student extends Person
{
	private int number;
	private ArrayList<Subject> subjects;
	
	public Student(String name, int number, String gender, String address, ArrayList<Subject> subjects, LocalDateTime birthday) 
	{
		super(name, gender, address, birthday);
		this.number = number;
		this.subjects = subjects;
	}
	
	public ArrayList<Subject> getSubjects()
	{
		return subjects;
	}
	
	public void setSubjects(ArrayList<Subject> subjects) 
	{
		this.subjects = subjects;
	}

    public int getNumner() 
    {
        return number;
    }

    public void setNumber(int number) 
    {
        this.number = number;
    }
}
