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
    	
    	Action a3 = () -> sub.build();
    	MenuOption o3 = new MenuOption(main.choice, "Mudar de Menu", new Executable(a3));
    	main.addOption(o3);
    	
    	Question qName = new Question("Escreva o nome da pessoa: ", "Name", "String"); //x
    	Question qGender = new Question("Escreva o género da pessoa: ", "Gender", "Gender");
    	Question qAddress = new Question("Escreva a morada da pessoa: ", "Address", "String");
    	Question qBirthday = new Question("Escreva o aniversário da pessoa: ", "Birthday", "LocalDateTime");
    	
    	ArrayList<Question> questions = new ArrayList<Question>();
    	questions.add(qName);
    	questions.add(qGender);
    	questions.add(qBirthday);
    	questions.add(qAddress);
    	
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