package menu;

import java.util.*;

import myInputs.Read;

public class TestMenu 
{
    public static void main(String[] args) 
    {
    	Menu main = new Menu();
    	Menu sub = new Menu();
    	sub.addMenuHistory(main);
    	
    	Action a1 = () -> System.out.println("Olá");
    	Option o1 = new Option(main.choice, "Escrever: Olá", new Executable(a1));
    	main.addOption(o1);
    	
    	Action a2 = () -> System.out.println("Adeus");
    	Option o2 = new Option(main.choice, "Escrever: Adeus", new Executable(a2));
    	main.addOption(o2);
    	
    	Action a3 = () -> sub.build();
    	Option o3 = new Option(main.choice, "Mudar de Menu", new Executable(a3));
    	main.addOption(o3);
    	
    	sub.addOption(o1);
    	sub.addOption(o2);
    	
    	main.build();
    }
}