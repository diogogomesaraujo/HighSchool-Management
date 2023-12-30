package classes;

import java.io.BufferedReader;
import java.io.Serializable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Course implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private String courseName;
    private ArrayList<Subject> subjects;
    private ArrayList<SchoolClass> classes;

    // Constructors
    
    public Course() 
    {
        this.courseName = "";
        this.subjects = new ArrayList<>();
        this.classes = new ArrayList<>();
    }
    
    public Course(String courseName, ArrayList<Subject> subjects) 
    {
        this.courseName = courseName;
        this.subjects = subjects;
        this.classes = new ArrayList<>();
    }
    
    // Subjects Methods
    public void addSubject(Subject subject) 
    {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) 
    {
        subjects.remove(subject);
    }
    
    // Classes Methods
    public void addClass(SchoolClass schoolClass) 
    {
        classes.add(schoolClass);
    }
    
    public void removeClass(SchoolClass schoolClass) 
    {
        classes.remove(schoolClass);
    }
    
    // Enroll a student in a class
    
    private SchoolClass findAvailableClass(Student student) 
    {
        for (SchoolClass schoolClass : classes) 
        {
            if (schoolClass.getStudents().size() < 30 && schoolClass.getClassSubjects().contains(student.getOptionalSubject())) 
            {
                return schoolClass;
            }
        }
        return null;
    }

    public void enrollClass(Student student) 
    {
        SchoolClass availableClass = findAvailableClass(student);

        if (availableClass != null) 
        {
            student.setEnrolledClass(availableClass);
            student.setEnrolledCourse(this);
            availableClass.addStudent(student);
        } 
        
        else 
        {
        	ArrayList<Subject> classSubjects = new ArrayList<Subject>();
        	
        	for (Subject subject : subjects) {
                if (courseName == "Ciências" && !PredefinedCourses.sciencesOptionalSubjects.contains(subject)) 
                {
                    classSubjects.add(subject);
                }
                
                if (courseName == "Artes" && !PredefinedCourses.artsOptionalSubjects.contains(subject)) 
                {
                    classSubjects.add(subject);
                }
                
                if (courseName == "Economia" && !PredefinedCourses.economyOptionalSubjects.contains(subject)) 
                {
                    classSubjects.add(subject);
                }
                
                if (courseName == "Humanidades" && !PredefinedCourses.humanSciencesOptionalSubjects.contains(subject)) 
                {
                    classSubjects.add(subject);
                }
            }
        	
        	classSubjects.add(student.getOptionalSubject());
        	
            SchoolClass newClass = new SchoolClass("10" + (char) (GlobalVariables.letter), classSubjects);
            
            GlobalVariables.updateLetter();
            
            classes.add(newClass);
            
            student.setEnrolledClass(newClass);
            student.setEnrolledCourse(this);
            
            newClass.addStudent(student);
        }
    }

    // Getters and setters
    public String getCourseName() 
    {
        return courseName;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public ArrayList<Subject> getSubjects() 
    {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) 
    {
        this.subjects = subjects;
    }

    public ArrayList<SchoolClass> getClasses() 
    {
        return classes;
    }

    public void setClasses(ArrayList<SchoolClass> classes) 
    {
        this.classes = classes;
    }
    
    public static Subject aOptionalSubject(Course course) 
	{
		String s = "";
		
		ArrayList<Subject> optionalSubjects = new ArrayList<Subject>();
		
		if(course.getCourseName().equals("Ciências")) 
		{
			optionalSubjects = PredefinedCourses.sciencesOptionalSubjects;
		}
		
		if(course.getCourseName().equals("Artes")) 
		{
			optionalSubjects = PredefinedCourses.artsOptionalSubjects;
		}
		
		if(course.getCourseName().equals("Economia")) 
		{
			optionalSubjects = PredefinedCourses.economyOptionalSubjects;
		}
		
		if(course.getCourseName().equals("Humanidades")) 
		{
			optionalSubjects = PredefinedCourses.humanSciencesOptionalSubjects;
		}
		
		while(true) 
		{
			try 
			{	
				for(int i = 1; i <= optionalSubjects.size(); i++) 
				{
					System.out.println(i + ".	" + optionalSubjects.get(i - 1).getSubjectName());
					optionalSubjects.get(i - 1).setAuxNumber(i);
				}
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				for(int i = 0; i < optionalSubjects.size(); i++) 
				{
					String aux = optionalSubjects.get(i).getAuxNumber() + "";
					
					if(s.equalsIgnoreCase(aux)) return optionalSubjects.get(i);
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
    
    public static Course aCourse() 
	{
		String s = "";
		
		while(true) 
		{
			try 
			{
				System.out.println("1.	Artes ");
				System.out.println("2.	Ciências ");
				System.out.println("3.	Economia ");
				System.out.println("4.	Humanidades ");
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				if (s.equalsIgnoreCase("1")) 
				{
		            return PredefinedCourses.arts;
		        } 
				
				else if (s.equalsIgnoreCase("2")) 
				{
		            return PredefinedCourses.sciences;
		        } 
				
				else if (s.equalsIgnoreCase("3")) 
				{
		            return PredefinedCourses.economy;
		        } 
				
				else if (s.equalsIgnoreCase("4")) 
				{
		            return PredefinedCourses.humanSciences;
		        } 
				
				else 
				{
					System.out.println("Opção Inválida!");
				}
			}
			
			catch(IOException e) 
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
	}
    
    @Override
    public String toString() 
    {
        String result = "=========================\n\n" + "Curso: " + courseName + "\n\nDisciplinas:\n";

        for (Subject subject : subjects) 
        {
            result += "- " + subject.getSubjectName() + "\n";
        }

        result += "\nTurmas inscritas:\n";
        for (SchoolClass schoolClass : classes) 
        {
            result += "- " + schoolClass.getClassName() + "\n";
        }

        return "\n\n=========================" + result;
    }
}

