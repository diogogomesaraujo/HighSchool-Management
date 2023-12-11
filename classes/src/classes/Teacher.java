package classes;

import java.time.LocalDateTime;

public class Teacher 
{
	private String name;
	private String gender;
	private String address;
	private LocalDateTime birthday;
	private Subject subject;
	
	public Teacher(String name, String gender, String address, LocalDateTime birthday, Subject subject) 
	{
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.subject = subject;
		this.address = address;
	}
	
	public String getName() 
	{
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() 
    {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) 
    {
        this.birthday = birthday;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) 
    {
        this.subject = subject;
    }
    
    public String getAddress() 
    {
    	return address;
    }
    
    public void setAddress(String address) 
    {
    	this.address = address;
    }
}
