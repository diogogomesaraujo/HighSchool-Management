package classes;

import java.util.*;

/**
 * Interface defining a set of predefined academic subjects. Each subject is represented
 * as a static final variable of type Subject. This interface is useful for standardizing
 * subject names across an educational system.
 * Additionally, it provides a compiled list of all predefined subjects.
 */
public interface PredefinedSubjects {
    
    /** Predefined subject for Portuguese language studies. */
    public static final Subject portuguese = new Subject("Português");

    /** Predefined subject for Mathematics. */
    public static final Subject maths = new Subject("Matemática");

    /** Predefined subject for Foreign Language studies. */
    public static final Subject foreignLanguage = new Subject("Língua Estrangeira");

    /** Predefined subject for Philosophy. */
    public static final Subject philosophy = new Subject("Filosofia");

    /** Predefined subject for Physical Education. */
    public static final Subject physicalEducation = new Subject("Educação Física");

    /** Predefined subject for Physics and Chemistry. */
    public static final Subject physicsAndChemestry = new Subject("Físca e Química");

    /** Predefined subject for Biology and Geology. */
    public static final Subject biology = new Subject("Biologia e Geologia");

    /** Predefined subject for History. */
    public static final Subject history = new Subject("História");

    /** Predefined subject for Mathematics Applied to Social Sciences. */
    public static final Subject macs = new Subject("Matemática Aplicada às Ciências Sociais");

    /** Predefined subject for Geography. */
    public static final Subject geography = new Subject("Geografia");

    /** Predefined subject for Drawing. */
    public static final Subject drawing = new Subject("Desenho");

    /** Predefined subject for Descriptive Geometry. */
    public static final Subject geometry = new Subject("Geometria Descritiva");

    /** Predefined subject for History and Culture of Arts. */
    public static final Subject historyOfArt = new Subject("História e Cultura das Artes");

    /** Predefined subject for Economics. */
    public static final Subject economy = new Subject("Economia");

    /** Predefined subject for Literature. */
    public static final Subject literature = new Subject("Literatura");

    /** Compiled list of all predefined subjects. */
    public static final ArrayList<Subject> subjects = new ArrayList<Subject>(Arrays.asList(
            portuguese, maths, foreignLanguage, philosophy, physicalEducation, physicsAndChemestry,
            biology, history, macs, geography, drawing, geometry, historyOfArt, economy, literature));
}
