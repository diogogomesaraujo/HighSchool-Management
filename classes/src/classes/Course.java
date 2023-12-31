package classes;

import java.io.BufferedReader;
import java.io.Serializable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Represents a course in a secondary school. This class is responsible for managing
 * the course's name, the subjects offered, and the classes that are part of the course.
 * It includes functionality for adding or removing subjects and classes, enrolling students,
 * and handling course-specific operations.
 * 
 * @author The Author
 */
public class Course implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private String courseName;
    private ArrayList<Subject> subjects;
    private ArrayList<SchoolClass> classes;

    /**
     * Default constructor. Initializes a course with an empty name, subject list, and class list.
     */
    public Course() 
    {
        this.courseName = "";
        this.subjects = new ArrayList<>();
        this.classes = new ArrayList<>();
    }
    
    /**
     * Constructs a course with a specified name and subject list. Classes list is initialized as empty.
     *
     * @param courseName The name of the course.
     * @param subjects The list of subjects offered in the course.
     */
    public Course(String courseName, ArrayList<Subject> subjects) 
    {
        this.courseName = courseName;
        this.subjects = subjects;
        this.classes = new ArrayList<>();
    }
    
    /**
     * Adds a subject to the course.
     *
     * @param subject The subject to be added.
     */
    public void addSubject(Subject subject) 
    {
        subjects.add(subject);
    }
    
    /**
     * Removes a subject from the course.
     *
     * @param subject The subject to be removed.
     */
    public void removeSubject(Subject subject) 
    {
        subjects.remove(subject);
    }
    
    /**
     * Adds a class to the course.
     *
     * @param schoolClass The class to be added.
     */
    public void addClass(SchoolClass schoolClass) 
    {
        classes.add(schoolClass);
    }
    
    /**
     * Removes a class from the course.
     *
     * @param schoolClass The class to be removed.
     */
    public void removeClass(SchoolClass schoolClass) 
    {
        classes.remove(schoolClass);
    }
    
    /**
     * Finds an available class for a given student based on class capacity and subject requirements.
     * It searches through the list of classes in the course and returns the first class that has 
     * space available (less than 30 students) and offers the student's optional subject.
     *
     * @param student The student for whom an available class is being sought.
     * @return The available SchoolClass object if found, otherwise null.
     */
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
    
    /**
     * Enrolls a student in an available class within the course. If no available class is found 
     * that matches the student's requirements, a new class is created, and the student is enrolled in it.
     * This method calls findAvailableClass to get an appropriate class for the student. If no such class
     * exists, the method creates a new one with the required subjects, updates the global variables, 
     * and adds the student to the new class.
     *
     * @param student The student to be enrolled in a class.
     */
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
        	
        	for (Subject subject : subjects) 
        	{
                if (courseName == "Ciências" && !PredefinedCourses.sciencesOptionalSubjects.contains(subject)) //why?
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
    
    /**
     * Provides an interactive way to select an optional subject for a given course.
     * This method presents a list of optional subjects based on the course's name and 
     * allows the user to select one by entering the corresponding number. The method
     * continues to prompt until a valid selection is made.
     *
     * @param course The course for which an optional subject is being selected.
     * @return The selected Subject object.
     * @throws IOException If an input/output exception occurs during user input.
     */
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
    
    /**
     * Provides an interactive method to select a course from predefined options.
     * This method displays a list of available courses and prompts the user to select
     * one by entering the corresponding number. The selection process continues until
     * a valid choice is made.
     *
     * @return The selected Course object.
     * @throws IOException If an input/output exception occurs during user input.
     */
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
    
    @Override
    public String toString() 
    {
        String result = "Curso: " + courseName + "\n\nDisciplinas:\n";

        for (Subject subject : subjects) 
        {
            result += "- " + subject.getSubjectName() + "\n";
        }

        result += "\nTurmas inscritas:\n";
        for (SchoolClass schoolClass : classes) 
        {
            result += "- " + schoolClass.getClassName() + "\n";
        }

        return result;
    }
}

