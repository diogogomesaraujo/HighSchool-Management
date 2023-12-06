package menu;
import java.util.*;

import myInputs.Read;

public class Menu 
{
	private ArrayList<Option> options;
	private Stack<Menu> menuHistory;
	
	public Option exit;
	public Option back;
	
	public Menu() 
	{
		this.options = new ArrayList<Option>();
		this.menuHistory = new Stack<Menu>();
		initDefaultOptions();
	}
	
	public Menu(ArrayList<Option> options, Stack<Menu> menuHistory) 
	{
		this.options = options;
		this.menuHistory = menuHistory;
		initDefaultOptions();
	}
	
	private void initDefaultOptions() 
	{
        Action leave = () -> System.exit(0);
        exit = new Option(options.size() + 1, "Leave", new Executable(leave));

        Action comeBack = () -> back();
        back = new Option(options.size(), "Return", new Executable(comeBack));
        
        
        options.add(back);
        options.add(exit);
    }
	
	public void build() 
	{
		System.out.println("Menu:");
		System.out.println();
		
		for(int i = 0; i < options.size(); i++) 
		{
			options.get(i).writeOptions();
			System.out.println();
		}
		
		int optionNumber = Read.anInt();
		options.get(optionNumber).getExecutable().execute();
	}
	
	public void menuToPastMenu() 
	{
		
	}
	
	public ArrayList<Option> getOptions()
	{
		return options;
	}
	
	public Stack<Menu> getMenuHistory()
	{
		return menuHistory;
	}
	
	public void setMenuHistory(Stack<Menu> menuHistory) 
	{
        this.menuHistory = menuHistory;
    }
	
	private void updateMenuState(Menu previousMenu) 
	{
        this.options = previousMenu.getOptions();
        this.menuHistory = previousMenu.getMenuHistory();
    }
	
	public void back() 
	{
        if (!menuHistory.isEmpty()) 
        {
        	Menu previousMenu = menuHistory.pop();
            updateMenuState(previousMenu);
        }
    }
}
