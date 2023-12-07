package menu;
import java.util.*;

import myInputs.Read;

public class Menu 
{
	private ArrayList<Option> options;
	private Stack<Menu> menuHistory;
	
	public int choice = 0;
	
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
        exit = new Option(choice, "Leave", new Executable(leave));
        choice++;

        Action comeBack = () -> back();
        back = new Option(choice, "Return", new Executable(comeBack));
        choice++;
        
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
		
		choice = Read.anInt();
		options.get(choice).getExecutable().execute();
		
		System.out.println();
		System.out.println("X - Return");
		System.out.println();
		
		char x = Read.aChar();
		if(x == 'x' || x == 'X') this.build();
	}
	public ArrayList<Option> getOptions()
	{
		return options;
	}
	
	public void addOption(Option option) 
	{
		if(options.contains(back) || options.contains(exit)) {
	        options.remove(back);
	        options.remove(exit);
	        
	        choice -= 2;
	    }
	    
	    options.add(option);
	    option.setNumber(choice);
	    choice++;
	    
	    options.add(back);
	    options.add(exit);

	    back.setNumber(choice);
	    choice++;
	    exit.setNumber(choice);
	    choice++;
	}
	
	public void removeOption(Option option)
	{
		options.remove(option);
		
		choice--;
	}	
	
	public Stack<Menu> getMenuHistory()
	{
		return menuHistory;
	}
	
	public void setMenuHistory(Stack<Menu> menuHistory) 
	{
        this.menuHistory = menuHistory;
    }
	
	public void addMenuHistory(Menu pastMenu) 
	{
		menuHistory.add(pastMenu);
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
            this.build();
        }
        else this.build();
    }
}
