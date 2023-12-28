package classes;

import java.util.*;

public interface PredefinedSubjects 
{
	public static final Subject portuguese = new Subject("Português", "PT");
	public static final Subject maths = new Subject("Matemática", "MAT");
	public static final Subject foreignLanguage = new Subject("Língua Estrangeira", "LE");
	public static final Subject philosophy = new Subject("Filosofia", "FIL");
	public static final Subject physicalEducation = new Subject("Educação Física", "EF");
	public static final Subject physicsAndChemestry = new Subject("Físca e Química", "FQ");
	public static final Subject biology = new Subject("Biologia e Geologia", "BIO");
	public static final Subject history = new Subject("História", "HIS");
	public static final Subject macs = new Subject("Matemática Aplicada às Ciências Sociais", "MACS");
	public static final Subject geography = new Subject("Geografia", "GEO");
	public static final Subject drawing = new Subject("Desenho", "DES");
	public static final Subject geometry = new Subject("Geometria Descritiva", "GD");
	public static final Subject historyOfArt = new Subject("História e Cultura das Artes", "HCA");
	public static final Subject economy = new Subject("Economia", "ECO");
	public static final Subject literature = new Subject("Literatura", "LIT");
	
	public static final ArrayList<Subject> subjects = new ArrayList<Subject>(Arrays.asList(
			portuguese, maths, foreignLanguage, philosophy, physicalEducation, physicsAndChemestry,
			biology, history, macs, geography, drawing, geometry, historyOfArt, economy, literature));
}