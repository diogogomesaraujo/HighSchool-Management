package classes;

import java.util.ArrayList;
import java.util.List;

public class Course 
{
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
            }
        	
        	classSubjects.add(student.getOptionalSubject());
        	
            SchoolClass newClass = new SchoolClass("10" + (char) ('A' + classes.size()), classSubjects);
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

    public List<Subject> getSubjects() 
    {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) 
    {
        this.subjects = subjects;
    }

    public List<SchoolClass> getClasses() 
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

