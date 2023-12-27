package classes;

import java.util.ArrayList;
import java.util.List;

public class Subject 
{
    private String subjectName;
    private List<Student> enrolledStudents;
    private List<Teacher> teachers;

    // Constructor
    public Subject(String subjectName) 
    {
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    public Subject(String subjectName, String subjectType) 
    {
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    
    // Additional methods
    public void addTeacher(Teacher teacher) 
    {
        teachers.add(teacher);
        teacher.addSubject(this);
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

    public List<Teacher> getTeachers() 
    {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) 
    {
        this.teachers = teachers;
    }

    public List<Student> getEnrolledStudents() 
    {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) 
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
}