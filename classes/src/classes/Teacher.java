package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Represents a teacher, extending the Person class. This class includes teacher-specific
 * attributes such as teacher ID, subject taught, and a timetable. It provides functionality
 * to manage these attributes.
 */
public class Teacher extends Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private static int nextTeacherID = 1;
    private int teacherID;
    private Subject subjectTaught;
    private ArrayList<TimeCell> timetable;
    
    /**
     * Default constructor. Initializes a teacher with default values and generates a unique teacher ID.
     */
    public Teacher() 
    {
    	this.teacherID = generateTeacherID();
    	this.subjectTaught = null;
    	this.timetable = TimeCell.buildEmptyTimetable();
    }
    
    /**
     * Constructs a teacher with specified personal details. Automatically generates a unique teacher ID.
     *
     * @param name The teacher's name.
     * @param gender The teacher's gender.
     * @param address The teacher's address.
     * @param birthday The teacher's birthday.
     */
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

    /**
     * Removes the teacher from the currently assigned subject, if any, and updates the subject's list of teachers.
     *
     * @param subject The subject to remove the teacher from.
     */
    public void removeSubject(Subject subject) 
    {
        if (subjectTaught != null) 
        {
            subjectTaught.removeTeacher(this);
            subjectTaught = null;
        } 
        
        else 
        {
            System.out.println("O professor não está atribuído a nenhuma disciplina!"); //x
        }
    }
    
    @Override
    public String toString() {
        return "ID: " + teacherID + "\n" +
               "Nome: " + getName() + "\n" +
               "Género: " + getGender() + "\n" +
               "Data de Nascimento: " + getBirthday() + "\n" +
               "Endereço: " + getAddress() + "\n" +
               "Disciplina Lecionada: " + (subjectTaught != null ? subjectTaught.getSubjectName() : "Não atribuída")
               ;
    }
}
