package menu;

public class MenuOption
{
	private int number;
	private String text;
	private Executable executable;
	
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
	
	public void writeOptions() 
	{
		System.out.println(number + " - " + text);
	}
}
