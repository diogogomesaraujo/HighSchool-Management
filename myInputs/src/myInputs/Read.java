package myInputs;

import java.io.*;
import java.time.LocalDate;

public class Read 
{
	public static String aString() 
	{
		String s = "";
		while(true) 
		{
			try 
			{
				System.out.print("-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				if(!s.equals("")) return s;
				
				else System.out.println("\nErro de Input!\n");
			}
			
			catch (IOException e)
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static String aEnter() 
	{
		String s = "";
		while(true) 
		{
			try 
			{
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				return "";
			}
			
			catch (IOException e)
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
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
				System.out.println("\nErro de Input!");
				System.out.println();
			}
			
		}
		
	}
	
	public static byte aByte()
	{
		while(true)
		{
			try
			{
				return Byte.parseByte(aString().trim());
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static short aShort()
	{
		while(true){
			try
			{
				return Short.parseShort(aString().trim());
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static long aLong()
	{
		while(true){
			try
			{
				return Long.parseLong(aString().trim());
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static float aFloat()
	{
		while(true){
			try
			{
				return Float.parseFloat(aString().trim());
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static double aDouble()
	{
		while(true)
		{
			try
			{
				return Double.valueOf(aString().trim());
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static char aChar()
	{
		while(true)
		{
			try
			{
				return aString().charAt(0);
			}
			catch(Exception e)
			{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static boolean aBoolean()
	{
		while(true)
		{
			try
			{
				return Boolean.parseBoolean(aString().trim());
			}
			catch(Exception e)
		{
				System.out.println("\nErro de Input!");
				System.out.println();
			}
		}
	} 
	
	public static LocalDate aLocalDate() 
	{
		while(true)
		{
			try
			{	
				return LocalDate.parse((aString()).trim());
			}
			catch(Exception e)
		{
				System.out.println("\nErro de Input!");
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
				System.out.println("1.	Masculino");
				System.out.println("2.	Feminino");
				System.out.println("3.	Outro");
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s= in.readLine();
				
				if (s.equalsIgnoreCase("1")) return "Masculino";
				
				else if (s.equalsIgnoreCase("2")) return "Feminino";
				
				else if (s.equalsIgnoreCase("3")) return "Outro";
				
				else 
				{
		            System.out.println("Opção Inválido!");
		        }
			}
			
			catch (IOException e)
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
	}
	
	public static String aQuestion() 
	{
		String s = "";
		while(true) 
		{
			try 
			{
				System.out.println("1.	Sim");
				System.out.println("2.	Não");
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				if(s.equalsIgnoreCase("1")) return "sim";
				
				else if(s.equalsIgnoreCase("2")) return "não";
				
				else System.out.println("Opção Inválida!");
			}
			catch (IOException e)
			{
				System.out.print("\nErro de Input!");
				System.out.println();
			}
		}
	}
}
