package menu;

/**
 * The {@code MenuOption} class represents a single option in a menu. 
 * Each menu option has a unique number, a text description, and an associated executable action.
 */
public class MenuOption
{
    private int number;
    private String text;
    private Executable executable;

    /**
     * Constructs a new {@code MenuOption} with a specified number, text, and executable action.
     * 
     * @param number      The number assigned to the menu option.
     * @param text        The text description of the menu option.
     * @param executable  The {@code Executable} action associated with this menu option.
     */
    public MenuOption(int number, String text, Executable executable) 
    {
        this.number = number;
        this.text = text;
        this.executable = executable;
    }

    public int getNumber() 
    {
        return number;
    }

    public String getText() 
    {
        return text;
    }

    public Executable getExecutable() 
    {
        return executable;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setExecutable(Executable executable) {
        this.executable = executable;
    }

    /**
     * Displays the menu option's number and text to the console.
     */
    public void writeOption() 
    {
        System.out.println(number + ".	" + text);
    }
}
