package classes;

import java.io.Serializable;

/**
 * Represents a student's grade for a specific subject. This class includes details
 * about the subject and the numeric grade value. It implements Serializable for
 * object serialization.
 */
public class StudentGrade implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    Subject subject;
    private double gradeValue;
    
    /**
     * Constructs a StudentGrade with a specified subject and grade value.
     *
     * @param subject The subject for which the grade is assigned.
     * @param gradeValue The numeric value of the grade.
     */
    public StudentGrade(Subject subject, double gradeValue) 
    {
        this.subject = subject;
        this.gradeValue = gradeValue;
    }
    
    // Getters
    public Subject getSubject() 
    {
        return subject;
    }
    
    public double getGradeValue() 
    {
        return gradeValue;
    }
    
    // Setters 
    public void setSubject(Subject subject) 
    {
        this.subject = subject;
    }

    public void setGradeValue(int gradeValue) 
    {
        this.gradeValue = gradeValue;
    }

    @Override
    public String toString() 
    {
        return "StudentGrade{" +
                ", subject=" + subject +
                ", gradeValue=" + gradeValue +
                '}';
    }
}