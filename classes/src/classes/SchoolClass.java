package classes;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Represents a school class, including details such as class name, students, subject teachers,
 * subjects offered, and a timetable. This class provides methods for managing these aspects,
 * such as adding or removing students and teachers, and managing subjects.
 */
public class SchoolClass implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private String className;  // e.g., "10A"
    private ArrayList<Student> students;
    private ArrayList<Teacher> subjectTeachers;
    private ArrayList<Subject> classSubjects;
    private ArrayList<TimeCell> timetable;

    /**
     * Constructs a SchoolClass with a given name and list of subjects.
     * Initializes empty lists for students, subject teachers, and an empty timetable.
     *
     * @param className The name of the class.
     * @param courseSubjects The list of subjects offered in the class.
     */
    public SchoolClass(String className, List<Subject> courseSubjects) 
    {
        this.className = className;
        this.students = new ArrayList<>();
        this.subjectTeachers = new ArrayList<>();
        this.classSubjects = new ArrayList<>(courseSubjects);
        this.timetable = TimeCell.buildEmptyTimetable();
    }

    // Getters
    public String getClassName() 
    {
        return className;
    }

    public ArrayList<Student> getStudents() 
    {
        return students;
    }
    
    public ArrayList<TimeCell> getTimetable() 
    {
        return timetable;
    }

    public void setTimetable(ArrayList<TimeCell> timetable) 
    {
        this.timetable = timetable;
    }

    public ArrayList<Teacher> getSubjectTeachers() 
    {
        return subjectTeachers;
    }

    public ArrayList<Subject> getClassSubjects() 
    {
        return classSubjects;
    }

    // Setters
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public void setStudents(ArrayList<Student> students) 
    {
        this.students = students;
    }

    public void setSubjectTeachers(ArrayList<Teacher> subjectTeachers) 
    {
        this.subjectTeachers = subjectTeachers;
    }

    /**
     * Adds a student to the class. If the student is not already in the class,
     * they are added, and automatically enrolled in the subjects taught in this class.
     *
     * @param student The student to be added.
     */
    public void addStudent(Student student) 
    {
        if (!students.contains(student)) 
        {
            students.add(student);
            student.setEnrolledClass(this);

            // Automatically enroll the student in subjects taught in this class
            for (Subject subject : classSubjects) 
            {
                subject.enrollStudent(student);
            }
        } 
        
        else 
        {
            System.out.println("O aluno já se encontra na turma!");
        }
    }
    
    /**
     * Adds a teacher to the class. If the teacher is not already teaching in this class,
     * they are added to the subject teachers list.
     *
     * @param teacher The teacher to be added.
     */
    public void addTeacher(Teacher teacher) 
    {
    	if (!subjectTeachers.contains(teacher)) {
            subjectTeachers.add(teacher);
            //teacher.setEnrolledClass(this);
        } 
        
        else 
        {
            System.out.println("O professor já está atribuído a esta turma!");
        }
    }
    
    /**
     * Removes a student from the class.
     *
     * @param student The student to be removed.
     */
    public void removeStudent(Student student) 
    {
        students.remove(student);
    }
    
    /**
     * Adds a subject to the class along with its corresponding teacher.
     * Existing students in the class are automatically enrolled in the new subject.
     *
     * @param subject The subject to be added.
     * @param teacher The teacher for the subject.
     */
    public void addSubject(Subject subject, Teacher teacher) 
    {
        classSubjects.add(subject);
        subjectTeachers.add(teacher);
        subject.addTeacher(teacher);

        // Enroll existing students in the new subject
        for (Student student : students) 
        {
            subject.enrollStudent(student);
        }
    }
    
    /**
     * Removes a subject from the class. If the subject is in the class's subject list,
     * it is removed along with its corresponding teacher.
     *
     * @param subject The subject to be removed.
     */
    public void removeSubject(Subject subject) 
    {
        // Remove the subject from the list of subjects
        boolean removed = classSubjects.remove(subject);

        // If the subject was successfully removed, update the corresponding teacher list
        if (removed) {
            // Find the index of the subject in the classSubjects list
            int index = classSubjects.indexOf(subject);

            // Check if the index is valid
            if (index >= 0 && index < subjectTeachers.size()) 
            {
                // Remove the corresponding teacher from the subjectTeachers list
                subjectTeachers.remove(index);
            } 
            
            else 
            {
                // Handle the case where the index is out of bounds (this can be logged or reported)
                System.err.println("Opção Inválida!");
            }
        } 
        
        else 
        {
            // Handle the case where the subject was not found in the list (this can be logged or reported)
            System.err.println("Opção Inválida!");
        }
    }

    @Override
    public String toString() {
        String result = "";
        result += "Nome da Turma: " + className + "\n\n";

        result += "Alunos:\n";
        for (Student student : students) {
            result += "- " + student.getName() + "\n";
        }

        result += "\nProfessores de Disciplina:\n";
        for (Teacher teacher : subjectTeachers) {
            result += "- " + teacher.getName() + "\n";
        }

        result += "\nDisciplinas da Turma:\n";
        for (Subject subject : classSubjects) {
            result += "- " + subject.getSubjectName() + "\n";
        }

        return result;
    }
    
    /**
     * Retrieves a list of available subjects for a given time slot based on the teachers' availability.
     *
     * @param timeCell The time slot for which available subjects are to be determined.
     * @return An ArrayList of Subjects available in the given time slot.
     */
    public ArrayList<Subject> getAvailableSubjects(TimeCell timeCell) 
    {
    	ArrayList<Subject> availableSubjects = new ArrayList<Subject>();
    	
    	for(Teacher teacher : subjectTeachers) 
    	{
    		for(TimeCell aux : teacher.getTimetable()) 
    		{
    			if(aux.getHasClass() == false && aux.getTimePeriod().equals(timeCell.getTimePeriod()) && aux.getDayOfWeek().equals(timeCell.getDayOfWeek())) 
    			{
    				availableSubjects.add(teacher.getSubjectTaught());
    			}
    		}
    	}
    
    	return availableSubjects;
    }
}


