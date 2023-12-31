package classes;

import java.util.*;

/**
 * Interface defining a set of predefined courses and subjects for an educational system.
 * This interface provides predefined lists of subjects for different course types,
 * predefined courses themselves, and also maintains lists of optional subjects
 * for each course type. Additionally, it holds constants for student and teacher IDs.
 */
public interface PredefinedCourses 
{
    
    /** Predefined subjects for the Sciences course. */
    public static final ArrayList<Subject> sciencesSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.maths, PredefinedSubjects.biology, PredefinedSubjects.portuguese, PredefinedSubjects.geometry, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.physicsAndChemestry, PredefinedSubjects.foreignLanguage));

    /** Predefined subjects for the Arts course. */
    public static final ArrayList<Subject> artsSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.macs, PredefinedSubjects.drawing, PredefinedSubjects.portuguese, PredefinedSubjects.geometry, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.historyOfArt, PredefinedSubjects.geography));

    /** Predefined subjects for the Economy course. */
    public static final ArrayList<Subject> economySubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.maths, PredefinedSubjects.portuguese, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.foreignLanguage, PredefinedSubjects.economy, PredefinedSubjects.geography, PredefinedSubjects.history));

    /** Predefined subjects for the Human Sciences course. */
    public static final ArrayList<Subject> humanSciencesSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.history, PredefinedSubjects.portuguese, PredefinedSubjects.physicalEducation, PredefinedSubjects.philosophy, PredefinedSubjects.macs, PredefinedSubjects.foreignLanguage, PredefinedSubjects.geography, PredefinedSubjects.literature));

    /** Predefined course instance for Sciences. */
    public static final Course sciences = new Course("Ciências", sciencesSubjects);

    /** Predefined course instance for Arts. */
    public static final Course arts = new Course("Artes", artsSubjects);

    /** Predefined course instance for Economy. */
    public static final Course economy = new Course("Economia", economySubjects);

    /** Predefined course instance for Human Sciences. */
    public static final Course humanSciences = new Course("Humanidades", humanSciencesSubjects);

    /** Optional subjects for the Sciences course. */
    public static final ArrayList<Subject> sciencesOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.biology, PredefinedSubjects.geometry));

    /** Optional subjects for the Arts course. */
    public static final ArrayList<Subject> artsOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.macs, PredefinedSubjects.historyOfArt));

    /** Optional subjects for the Economy course. */
    public static final ArrayList<Subject> economyOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.geography, PredefinedSubjects.history));

    /** Optional subjects for the Human Sciences course. */
    public static final ArrayList<Subject> humanSciencesOptionalSubjects = new ArrayList<>(Arrays.asList(PredefinedSubjects.macs, PredefinedSubjects.literature));

    /** List of all predefined courses. */
    public static final ArrayList<Course> courses = new ArrayList<Course>(Arrays.asList(arts, sciences, economy, humanSciences));

    /** Constant for the last assigned student ID. */
    public static final int studentLastID = 0;

    /** Constant for the last assigned teacher ID. */
    public static final int teacherLastID = 0;
}
