package classes;

import java.util.ArrayList;
import java.io.*;

public class Subject 
{
    private String subjectName;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Teacher> teachers;
    
    private int auxNumber;

    // Constructor
    public Subject(String subjectName) 
    {
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    // Additional methods
    public void addTeacher(Teacher teacher) 
    {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) 
    {
        teachers.remove(teacher);
        teacher.removeSubject(this);
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

    public void enrollStudent(Student student) 
    {
        enrolledStudents.add(student);
    }
    
    @Override
    public String toString() 
    {
        String result = "Subject: " + subjectName + "\n";

        result += "Enrolled Students:\n";
        for (Student student : enrolledStudents) 
        {
            result += "- " + student.getName() + "\n";
        }

        result += "Teachers:\n";
        for (Teacher teacher : teachers) 
        {
            result += "- " + teacher.getName() + "\n";
        }

        return result;
    }
    
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
				
				System.out.println("Opção Inválida!");
			}
			
	
			
			catch(IOException e) 
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
    }
    
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