package myInputs;

import java.io.*;
import java.time.LocalDateTime;

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
	
	public static String aGender() 
	{
		String s = "";
		
		while(true) 
		{
			try 
			{
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
