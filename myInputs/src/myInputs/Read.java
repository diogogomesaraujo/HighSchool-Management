package myInputs;

import java.io.*;
import classes.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Read 
{
	public static String aString() 
	{
		String s = "";
		try 
		{
			System.out.print("-> ");
			BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
			s= in.readLine();
		}
		catch (IOException e)
		{
			System.out.print("Erro de Input!");
			System.out.println();
		}
		
		return s;
	}
	
	public static int anInt() 
	{
		while(true) 
		{
			try 
			{
				return Integer.parseInt(aString().trim());
			}
			catch(NumberFormatException e) 
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
			
		}
		
	}
	
	public static byte aByte(){
		while(true)
		{
			try
			{
				return Byte.parseByte(aString().trim());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static short aShort(){
		while(true){
			try
			{
				return Short.parseShort(aString().trim());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static long aLong(){
		while(true){
			try
			{
				return Long.parseLong(aString().trim());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static float aFloat(){
		while(true){
			try
			{
				return Float.parseFloat(aString().trim());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static double aDouble(){
		while(true)
		{
			try
			{
				return Double.valueOf(aString().trim());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static char aChar(){
		while(true)
		{
			try
			{
				return aString().charAt(0);
			}
			catch(Exception e)
			{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static boolean aBoolean(){
		while(true)
		{
			try
			{
				return Boolean.parseBoolean(aString().trim());
			}
			catch(Exception e)
		{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	} 
	
	public static LocalDateTime aLocalDateTime() 
	{
		while(true)
		{
			try
			{
				return LocalDateTime.parse((aString() + "T00:00:00").trim());
			}
			catch(Exception e)
		{
				System.out.println("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static Course aCourse() 
	{
		String s = "";
		
		while(true) 
		{
			try 
			{
				System.out.print("(Artes/Ciências/Humanidades/Economia)");
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				if (s.equalsIgnoreCase("Ciências") || s.equalsIgnoreCase("ciências")) 
				{
		            return PredefinedCourses.sciences;
		        } 
				
				else if (s.equalsIgnoreCase("Artes") || s.equalsIgnoreCase("artes")) 
				{
		            return PredefinedCourses.arts;
		        } 
				
				else if (s.equalsIgnoreCase("Humanidades") || s.equalsIgnoreCase("humanidades")) 
				{
		            return PredefinedCourses.humanSciences;
		        } 
				
				else if (s.equalsIgnoreCase("Economia") || s.equalsIgnoreCase("economia")) 
				{
		            return PredefinedCourses.economy;
		        } 
				
				else 
				{
					System.out.println("Curso Inválido!");
				}
			}
			
			catch(IOException e) 
			{
				System.out.print("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static Subject aOptionalSubject(Course course) 
	{
		String s = "";
		
		ArrayList<Subject> optionalSubjects = new ArrayList<Subject>();
		
		if(course.getCourseName().equals("Ciências")) 
		{
			optionalSubjects = PredefinedCourses.sciencesOptionalSubjects;
		}
		
		if(course.getCourseName().equals("Artes")) 
		{
			optionalSubjects = PredefinedCourses.artsOptionalSubjects;
		}
		
		if(course.getCourseName().equals("Economia")) 
		{
			optionalSubjects = PredefinedCourses.economyOptionalSubjects;
		}
		
		if(course.getCourseName().equals("Humanidades")) 
		{
			optionalSubjects = PredefinedCourses.humanSciencesOptionalSubjects;
		}
		
		while(true) 
		{
			try 
			{
				System.out.print("(");
				
				for(int i = 0; i < optionalSubjects.size(); i++) 
				{
					System.out.print(optionalSubjects.get(i).getSubjectName());
					if(i < optionalSubjects.size() - 1) System.out.print("/");
				}
				
				System.out.print(")");
				
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				for(int i = 0; i < optionalSubjects.size(); i++) 
				{
					if(s.equalsIgnoreCase(optionalSubjects.get(i).getSubjectName())) return optionalSubjects.get(i);
					
					if(i >= optionalSubjects.size() - 1) System.out.println("Opção Inválida");
				}
			}
			
			catch(IOException e) 
			{
				System.out.print("Erro de Input!");
				System.out.println();
			}
		}
	}
	
	public static String aGender() 
	{
		String s = "";
		
		while(true) 
		{
			try 
			{
				System.out.print("(Masculino/Feminino) ");
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				if (s.equalsIgnoreCase("masculino") || s.equalsIgnoreCase("Masculino")) 
				{
		            return "Masculino";
		        } 
				
				else if (s.equalsIgnoreCase("feminino") || s.equalsIgnoreCase("Feminino")) 
				{
		            return "Feminino";
		        } 
				
				else if (s.equalsIgnoreCase("outro") || s.equalsIgnoreCase("Outro")) 
				{
		            return "Outro";
		        } 
				
				else 
				{
		            System.out.println("Género Inválido!");
		        }
			}
			
			catch (IOException e)
			{
				System.out.print("Erro de Input!");
				System.out.println();
			}
		}
	}
}
