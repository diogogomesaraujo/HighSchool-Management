package classes;

import java.util.*;
import java.time.LocalDateTime;

public class Student 
{
	private String name;
	private int number;
	private String gender;
	private LocalDateTime birthday;
	private String address;
	private ArrayList<Subject> subjects;
	
	public Student(String name, int number, String gender, String address, ArrayList<Subject> subjects, LocalDateTime birthday) 
	{
		this.name = name;
		this.number = number;
		this.gender = gender;
		this.address = address;
		this.subjects = subjects;
		this.birthday = LocalDateTime.now();
	}
	
	public ArrayList<Subject> getSubjects()
	{
		return subjects;
	}
	
	public void setSubjects(ArrayList<Subject> subjects) 
	{
		this.subjects = subjects;
	}
	
	public String getName() 
	{
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getNumner() 
    {
        return number;
    }

    public void setNumber(int number) 
    {
        this.number = number;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }
	
    public LocalDateTime getBirthday() 
    {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) 
    {
        this.birthday = birthday;
    }
}
