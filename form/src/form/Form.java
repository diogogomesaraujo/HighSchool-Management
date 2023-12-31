package form;

import java.util.*;
import java.lang.reflect.*;

/**
 * Represents a form with a collection of questions. This class provides functionality
 * to manage the form's questions and an associated object, with methods to update the object
 * based on answers to the questions.
 */
public class Form 
{
    private String name;
    private ArrayList<Question> questions;
    private Object object;

    /**
     * Default constructor. Initializes an empty form with a default object and no name.
     */
    public Form() 
    {
        this.questions = new ArrayList<Question>();
        this.object = new Object();
        this.name = "";
    }
    
    /**
     * Constructs a Form with a specified name, list of questions, and an associated object.
     *
     * @param name The name of the form.
     * @param questions The list of questions in the form.
     * @param object The object associated with the form.
     */
    public Form(String name, ArrayList<Question> questions, Object object)
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
        return object;
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
	
    /**
     * Updates a field of the associated object based on the answer to a given question.
     * Reflectively invokes a setter method on the object to update the field.
     *
     * @param question The question containing the answer and parameter to update.
     */
    private void updateObjectField(Question question) 
    {
        String methodName = "set" + question.getParameter();
        Object answer = question.getOutput();

        try 
        {
            Method method = object.getClass().getMethod(methodName, answer.getClass());
            method.invoke(object, answer);
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Builds and processes the form. Displays questions, reads answers, and updates the associated object.
     * Handles questions with dependencies by passing additional information as needed.
     */
	public void build() 
	{
		System.out.println("\n====== Formulário ========\n");
        Object extraInfo = null;

        for (Question question : questions) 
        {
            question.writeQuestion();
            question.readAnswer(extraInfo);
            
            System.out.println();
            
            updateObjectField(question);
            
            //for the questions with dependencies
            if (question.getParameter().equals("EnrolledCourse")) 
            {
                extraInfo = question.getOutput();
            }
        }

        System.out.println("======= Sucedido ========");
	}
}
