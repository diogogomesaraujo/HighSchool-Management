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

    /**
     * Returns the number assigned to this menu option.
     * 
     * @return The number of this menu option.
     */
    public int getNumber() 
    {
        return number;
    }

    /**
     * Returns the text description of this menu option.
     * 
     * @return The text description of this menu option.
     */
    public String getText() 
    {
        return text;
    }

    /**
     * Returns the executable action associated with this menu option.
     * 
     * @return The {@code Executable} action of this menu option.
     */
    public Executable getExecutable() 
    {
        return executable;
    }

    /**
     * Sets the number for this menu option.
     * 
     * @param number The number to be assigned to this menu option.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Sets the text description for this menu option.
     * 
     * @param text The text description to be assigned to this menu option.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the executable action for this menu option.
     * 
     * @param executable The {@code Executable} action to be associated with this menu option.
     */
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
