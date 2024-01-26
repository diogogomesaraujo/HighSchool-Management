package classes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a person with basic attributes like name, gender, birthday, and address.
 * This class provides a structure for storing and managing personal information.
 * Implements Serializable for object serialization.
 */
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String gender;
	private LocalDate birthday;
	private Address address;
	
	/**
     * Default constructor. Initializes a person with empty name, gender, address,
     * and sets birthday to the current date.
     */
	public Person() 
	{
		this.name = "";
		this.gender = "";
		this.birthday = LocalDate.now();
		this.address = new Address();
	}
	
	/**
     * Constructs a person with specified name, gender, birthday, and address.
     *
     * @param name The name of the person.
     * @param gender The gender of the person.
     * @param address The address of the person.
     * @param birthday The birthday of the person.
     */
	public Person(String name, String gender, Address address, LocalDate birthday)
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
