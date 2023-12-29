package classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person 
{
	private static int nextStudentID = 1;
    private int studentID;
    private Course enrolledCourse;
    private Subject optionalSubject;
    private SchoolClass enrolledClass;
    private ArrayList<StudentGrade> studentGrades;

    
    // Constructors
    
    public Student() 
    {
        super("", "", "", LocalDate.now());
        this.studentID = generateStudentID();
        this.studentGrades = new ArrayList<StudentGrade>();
    }
    
    public Student(String name, String gender, String address, LocalDate birthday) 
    {
        super(name, gender, address, birthday);
        this.studentID = generateStudentID();
    }

    private static int generateStudentID() 
    {
        return nextStudentID++;
    }
    
    // Getters and setters for additional attributes
    public ArrayList<StudentGrade> getStudentGrades()
    {
    	return studentGrades;
    }
    
    public void setStudentGrades(ArrayList<StudentGrade> studentGrades) 
    {
    	this.studentGrades = studentGrades;
    }
    
    public int getStudentID() 
    {
        return studentID;
    }

    public void setStudentID(int studentID) 
    {
        this.studentID = studentID;
    }
    
    public Subject getOptionalSubject() 
    {
        return optionalSubject;
    }

    public void setOptionalSubject(Subject optionalSubject) 
    {
        this.optionalSubject = optionalSubject;
    }
    
    public Course getEnrolledCourse() 
    {
        return enrolledCourse;
    }

    public void setEnrolledCourse(Course enrolledCourse) 
    {
        this.enrolledCourse = enrolledCourse;
    }
    
    public SchoolClass getEnrolledClass() 
    {
        return enrolledClass;
    }

    public void setEnrolledClass(SchoolClass enrolledClass) 
    {
        this.enrolledClass = enrolledClass;
    }
    
    // Additional methods
    
    @Override
    public String toString() {
        return "Student Details:\n" +
                "Name: " + getName() + "\n" +
                "Birthdate: " + getBirthday() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Student ID: " + studentID + "\n" +
                "Enrolled Course: " + (enrolledCourse != null ? enrolledCourse.getCourseName() : "Not Enrolled") + "\n" +
                "Enrolled Class: " + (enrolledClass != null ? enrolledClass.getClassName() : "Not Enrolled");
    }
}