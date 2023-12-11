package forms;

import myInputs.Read;

public class Question 
{
	private String text;
	private String parameter;
	private String type;
	
	public Object output;
	
	public Question() 
	{
		this.text = "";
		this.parameter = "";
		this.type = "";
	}
	
	public Question(String text, String parameter, String type) 
	{
		this.text = text;
		this.parameter = parameter;
		this.type = type;
	}
	
	public String getText() 
	{
        return text;
    }
	
	public String getParameter() 
	{
        return parameter;
    }
	
	public void setParameter(String parameter) 
	{
		this.parameter = parameter;
	}

    public Object getOutput() 
    {
        return output;
    }
    
    public void setOutput(Object output) 
    {
    	this.output = output;
    }
	
	public void writeQuestion() 
	{
		System.out.println(text);
		System.out.println();
	}
	
	public void readAnswer() 
	{
		if(type == "String") output = Read.aString();
		if(type == "Int") output = Read.anInt();
		if(type == "LocalDateTime") output = Read.aLocalDateTime();
	}
}
