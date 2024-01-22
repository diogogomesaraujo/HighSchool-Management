package classes;

import java.util.ArrayList;
import java.io.*;

/**
 * Represents an academic subject with attributes for subject name, lists of enrolled students
 * and assigned teachers. This class also provides methods for managing these attributes.
 * Implements Serializable for object serialization.
 */
public class Subject implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private String subjectName;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Teacher> teachers;
    private ArrayList<String> typeOfRooms;
    
    private int auxNumber;

    /**
     * Constructs a Subject with a specified name. Initializes empty lists for students and teachers.
     *
     * @param subjectName The name of the subject.
     */
    public Subject(String subjectName, ArrayList<String> typeOfRooms)
    {
        this.subjectName = subjectName;
        this.typeOfRooms = typeOfRooms;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    /**
     * Adds a teacher to the subject.
     *
     * @param teacher The teacher to be added.
     */
    public void addTeacher(Teacher teacher) 
    {
        teachers.add(teacher);
    }
    
    /**
     * Removes a teacher from the subject.
     *
     * @param teacher The teacher to be removed.
     */
    public void removeTeacher(Teacher teacher) 
    {
        teachers.remove(teacher);
    }
    
    /**
     * Removes a student from the subject.
    *
    * @param student The student to be removed.
    */
    public void removeStudent(Student student)
    {
    	enrolledStudents.remove(student);
    }
    
    // Getters and Setters
    public int getAuxNumber() 
    {
        return auxNumber;
    }

    public void setAuxNumber(int auxNumber) 
    {
        this.auxNumber = auxNumber;
    }
    
    public String getSubjectName() 
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName) 
    {
        this.subjectName = subjectName;
    }

    public ArrayList<Teacher> getTeachers() 
    {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) 
    {
        this.teachers = teachers;
    }

    public ArrayList<Student> getEnrolledStudents() 
    {
        return enrolledStudents;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) 
    {
        this.enrolledStudents = enrolledStudents;
    }

    public ArrayList<String> getTypeOfRooms()
    {
        return typeOfRooms;
    }

    public void setTypeOfRooms(ArrayList<String> typeOfRooms)
    {
        this.typeOfRooms = typeOfRooms;
    }

    /**
     * Enrolls a student in the subject.
     *
     * @param student The student to be enrolled.
     */
    public void enrollStudent(Student student) 
    {
        enrolledStudents.add(student);
    }
    
    @Override
    public String toString() {
        String result = "";
        result += "Disciplina: " + subjectName + "\n";

        result += "\nAlunos Matriculados:\n";
        for (Student student : enrolledStudents) {
            result += "- " + student.getName() + "\n";
        }

        result += "\nProfessores:\n";
        for (Teacher teacher : teachers) {
            result += "- " + teacher.getName();
        }

        return result;
    }
    
    /**
     * Provides an interactive method to select a subject from a list of predefined subjects.
     * 
     * @return The selected Subject object.
     * @throws IOException If an input/output exception occurs during user input.
     */
    public static Subject aSubject() 
    {
    	String s = "";
    	
    	while(true) 
		{
			try 
			{
				for(int i = 0; i < PredefinedSubjects.subjects.size(); i++) 
				{
					System.out.println((i + 1) + ".	" + PredefinedSubjects.subjects.get(i).getSubjectName());
					PredefinedSubjects.subjects.get(i).setAuxNumber(i + 1);
				}
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				for(int i = 0; i < PredefinedSubjects.subjects.size(); i++) 
				{
					String aux = PredefinedSubjects.subjects.get(i).getAuxNumber() + "";
					
					if(s.equalsIgnoreCase(aux)) return PredefinedSubjects.subjects.get(i);
				}
				
				System.out.println("\nOpção Inválida!");
			}
			
	
			
			catch(IOException e) 
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
    }
    
    /**
     * Provides an interactive method to select a subject from a given list of subjects.
     * 
     * @param subjects The list of subjects from which to choose.
     * @return The selected Subject object.
     * @throws IOException If an input/output exception occurs during user input.
     */
    public static Subject aSubject(ArrayList<Subject> subjects) 
    {
    	String s = "";
    	
    	while(true) 
		{
			try 
			{
				for(int i = 0; i < subjects.size(); i++) 
				{
					System.out.println((i + 1) + ".	" + subjects.get(i).getSubjectName());
					subjects.get(i).setAuxNumber(i + 1);
				}
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				for(int i = 0; i < subjects.size(); i++) 
				{
					String aux = subjects.get(i).getAuxNumber() + "";
					
					if(s.equalsIgnoreCase(aux)) return subjects.get(i);
				}
				
				System.out.println("Opção Inválida!");
			}
			
	
			
			catch(IOException e) 
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
    }
}