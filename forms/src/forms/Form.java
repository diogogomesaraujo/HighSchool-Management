package forms;

import java.util.*;
import java.lang.reflect.*;
import java.time.LocalDateTime;

/**
 * The {@code Form} class represents a form with a collection of questions.
 * It allows for the dynamic creation of forms, updating an associated object
 * based on the responses to the questions.
 */
public class Form 
{
	/**
     * The name of the form.
     */
    private String name;

    /**
     * The list of questions that belong to the form.
     */
    private ArrayList<Question> questions;

    /**
     * The object that is going to be updated according to the forms answers.
     */
    private Object object;

    /**
     * Constructs an empty form.
     */
    public Form() 
    {
        this.questions = new ArrayList<Question>();
        this.object = new Object();
        this.name = "";
    }

    /**
     * Constructs a form with a specified name, object and questions.
     * 
     * @param name      The name of the form.
     * @param questions The list of questions that belong to the form.
     * @param object    The object that is going to be updated according to the forms answers.
     */
    public Form(String name, ArrayList<Question> questions, Object object)
    {
        this.name = name;
        this.questions = questions;
        this.object = object;
    }
	
	/**
     * Returns the list of questions in this form.
     *
     * @return An ArrayList of {@code Question} objects representing the questions in the form.
     */
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    /**
     * Sets the questions for this form.
     *
     * @param questions An ArrayList of {@code Question} objects to be set for the form.
     */
    public void setQuestions(ArrayList<Question> questions) 
    {
        this.questions = questions;
    }

    /**
     * Returns the associated object of this form.
     *
     * @return The object associated with this form.
     */
    public Object getObject()
    {
        return object;
    }

    /**
     * Sets the associated object for this form.
     *
     * @param object The object to be associated with this form.
     */
    public void setObject(Object object) 
    {
        this.object = object;
    }

    /**
     * Returns the name of this form.
     *
     * @return A string representing the name of the form.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this form.
     *
     * @param name The string to be set as the name of the form.
     */
    public void setName(String name) 
    {
        this.name = name;
    }
	
	/**
     * Updates the object based on the responses to the form's questions.
     * This is achieved by dynamically invoking setter methods of the object 
     * for each question answered.
     */
	public void updateObject() 
	{
		for (Question question : questions) // For each question that belongs to the list of questions
		{
	        String methodName = "set" + question.getParameter(); // Define the setter name by using the parameter
	        Object answer = question.getOutput(); // The answer, which could be of any type that is accounted for
	        
	        try {
	            Method method;
	            
	            if (answer instanceof String) 
	            {
	                method = object.getClass().getMethod(methodName, String.class);
	            } 
	            
	            else if (answer instanceof Integer) 
	            {
	                method = object.getClass().getMethod(methodName, int.class);
	            } 
	            
	            else if (answer instanceof LocalDateTime) 
	            {
	                method = object.getClass().getMethod(methodName, LocalDateTime.class);
	            } 
	            
	            else 
	            {
	                continue; // If the type is not recognized, skip
	            }
	            
	            method.invoke(object, answer); // Invoke the setter with the correct data type
	        } 
	        
	        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
	        {
	            e.printStackTrace();	// Trace for potential errors
	        }
	    }
	}
	
	/**
     * Builds and processes the form by displaying questions, reading answers, 
     * and updating the associated object.
     */
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
