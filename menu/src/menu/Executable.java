package menu;

public class Executable 
{
	private Action action;
	
	public Executable(Action action) 
	{
		this.action = action;
	}
	
	public void execute() 
	{
		if(action != null) 
		{
			action.execute();
		}
	}
}
