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
			BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
			s= in.readLine();
		}
		catch (IOException e)
		{
			System.out.print("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
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
				System.out.println("Error!");
			}
		}
	} 
	
	public static LocalDateTime aLocalDateTime() 
	{
		while(true)
		{
			try
			{
				return LocalDateTime.parse(aString().trim());
			}
			catch(Exception e)
		{
				System.out.println("Error!");
			}
		}
	}
}
