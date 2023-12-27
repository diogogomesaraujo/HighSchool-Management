package forms;

import myInputs.Read;
import classes.Course;

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
                
            case "LocalDateTime":
                output = Read.aLocalDateTime();
                break;
                
            case "Course":
                output = Read.aCourse();
                break;
                
            case "Gender":
            	output = Read.aGender();
                break;
                
            case "OptionalSubject":
                if (extraInfo instanceof Course) 
                {
                    output = Read.aOptionalSubject((Course) extraInfo);
                }
                break;
                
            default:
                output = null;
        }
    }
}
