package classes;

import java.util.ArrayList;
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
    
    // Método fictício para obter disciplinas disponíveis
    private static ArrayList<Subject> getAvailableSubjects() 
    {
        
        ArrayList<Subject> availableSubjects = new ArrayList<>();
        
        availableSubjects.add(new Subject("Português"));
        availableSubjects.add(new Subject("Matemática"));
        availableSubjects.add(new Subject("Língua Estrangeira"));
        availableSubjects.add(new Subject("Filosofia"));
        availableSubjects.add(new Subject("Educação Física"));
        availableSubjects.add(new Subject("Física e Química"));
        availableSubjects.add(new Subject("Biologia e Geologia"));
        availableSubjects.add(new Subject("História"));
        availableSubjects.add(new Subject("Matemática Aplicada às Ciências Sociais"));
        availableSubjects.add(new Subject("Geografia"));
        availableSubjects.add(new Subject("Desenho"));
        availableSubjects.add(new Subject("Geometria Descritiva"));
        availableSubjects.add(new Subject("História da Cultura e das Artes"));
        availableSubjects.add(new Subject("Economia"));

        return availableSubjects;
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
