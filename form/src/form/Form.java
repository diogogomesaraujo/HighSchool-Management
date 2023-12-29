package form;

import java.util.*;
import java.lang.reflect.*;

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
