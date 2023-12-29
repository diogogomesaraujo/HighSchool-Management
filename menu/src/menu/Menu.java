package menu;
import java.util.ArrayList;
import myInputs.Read;

public class Menu 
{
    private ArrayList<MenuOption> menuOptions;
    private Menu parentMenu;
    private int choice = 1;
    
    public MenuOption exit;
    public MenuOption back;

    public Menu(Menu parentMenu) 
    {
        this.menuOptions = new ArrayList<MenuOption>();
        this.parentMenu = parentMenu;
        
        initDefaultOptions();
    }

    private void initDefaultOptions() 
    {
        Action comeBack = () -> back();
        back = new MenuOption(choice, "Voltar", new Executable(comeBack));
        choice++;
        
        Action leave = () -> System.exit(0);
        exit = new MenuOption(choice, "Sair", new Executable(leave));
        choice++;
        
        menuOptions.add(back);
        menuOptions.add(exit);
    }
    
    public int getChoice() 
    {
    	return choice;
    }

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

    public void removeOption(MenuOption option) 
    {
        menuOptions.remove(option);
        choice--;
    }

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
