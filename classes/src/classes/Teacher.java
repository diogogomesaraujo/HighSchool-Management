package classes;

import java.time.LocalDateTime;

public class Teacher extends Person
{
	private Subject subject;
	
	public Teacher(String name, String gender, String address, LocalDateTime birthday, Subject subject) 
	{
		super(name, gender, address, birthday);
		this.subject = subject;
	}
	
	public Subject getSubject() 
	{
		return subject;
	}
	
    public void setSubject(Subject subject) 
    {
        this.subject = subject;
    }
}
