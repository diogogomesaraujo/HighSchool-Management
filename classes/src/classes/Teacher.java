package classes;

import java.time.LocalDateTime;

public class Teacher extends Person 
{
    private int teacherID;
    private Subject subjectTaught;

    public Teacher() 
    {
    	this.teacherID = 0;
    }
    
    public Teacher(String name, String gender, String address, LocalDateTime birthday, int teacherID) 
    {
    	super(name, gender, address, birthday);
        this.teacherID = teacherID;
        this.subjectTaught = null;
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
    
 // Method to add subject and update the Subject's list of teachers
    public void addSubject(Subject subject) 
    {
        if (subjectTaught == null) 
        {
            subjectTaught = subject;
            subject.addTeacher(this);
        } 
        
        else 
        {
            System.out.println("The teacher is already assigned to a subject.");
        }
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

    // Método estático para criar um professor a partir do input do usuário
    public static Teacher createTeacherFromUserInput() 
    {
        return new Teacher();
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
