package forms;

import myInputs.Read;

/**
 * The {@code Question} class represents a single question in a form. 
 * It stores the question text, the parameter name that the question corresponds to, 
 * and the type of the expected answer.
 */
public class Question 
{
    private String text;
    private String parameter;
    private String type;

    public Object output;

    /**
     * Constructs an empty question with no text, parameter, or type.
     */
    public Question() 
    {
        this.text = "";
        this.parameter = "";
        this.type = "";
    }

    /**
     * Constructs a question with specified text, parameter, and type.
     * 
     * @param text       The text of the question.
     * @param parameter  The name of the parameter that this question updates.
     * @param type       The type of the answer expected (e.g., "String", "Int", "LocalDateTime").
     */
    public Question(String text, String parameter, String type) 
    {
        this.text = text;
        this.parameter = parameter;
        this.type = type;
    }

    /**
     * Returns the text of this question.
     * 
     * @return A string representing the text of the question.
     */
    public String getText() 
    {
        return text;
    }

    /**
     * Returns the parameter name associated with this question.
     * 
     * @return A string representing the parameter name.
     */
    public String getParameter() 
    {
        return parameter;
    }

    /**
     * Sets the parameter name for this question.
     * 
     * @param parameter The string to be set as the parameter name.
     */
    public void setParameter(String parameter) 
    {
        this.parameter = parameter;
    }

    /**
     * Returns the output of this question, which is the answer provided.
     * 
     * @return An Object representing the answer to the question.
     */
    public Object getOutput() 
    {
        return output;
    }

    /**
     * Sets the output (answer) for this question.
     * 
     * @param output The answer to the question.
     */
    public void setOutput(Object output) 
    {
        this.output = output;
    }

    /**
     * Prints the text of the question to the console.
     */
    public void writeQuestion() 
    {
        System.out.println(text);
        System.out.println();
    }

    /**
     * Reads the answer from the user input based on the type of the question.
     * Utilizes the {@code Read} class methods to get the appropriate input.
     */
    public void readAnswer() 
    {
    	System.out.print("-> ");
        if(type.equals("String")) output = Read.aString();
        if(type.equals("Int")) output = Read.anInt();
        if(type.equals("LocalDateTime")) output = Read.aLocalDateTime();
    }
}