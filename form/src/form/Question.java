package form;

import myInputs.Read;
import java.util.ArrayList;

import classes.Course;
import classes.Subject;

public class Question 
{
    private String text;
    private String parameter;
    private String typeOfParameter;
    private Object output;

    public Question(String text, String parameter, String typeOfParameter) 
    {
        this.text = text;
        this.parameter = parameter;
        this.typeOfParameter = typeOfParameter;
    }
    
    public Question(String text, String parameter, String typeOfParameter, ArrayList<String> availableObjects) 
    {
        this.text = text;
        this.parameter = parameter;
        this.typeOfParameter = typeOfParameter;
    }

    public String getText() 
    {
        return text;
    }

    public String getParameter() 
    {
        return parameter;
    }

    public Object getOutput() 
    {
        return output;
    }

    public void writeQuestion() 
    {
        System.out.println(text);
        System.out.println();
    }

    public void readAnswer(Object extraInfo) 
    {
        switch (typeOfParameter) 
        {
            case "String":
                output = Read.aString();
                break;
                
            case "Int":
                output = Read.anInt();
                break;
                
            case "LocalDate":
                output = Read.aLocalDate();
                break;
                
            case "Gender":
            	output = Read.aGender();
                break;
                
            case "Course":
            	output = Course.aCourse();
            	break;
                
            case "OptionalSubject":
            	output = Course.aOptionalSubject((Course)extraInfo);
            	break;
            	
            case "Subject":
            	output = Subject.aSubject();
            	break;
                
            default:
                output = null;
        }
    }
}
