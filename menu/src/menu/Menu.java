package menu;
import java.util.*;

import myInputs.Read;

public class Menu 
{
	private ArrayList<MenuOption> menuOptions;
	private Stack<Menu> menuHistory;
	
	public int choice = 0;
	
	public MenuOption exit;
	public MenuOption back;
	
	public Menu() 
	{
		this.menuOptions = new ArrayList<MenuOption>();
		this.menuHistory = new Stack<Menu>();
		initDefaultOptions();
	}
	
	public Menu(ArrayList<MenuOption> menuOptions, Stack<Menu> menuHistory) 
	{
		this.menuOptions = menuOptions;
		this.menuHistory = menuHistory;
		initDefaultOptions();
	}
	
	private void initDefaultOptions() 
	{
        Action leave = () -> System.exit(0);
        exit = new MenuOption(choice, "Leave", new Executable(leave));
        choice++;

        Action comeBack = () -> back();
        back = new MenuOption(choice, "Return", new Executable(comeBack));
        choice++;
        
        menuOptions.add(back);
        menuOptions.add(exit);
    }
	
	public void build() 
	{
		System.out.println("Menu:");
		System.out.println();
		
		for(int i = 0; i < menuOptions.size(); i++) 
		{
			menuOptions.get(i).writeOptions();
			System.out.println();
		}
		
		choice = Read.anInt();
		menuOptions.get(choice).getExecutable().execute();
		
		System.out.println();
		System.out.println("X - Return");
		System.out.println();
		
		char x = Read.aChar();
		if(x == 'x' || x == 'X') this.build();
	}
	public ArrayList<MenuOption> getOptions()
	{
		return menuOptions;
	}
	
	public void addOption(MenuOption option) 
	{
		if(menuOptions.contains(back) || menuOptions.contains(exit)) {
	        menuOptions.remove(back);
	        menuOptions.remove(exit);
	        
	        choice -= 2;
	    }
	    
	    menuOptions.add(option);
	    option.setNumber(choice);
	    choice++;
	    
	    menuOptions.add(back);
	    menuOptions.add(exit);

	    back.setNumber(choice);
	    choice++;
	    exit.setNumber(choice);
	    choice++;
	}
	
	public void removeOption(MenuOption option)
	{
		menuOptions.remove(option);
		
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
        this.menuOptions = previousMenu.getOptions();
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
