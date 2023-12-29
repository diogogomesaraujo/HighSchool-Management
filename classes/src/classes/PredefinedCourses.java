package classes;

import java.util.*;

public interface PredefinedCourses 
{
	public static final ArrayList<Subject> sciencesSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.maths, PredefinedSubjects.biology, PredefinedSubjects.portuguese, PredefinedSubjects.geometry, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.physicsAndChemestry, PredefinedSubjects.foreignLanguage));
	public static final ArrayList<Subject> artsSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.macs, PredefinedSubjects.drawing, PredefinedSubjects.portuguese, PredefinedSubjects.geometry, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.historyOfArt, PredefinedSubjects.geography));
	public static final ArrayList<Subject> economySubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.maths, PredefinedSubjects.portuguese, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.foreignLanguage, PredefinedSubjects.economy, PredefinedSubjects.geography, PredefinedSubjects.history));
	public static final ArrayList<Subject> humanSciencesSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.history, PredefinedSubjects.portuguese, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.macs, PredefinedSubjects.foreignLanguage, PredefinedSubjects.geography, PredefinedSubjects.literature));
	
	public static final Course sciences = new Course("Ciências", sciencesSubjects);
	public static final Course arts = new Course("Artes", artsSubjects);
	public static final Course economy = new Course("Economia", economySubjects);
	public static final Course humanSciences = new Course("Humanidades", humanSciencesSubjects);
	
	public static final ArrayList<Subject> sciencesOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.biology, PredefinedSubjects.geometry));
	public static final ArrayList<Subject> artsOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.macs, PredefinedSubjects.historyOfArt));
	public static final ArrayList<Subject> economyOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.geography, PredefinedSubjects.history));
	public static final ArrayList<Subject> humanSciencesOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.macs, PredefinedSubjects.literature));
	
	public static final ArrayList<Course> courses = new ArrayList<Course>(Arrays.asList(arts, sciences, economy, humanSciences));
}
