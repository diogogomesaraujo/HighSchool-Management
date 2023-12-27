package classes;

import java.util.*;

public interface PredefinedSubjects 
{
	public static final Subject portuguese = new Subject("Português", "Sala de Aula");
	public static final Subject maths = new Subject("Matemática", "Sala de Aula");
	public static final Subject foreignLanguage = new Subject("Língua Estrangeira", "Sala de Aula");
	public static final Subject philosophy = new Subject("Filosofia", "Sala de Aula");
	public static final Subject physicalEducation = new Subject("Educação Física", "Ginásio");
	public static final Subject physicsAndChemestry = new Subject("Físca e Química", "Sala de Aula");
	public static final Subject biology = new Subject("Biologia e Geologia", "Laboratório");
	public static final Subject history = new Subject("História", "Sala de Aula");
	public static final Subject macs = new Subject("Matemática Aplicada às Ciências Sociais", "Sala de Aula");
	public static final Subject geography = new Subject("Geografia", "Sala de Aula");
	public static final Subject drawing = new Subject("Desenho", "Sala de Desenho");
	public static final Subject geometry = new Subject("Geometria Descritiva", "Sala de Desenho");
	public static final Subject historyOfArt = new Subject("História e Cultura das Artes", "Sala de Aula");
	public static final Subject economy = new Subject("Economia", "Sala de Aula");
	public static final Subject literature = new Subject("Literatura", "Sala de Aula");
	
	public static final ArrayList<Subject> subjects = new ArrayList<Subject>(Arrays.asList(
			portuguese, maths, foreignLanguage, philosophy, physicalEducation, physicsAndChemestry,
			biology, history, macs, geography, drawing, geometry, historyOfArt, economy, literature));
}