package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

public class Teacher extends Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private static int nextTeacherID = 1;
    private int teacherID;
    private Subject subjectTaught;
    private ArrayList<TimeCell> timetable;

    public Teacher() 
    {
    	this.teacherID = generateTeacherID();
    	this.subjectTaught = null;
    	this.timetable = TimeCell.buildEmptyTimetable();
    }
    
    public Teacher(String name, String gender, String address, LocalDate birthday, int teacherID) 
    {
    	super(name, gender, address, birthday);
        this.subjectTaught = null;
        this.timetable = TimeCell.buildEmptyTimetable();
    }
    
    public static int getNextTeacherID() {
        return nextTeacherID;
    }

    public static void setNextTeacherID(int id) {
        nextTeacherID = id;
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
    
    public ArrayList<TimeCell> getTimetable() 
    {
        return timetable;
    }

    public void setTimetable(ArrayList<TimeCell> timetable) 
    {
        this.timetable = timetable;
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
