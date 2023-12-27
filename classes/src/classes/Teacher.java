package classes;

import java.time.LocalDateTime;

public class Teacher extends Person 
{
    private static int nextTeacherID = 1;
    private int teacherID;
    private Subject subjectTaught;

    public Teacher() 
    {
    	this.teacherID = generateTeacherID();
    	this.subjectTaught = null;
    }
    
    public Teacher(String name, String gender, String address, LocalDateTime birthday, int teacherID) 
    {
    	super(name, gender, address, birthday);
        this.subjectTaught = null;
    }
    
    private static int generateTeacherID() 
    {
        return nextTeacherID++;
    }

    // Getters and Setters
    public int getTeacherID() 
    {
        return teacherID;
    }

    public void setTeacherID(int teacherID) 
    {
        this.teacherID = teacherID;
    }

    public Subject getSubjectTaught() 
    {
        return subjectTaught;
    }

    public void setSubjectTaught(Subject subjectTaught) 
    {
        this.subjectTaught = subjectTaught;
    }

    // Method to remove subject and update the Subject's list of teachers
    public void removeSubject(Subject subject) 
    {
        if (subjectTaught != null) 
        {
            subjectTaught.removeTeacher(this);
            subjectTaught = null;
        } 
        
        else 
        {
            System.out.println("The teacher is not currently assigned to any subject.");
        }
    }
    
    @Override
    public String toString() 
    {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", birthdate='" + getBirthday() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", teacherID=" + teacherID +
                ", subjectTaught=" + subjectTaught +
                '}';
    }

    // Outros métodos e atributos...
}
