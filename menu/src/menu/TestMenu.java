package menu;

import java.util.*;

import classes.*;
import forms.*;

public class TestMenu 
{
	
    public static void main(String[] args) 
    {
    	
    	Menu main = new Menu();
    	Menu sub = new Menu();
    	sub.addMenuHistory(main);
    	
    	Action a1 = () -> System.out.println("Olá");
    	MenuOption o1 = new MenuOption(main.choice, "Escrever: Olá", new Executable(a1));
    	main.addOption(o1);
    	
    	Action a2 = () -> System.out.println("Adeus");
    	MenuOption o2 = new MenuOption(main.choice, "Escrever: Adeus", new Executable(a2));
    	main.addOption(o2);
    	
    	Action a3 = () -> sub.build();
    	MenuOption o3 = new MenuOption(main.choice, "Mudar de Menu", new Executable(a3));
    	main.addOption(o3);
    	
    	sub.addOption(o1);
    	sub.addOption(o2);
    	
    	
    	Question qName = new Question("Qual é o nome da Pessoa?", "Name", "String");
    	Question qGender = new Question("Qual é o género?", "Gender", "String");
    	Question qAddress = new Question("Qual é a Morada", "Address", "String");
    	Question qBirthday = new Question("Qual é a data de Aniversário?", "Birthday", "LocalDateTime");
    	
    	ArrayList<Question> questions = new ArrayList<Question>();
    	questions.add(qAddress);
    	questions.add(qGender);
    	questions.add(qName);
    	questions.add(qBirthday);
    	
    	Person person = new Person();
    	
    	Form form = new Form("Criar Pessoa", questions, person);
    	
    	Action a4 = () -> form.build();
    	MenuOption o4 = new MenuOption(main.choice, "Criar Pessoa", new Executable(a4));
    	
    	Action a5 = () -> writePessoa(person);
    	MenuOption o5 = new MenuOption(main.choice, "Escrever Pessoa", new Executable(a5));
    	
    	main.addOption(o4);
    	main.addOption(o5);
    	
    	main.build();
    }
    
    public static void writePessoa(Person person) 
    {
    	System.out.println(person.getAddress());
    	System.out.println(person.getName());
    	System.out.println(person.getBirthday());
    	System.out.println(person.getGender());
    }
}