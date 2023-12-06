package menu;

import java.util.ArrayList;

import myInputs.Read;

public class TestMenu 
{

    public static void main(String[] args) 
    {       
       Action o = () -> System.out.println("Olá");
       Option ola = new Option(0, "Olá!", new Executable(o));
       
       ArrayList<Option> options = new ArrayList<Option>();
       
       options.add(ola);
       
       Menu mainMenu = new Menu(options, null);

       mainMenu.build();
       
       int x = Read.anInt();
       mainMenu.getOptions().get(x).getExecutable().execute();
       
       
    }
}