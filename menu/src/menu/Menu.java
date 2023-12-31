package menu;

import java.util.ArrayList;
import myInputs.Read;

/**
 * Represents a menu in a text-based user interface. This class manages a list of menu options
 * and provides functionality to display these options, handle user input, and navigate between
 * different menus including parent and child menus.
 */
public class Menu 
{
    private ArrayList<MenuOption> menuOptions;
    private Menu parentMenu;
    private int choice = 1;
    
    public MenuOption exit;
    public MenuOption back;
    
    /**
     * Constructs a Menu with a reference to its parent menu.
     *
     * @param parentMenu The parent menu of this menu. Can be null if it's a top-level menu.
     */
    public Menu(Menu parentMenu) 
    {
        this.menuOptions = new ArrayList<MenuOption>();
        this.parentMenu = parentMenu;
        
        initDefaultOptions();
    }

    /**
     * Initializes the default menu options - Back and Exit.
     * The Back option returns to the parent menu, and the Exit option saves data and exits the application.
     */
    private void initDefaultOptions() 
    {
        Action comeBack = () -> back();
        back = new MenuOption(choice, "Voltar", new Executable(comeBack));
        choice++;
        
        Action leave = () -> leave();
        exit = new MenuOption(choice, "Sair e Salvar", new Executable(leave));
        choice++;
        
        menuOptions.add(back);
        menuOptions.add(exit);
    }
    
    /**
     * Handles the action to leave the menu. This method saves data and exits the application.
     */
    private void leave() 
    {
    	form.Forms.writeInFile();
    	
    	System.out.println("\nA guardar os dados no ficheiro...\n");
    	
    	System.exit(0);
    }
    
    public int getChoice() 
    {
    	return choice;
    }

    /**
     * Builds and displays the menu. This method prints all the menu options and handles user input.
     */
    public void build() 
    {
        System.out.println("\n========= Menu =========");
        System.out.println();
        
        for (int i = 1; i <= menuOptions.size(); i++) 
        {
            if(i == menuOptions.size() - 1) System.out.println();
            
            menuOptions.get(i - 1).writeOption();
        }
        
        System.out.print("\nEscreva a opção ");
        
        int input = Read.anInt();
        
        if (input >= 1 && input <= menuOptions.size()) 
        {
            menuOptions.get(input - 1).getExecutable().execute();
        } 
        
        else 
        {
            System.out.println("Opção inválida. Tente outra vez!");
            build();
        }
        
        System.out.print("\nPressione enter para voltar -> ");
        
        String x = Read.aEnter();
        
        this.build();
    }

    public ArrayList<MenuOption> getOptions() 
    {
        return menuOptions;
    }
    
    /**
     * Adds a new option to the menu.
     *
     * @param option The MenuOption to be added.
     */
    public void addOption(MenuOption option) 
    {
        if (menuOptions.contains(back) || menuOptions.contains(exit)) 
        {
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
     * Removes an option from the menu.
     *
     * @param option The MenuOption to be removed.
     */
    public void removeOption(MenuOption option) 
    {
        menuOptions.remove(option);
        choice--;
    }
    
    /**
     * Returns to the parent menu if it exists, or rebuilds the current menu.
     */
    public void back() 
    {
        if (parentMenu != null) 
        {
            parentMenu.build();
        } 
        
        else 
        {
            this.build();
        }
    }
}
