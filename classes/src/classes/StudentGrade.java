package classes;

public class StudentGrade 
{
    Subject subject;
    private double gradeValue;
    
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