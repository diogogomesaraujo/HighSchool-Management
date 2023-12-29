package classes;

import java.time.LocalDate;

public class Person 
{
	private String name;
	private String gender;
	private LocalDate birthday;
	private String address;
	
	public Person() 
	{
		this.name = "";
		this.gender = "";
		this.birthday = LocalDate.now();
		this.address = "";
	}
	
	public Person(String name, String gender, String address, LocalDate birthday) 
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person aPerson = (Person) obj;
        if (!name.equals(aPerson.name)) return false;
        if (!gender.equals(aPerson.gender)) return false;
        if (!birthday.equals(aPerson.birthday)) return false;
        if (!address.equals(aPerson.address)) return false;
        return true;
    }
}
