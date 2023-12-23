package menu;
import java.util.*;

import myInputs.Read;

/**
 * The {@code Menu} class represents a menu in a user interface. 
 * It contains menu options and manages navigation between different menus,
 * including options to exit or go back in the menu hierarchy.
 */
public class Menu 
{
	
	private ArrayList<MenuOption> menuOptions;
	private Stack<Menu> menuHistory;

	/**
	 * The number of the option and the value for its choice simultaneously.
	 */
	public int choice = 0;

	/**
	 * The menu option for exiting the application.
	 */
	public MenuOption exit;

	/**
	 * The menu option for going back to the previous menu.
	 */
	public MenuOption back;
	
	/**
     * Constructs a basic {@code Menu} with default exit and back options.
     */
	public Menu() 
	{
		this.menuOptions = new ArrayList<MenuOption>();
		this.menuHistory = new Stack<Menu>();
		initDefaultOptions();
	}
	
	 /**
      * Constructs a {@code Menu} with specific menu options and history.
      * 
      * @param menuOptions  The list of initial {@code MenuOption} objects for the menu.
      * @param menuHistory  A stack representing the history of menus navigated so far.
      */
	public Menu(ArrayList<MenuOption> menuOptions, Stack<Menu> menuHistory) 
	{
		this.menuOptions = menuOptions;
		this.menuHistory = menuHistory;
		initDefaultOptions();
	}
	
	/**
     * Initializes the default menu options for exit and back.
     */
	private void initDefaultOptions() 
	{

        Action comeBack = () -> back();
        back = new MenuOption(choice, "Return", new Executable(comeBack));
        choice++;
        
        Action leave = () -> System.exit(0);
        exit = new MenuOption(choice, "Leave", new Executable(leave));
        choice++;
        
        menuOptions.add(back);
        menuOptions.add(exit);
    }
	
	/**
     * Builds and displays the menu, allowing the user to select an option.
     * Handles user input to execute the selected menu option.
     */
	public void build() 
	{
		System.out.println("\n========= Menu =========");
		System.out.println();
		
		for(int i = 0; i < menuOptions.size(); i++) 
		{
			menuOptions.get(i).writeOption();
		}

		System.out.print("\nEnter your choice ");
		
		choice = Read.anInt();
		menuOptions.get(choice).getExecutable().execute();
		System.out.println();
		
		System.out.print("\nEnter x to return ");
		
		char x = Read.aChar();
		if(x == 'x' || x == 'X') this.build();
	}
	
	/**
     * Returns the list of menu options.
     * 
     * @return The list of {@code MenuOption} objects in this menu.
     */
	public ArrayList<MenuOption> getOptions()
	{
		return menuOptions;
	}
	
	/**
     * Adds a new {@code MenuOption} to the menu.
     * Reorganizes the exit and back options to be the last in the list.
     * 
     * @param option The {@code MenuOption} to add to the menu.
     */
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
	
	/**
     * Removes a {@code MenuOption} from the menu.
     * 
     * @param option The {@code MenuOption} to be removed from the menu.
     */
	public void removeOption(MenuOption option)
	{
		menuOptions.remove(option);
		
		choice--;
	}	
	
	/**
     * Returns the history of navigated menus.
     * 
     * @return The stack of {@code Menu} objects representing the navigated menu history.
     */
	public Stack<Menu> getMenuHistory()
	{
		return menuHistory;
	}
	
	/**
     * Sets the menu history to the specified stack of menus.
     * 
     * @param menuHistory The stack of {@code Menu} objects to set as the history.
     */
	public void setMenuHistory(Stack<Menu> menuHistory) 
	{
        this.menuHistory = menuHistory;
    }
	
	/**
     * Adds a menu to the navigation history.
     * 
     * @param pastMenu The {@code Menu} to be added to the history.
     */
	public void addMenuHistory(Menu pastMenu) 
	{
		menuHistory.add(pastMenu);
	}
	
	/**
     * Updates the current menu state based on the previous menu.
     * 
     * @param previousMenu The {@code Menu} to use for updating the current menu state.
     */
	private void updateMenuState(Menu previousMenu) 
	{
        this.menuOptions = previousMenu.getOptions();
        this.menuHistory = previousMenu.getMenuHistory();
    }
	
	/**
     * Handles the backward navigation in the menu history.
     * Rebuilds the previous menu if available, otherwise rebuilds the current menu.
     */
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
