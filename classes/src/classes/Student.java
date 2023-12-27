package classes;

import java.time.LocalDateTime;

public class Student extends Person 
{
	private static int nextStudentID = 1;
    private int studentID;
    private Course enrolledCourse;
    private Subject optionalSubject;
    private SchoolClass enrolledClass;

    
    // Constructors
    
    public Student() 
    {
        super("", "", "", LocalDateTime.now());
        this.studentID = generateStudentID();
    }
    
    public Student(String name, String gender, String address, LocalDateTime birthday) 
    {
        super(name, gender, address, birthday);
        this.studentID = generateStudentID();
    }

    private static int generateStudentID() 
    {
        return nextStudentID++;
    }
    
    // Getters and setters for additional attributes
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