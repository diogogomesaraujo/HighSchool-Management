package classes;

import java.util.ArrayList;
import java.io.*;

public class Subject 
{
    private String subjectName;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Teacher> teachers;
    private String typeOfRoom;

    // Constructor
    public Subject(String subjectName) 
    {
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    public Subject(String subjectName, String typeOfRoom) 
    {
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.typeOfRoom = typeOfRoom;
    }
    
    public String getTypeOfRoom() 
    {
    	return typeOfRoom;
    }
    
    public void setTypeOfRoom(String typeOfRoom) 
    {
    	this.typeOfRoom = typeOfRoom;
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
					System.out.print(PredefinedSubjects.subjects.get(i).getSubjectName());
					if(i < PredefinedSubjects.subjects.size() - 1) System.out.print("/");
				}
				
				System.out.print(")");
				
				System.out.println("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				for(int i = 0; i < PredefinedSubjects.subjects.size(); i++) 
				{
					if(s.equalsIgnoreCase(PredefinedSubjects.subjects.get(i).getSubjectName())) return PredefinedSubjects.subjects.get(i);
					
					//if(i >= PredefinedSubjects.subjects.size() - 1) System.out.println("Disciplina Inválida");
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