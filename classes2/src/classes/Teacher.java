package classes;

public class Teacher 
{
	private String name;
	private String gender;
	private String address;
	private Birthday birthday;
	private Subject subject;
	
	public Teacher(String name, String gender, String address, Birthday birthday, Subject subject) 
	{
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.subject = subject;
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

    public Birthday getBirthday() 
    {
        return birthday;
    }

    public void setBirthday(Birthday birthday) 
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
}
