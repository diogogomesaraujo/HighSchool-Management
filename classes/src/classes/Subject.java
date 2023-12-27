package classes;

import java.util.ArrayList;

public class Subject 
{
    private String subjectName;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Teacher> teachers;

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

    public ArrayList<Teacher> getTeachers() 
    {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) 
    {
        this.teachers = teachers;
    }

    public ArrayList<Student> getEnrolledStudents() 
    {
        return enrolledStudents;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) 
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