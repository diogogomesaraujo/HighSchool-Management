package classes;

import java.time.LocalDateTime;

public class Person 
{
	private String name;
	private String gender;
	private LocalDateTime birthday;
	private String address;
	
	public Person() 
	{
		this.name = "";
		this.gender = "";
		this.birthday = LocalDateTime.now();
		this.address = "";
	}
	
	public Person(String name, String gender, String address, LocalDateTime birthday) 
	{
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
