package forms;

import java.util.*;
import java.lang.reflect.*;
import java.time.LocalDateTime;

public class Form 
{
	private String name;
	private ArrayList<Question> questions;
	private Object object;
	
	public Form() 
	{
		this.questions = new ArrayList<Question>();
		this.object = new Object();
		this.name = "";
	}
	
	public Form(String name,ArrayList<Question> questions, Object object)
	{
		this.name = name;
		this.questions = questions;
		this.object = object;
	}
	
	public ArrayList<Question> getQuestions()
	{
		return questions;
	}
	
	public void setQuestions(ArrayList<Question> questions) 
	{
		this.questions = questions;
	}
	
	public Object getObject()
	{
		return questions;
	}
	
	public void setObject(Object object) 
	{
		this.object = object;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void updateObject() 
	{
		for (Question question : questions) 
		{
	        String methodName = "set" + question.getParameter(); // Construct the setter method name
	        Object answer = question.getOutput(); // The answer, which could be of any type
	        
	        try {
	            Method method;
	            if (answer instanceof String) 
	            {
	                method = object.getClass().getMethod(methodName, String.class);
	            } else if (answer instanceof Integer) 
	            {
	                method = object.getClass().getMethod(methodName, int.class);
	            } else if (answer instanceof LocalDateTime) 
	            {
	                method = object.getClass().getMethod(methodName, LocalDateTime.class);
	            } else 
	            {
	                // Handle other types as necessary
	                continue; // Skip if the type is not recognized
	            }
	            method.invoke(object, answer); // Invoke the setter method with the correct type
	        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void build() 
	{
		System.out.println(name);
		System.out.println();
		
		for(int i = 0; i < questions.size(); i++) 
		{
			questions.get(i).writeQuestion();
			questions.get(i).readAnswer();
		}
		
		updateObject();
		
		System.out.println("O formulário foi preenchido com sucesso!");
	}
	
}
