package classes;

import java.util.*;

public interface PredefinedSubjects 
{
	public static final Subject portuguese = new Subject("Português");
	public static final Subject maths = new Subject("Matemática");
	public static final Subject foreignLanguage = new Subject("Língua Estrangeira");
	public static final Subject philosophy = new Subject("Filosofia");
	public static final Subject physicalEducation = new Subject("Educação Física");
	public static final Subject physicsAndChemestry = new Subject("Físca e Química");
	public static final Subject biology = new Subject("Biologia e Geologia");
	public static final Subject history = new Subject("História");
	public static final Subject macs = new Subject("Matemática Aplicada às Ciências Sociais");
	public static final Subject geography = new Subject("Geografia");
	public static final Subject drawing = new Subject("Desenho");
	public static final Subject geometry = new Subject("Geometria Descritiva");
	public static final Subject historyOfArt = new Subject("História e Cultura das Artes");
	public static final Subject economy = new Subject("Economia");
	public static final Subject literature = new Subject("Literatura");
	
	public static final ArrayList<Subject> subjects = new ArrayList<Subject>(Arrays.asList(
			portuguese, maths, foreignLanguage, philosophy, physicalEducation, physicsAndChemestry,
			biology, history, macs, geography, drawing, geometry, historyOfArt, economy, literature));
}