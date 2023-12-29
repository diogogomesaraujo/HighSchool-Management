package classes;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass 
{
    private String className;  // e.g., "10A"
    private ArrayList<Student> students;
    private ArrayList<Teacher> subjectTeachers;
    private ArrayList<Subject> classSubjects;
    private ArrayList<TimeCell> timetable;

    // Constructor
    public SchoolClass(String className, List<Subject> courseSubjects) 
    {
        this.className = className;
        this.students = new ArrayList<>();
        this.subjectTeachers = new ArrayList<>();
        this.classSubjects = new ArrayList<>(courseSubjects);
        this.timetable = TimeCell.buildEmptyTimetable();
    }

    // Getters
    public String getClassName() 
    {
        return className;
    }

    public ArrayList<Student> getStudents() 
    {
        return students;
    }
    
    public ArrayList<TimeCell> getTimetable() 
    {
        return timetable;
    }

    public void setTimetable(ArrayList<TimeCell> timetable) 
    {
        this.timetable = timetable;
    }

    public ArrayList<Teacher> getSubjectTeachers() 
    {
        return subjectTeachers;
    }

    public ArrayList<Subject> getClassSubjects() 
    {
        return classSubjects;
    }

    // Setters
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public void setStudents(ArrayList<Student> students) 
    {
        this.students = students;
    }

    public void setSubjectTeachers(ArrayList<Teacher> subjectTeachers) 
    {
        this.subjectTeachers = subjectTeachers;
    }

    // Methods
    public void addStudent(Student student) 
    {
        if (!students.contains(student)) 
        {
            students.add(student);
            student.setEnrolledClass(this);

            // Automatically enroll the student in subjects taught in this class
            for (Subject subject : classSubjects) 
            {
                subject.enrollStudent(student);
            }
        } 
        
        else 
        {
            System.out.println("O aluno já se encontra na turma!");
        }
    }
    
    public void addTeacher(Teacher teacher) 
    {
    	if (!subjectTeachers.contains(teacher)) {
            subjectTeachers.add(teacher);
            //teacher.setEnrolledClass(this);
        } 
        
        else 
        {
            System.out.println("O professor já está atribuído a esta turma!");
        }
    }

    public void removeStudent(Student student) 
    {
        students.remove(student);
    }

    public void addSubject(Subject subject, Teacher teacher) 
    {
        classSubjects.add(subject);
        subjectTeachers.add(teacher);
        subject.addTeacher(teacher);

        // Enroll existing students in the new subject
        for (Student student : students) 
        {
            subject.enrollStudent(student);
        }
    }

    public void removeSubject(Subject subject) 
    {
        // Remove the subject from the list of subjects
        boolean removed = classSubjects.remove(subject);

        // If the subject was successfully removed, update the corresponding teacher list
        if (removed) {
            // Find the index of the subject in the classSubjects list
            int index = classSubjects.indexOf(subject);

            // Check if the index is valid
            if (index >= 0 && index < subjectTeachers.size()) 
            {
                // Remove the corresponding teacher from the subjectTeachers list
                subjectTeachers.remove(index);
            } 
            
            else 
            {
                // Handle the case where the index is out of bounds (this can be logged or reported)
                System.err.println("Error: Invalid index when removing corresponding teacher.");
            }
        } 
        
        else 
        {
            // Handle the case where the subject was not found in the list (this can be logged or reported)
            System.err.println("Error: Subject not found in the list.");
        }
    }

    @Override
    public String toString() 
    {
        String result = "Class Name: " + className + "\n\n";

        result += "Students:\n";
        for (Student student : students) 
        {
            result += "- " + student.getName() + "\n";
        }

        result += "\nSubject Teachers:\n";
        for (Teacher teacher : subjectTeachers) 
        {
            result += "- " + teacher.getName() + "\n";
        }

        result += "\nClass Subjects:\n";
        for (Subject subject : classSubjects) 
        {
            result += "- " + subject.getSubjectName() + "\n";
        }

        return result;
    }
    
    public ArrayList<Subject> getAvailableSubjects(TimeCell timeCell) 
    {
    	ArrayList<Subject> availableSubjects = new ArrayList<Subject>();
    	
    	if(subjectTeachers.size() != 0) 
    	{
    		for(Teacher teacher : subjectTeachers) 
        	{
        		for(TimeCell aux : teacher.getTimetable()) 
        		{
        			if(aux.getHasClass() == false && aux.getTimePeriod().equals(timeCell.getTimePeriod()) && aux.getDayOfWeek().equals(timeCell.getDayOfWeek())) 
        			{
        				availableSubjects.add(teacher.getSubjectTaught());
        			}
        		}
        	}
    	}
    	
    	else availableSubjects = classSubjects;
    	
    	return availableSubjects;
    }
}


