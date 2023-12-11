package classes;
import java.util.*;

public class Class
{
	private int year;
	private char letter;
	private ArrayList<Student> students;
	private ArrayList<Teacher> teachers;
	
	public Class() 
	{
		this.year = 0;
		this.letter = 'A';
		this.students = new ArrayList<Student>();
		this.teachers = new ArrayList<Teacher>();
	}
	
	public Class(int year, char letter, ArrayList<Student> students, ArrayList<Teacher> teachers) 
	{
		this.year = year;
		this.letter = letter;
		this.students = students;
		this.teachers = teachers;
	}
	
	public int getYear() 
	{
        return year;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) 
    {
        this.letter = letter;
    }

    public ArrayList<Student> getStudents() 
    {
        return students;
    }

    public void setAlunos(ArrayList<Student> students) 
    {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() 
    {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) 
    {
        this.teachers = teachers;
    }
}
