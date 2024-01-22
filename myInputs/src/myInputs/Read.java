package myInputs;

import java.io.*;
import java.time.LocalDate;

/**
 * Provides static methods to read different types of inputs from the console. This class handles
 * input for strings, integers, various other primitive data types, LocalDate, and specific types
 * like gender and confirmation questions.
 */
public class Read 
{
	/**
     * Reads a string from the console, ensuring it is not empty.
     *
     * @return The string entered by the user.
     */
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
	
	/**
     * Waits for the user to press the Enter key.
     *
     * @return An empty string after the Enter key is pressed.
     */
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
	
	/**
     * Reads an integer value from the console.
     *
     * @return The integer value entered by the user.
     */
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
	
	/**
     * Reads a byte value from the console.
     *
     * @return The byte value entered by the user.
     */
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
	
	/**
     * Reads a short value from the console.
     *
     * @return The short value entered by the user.
     */
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
	
	/**
     * Reads a long value from the console.
     *
     * @return The long value entered by the user.
     */
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
	
	/**
     * Reads a float value from the console.
     *
     * @return The float value entered by the user.
     */
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
	
	/**
     * Reads a double value from the console.
     *
     * @return The double value entered by the user.
     */
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
	
	/**
     * Reads a single character from the console.
     *
     * @return The first character of the string entered by the user.
     */
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
	
	/**
     * Reads a boolean value from the console.
     * Accepts 'true' or 'false' as valid inputs.
     *
     * @return The boolean value entered by the user.
     */
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
		
	/**
     * Reads a LocalDate value from the console in the format YYYY-MM-DD.
     *
     * @return The LocalDate value entered by the user.
     */
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
	
	/**
     * Provides a menu for the user to choose a gender and reads the user's choice.
     *
     * @return The string representing the chosen gender.
     */
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
	
	/**
     * Provides a menu for the user to respond with 'yes' or 'no' to a question and reads the user's choice.
     *
     * @return "sim" for 'yes' or "não" for 'no'.
     */
	public static String aQuestion() 
	{
		String s = "";
		while(true) 
		{
			try 
			{
				System.out.println("1.	Sim");
				System.out.println("2.	Não");
				System.out.println("\n3.	Voltar");
				
				System.out.print("\n-> ");
				BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
				s = in.readLine();
				
				if(s.equalsIgnoreCase("1")) return "sim";
				
				else if(s.equalsIgnoreCase("2")) return "não";

				else if(s.equalsIgnoreCase("3")) return "voltar";
				
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
