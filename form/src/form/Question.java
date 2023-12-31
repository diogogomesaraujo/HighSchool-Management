package form;

import myInputs.Read;
import java.util.ArrayList;

import classes.Course;
import classes.Subject;

/**
 * Represents a question in a form. This class holds the question text, a parameter name,
 * the type of the parameter, and the output (answer) of the question.
 */
public class Question 
{
    private String text;
    private String parameter;
    private String typeOfParameter;
    private Object output;
    
    /**
     * Constructs a Question with specified text, parameter name, and parameter type.
     *
     * @param text The text of the question.
     * @param parameter The name of the related parameter.
     * @param typeOfParameter The type of the parameter.
     */
    public Question(String text, String parameter, String typeOfParameter) 
    {
        this.text = text;
        this.parameter = parameter;
        this.typeOfParameter = typeOfParameter;
    }
    
    /**
     * Constructs a Question with specified text, parameter name, parameter type,
     * and a list of available options (if applicable).
     *
     * @param text The text of the question.
     * @param parameter The name of the related parameter.
     * @param typeOfParameter The type of the parameter.
     * @param availableObjects A list of available options for the answer.
     */
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
    
    /**
     * Writes the question text to standard output.
     */
    public void writeQuestion() 
    {
        System.out.println(text);
        System.out.println();
    }
    
    /**
     * Reads the answer to the question from standard input, handling different types of parameters.
     * The method updates the 'output' field based on the type of parameter and user input.
     *
     * @param extraInfo Additional information that might be required to read the answer (e.g., for contextual questions).
     */
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
