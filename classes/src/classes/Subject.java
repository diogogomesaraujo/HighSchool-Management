package classes;

import java.util.ArrayList;
import java.io.*;

public class Subject 
{
    private String subjectName;
    private String subjectShortName;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Teacher> teachers;

    // Constructor
    public Subject(String subjectName) 
    {
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    public Subject(String subjectName, String subjectShortName) 
    {
        this.subjectName = subjectName;
        this.subjectShortName = subjectShortName;
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
    public String getSubjectShortName() 
    {
        return subjectShortName;
    }

    public void setSubjectShortName(String subjectShortName) 
    {
        this.subjectShortName = subjectShortName;
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
				System.out.print("(");
				
				for(int i = 0; i < PredefinedSubjects.subjects.size(); i++) 
				{
					System.out.print(PredefinedSubjects.subjects.get(i).getSubjectShortName());
					if(i < PredefinedSubjects.subjects.size() - 1) System.out.print("/");
				}
				
				System.out.print(")");
				
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				for(int i = 0; i < PredefinedSubjects.subjects.size(); i++) 
				{
					if(s.equalsIgnoreCase(PredefinedSubjects.subjects.get(i).getSubjectShortName())) return PredefinedSubjects.subjects.get(i);
					
					if(i >= PredefinedSubjects.subjects.size() - 1) System.out.println("Disciplina Inválida");
				}
			}
			
	
			
			catch(IOException e) 
			{
				System.out.print("Erro de Input!");
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
				System.out.print("(");
				
				for(int i = 0; i < subjects.size(); i++) 
				{
					System.out.print(subjects.get(i).getSubjectShortName());
					if(i < subjects.size() - 1) System.out.print("/");
				}
				
				System.out.print(")");
				
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				for(int i = 0; i < subjects.size(); i++) 
				{
					if(s.equalsIgnoreCase(subjects.get(i).getSubjectShortName())) return subjects.get(i);
					
					if(i >= subjects.size() - 1) System.out.println("Disciplina Inválida");
				}
			}
			
	
			
			catch(IOException e) 
			{
				System.out.print("Erro de Input!");
				System.out.println();
			}
		}
    }
}