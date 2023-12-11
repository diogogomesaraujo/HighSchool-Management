package classes;
import java.util.*;

public class Subject 
{
	private int code;
	private String name;
	private ArrayList<Student> students;
	private ArrayList<Teacher> teachers;
	
	public Subject() 
	{
		this.name = "";
		this.code = 0;
		this.students = new ArrayList<Student>();
		this.teachers = new ArrayList<Teacher>();
	}
	
	public Subject(String name, int code, ArrayList<Student> students, ArrayList<Teacher> teachers) 
	{
		this.name = name;
		this.code = code;
		this.students = students;
		this.teachers = teachers;
	}
	
	 public int getCode() 
	 	{
	        return code;
	    }

	    public void setCode(int code) 
	    {
	        this.code = code;
	    }

	    public String getName() 
	    {
	        return name;
	    }

	    public void setName(String name) 
	    {
	        this.name = name;
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
