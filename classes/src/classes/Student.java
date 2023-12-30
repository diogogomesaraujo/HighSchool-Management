package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

public class Student extends Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	
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
    
    public static int getNextStudentID() {
        return nextStudentID;
    }

    public static void setNextStudentID(int id) {
        nextStudentID = id;
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
        return "Nome: " + getName() + "\n" +
               "Género: " + getGender() + "\n" +
               "Data de Nascimento: " + getBirthday() + "\n" +
               "Endereço: " + getAddress() + "\n" +
               "ID do Aluno: " + studentID + "\n" +
               "Curso Matriculado: " + (enrolledCourse != null ? enrolledCourse.getCourseName() : "Não Matriculado") + "\n" +
               "Classe Matriculada: " + (enrolledClass != null ? enrolledClass.getClassName() : "Não Matriculado") 
               ;
    }
}