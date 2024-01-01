package form;

import classes.*;
import myInputs.Read;

import java.time.LocalTime;
import java.util.ArrayList;
import java.io.*;

/**
 * Provides static methods for creating, editing, and viewing various entities such as students, teachers,
 * courses, and classes. It also handles file operations for storing and retrieving these entities.
 */
public class Forms 
{
	public static ArrayList <Course> courses = PredefinedCourses.courses;
	
	 /**
     * Writes the list of predefined courses and other global variables to a file.
     */
	public static void writeInFile() 
	{
        try
        {
            FileOutputStream ficheiro = new FileOutputStream("Courses");
            ObjectOutputStream out = new ObjectOutputStream(ficheiro);
            
            out.writeObject(PredefinedCourses.courses);
            out.writeInt(Student.getNextStudentID());
            out.writeInt(Teacher.getNextTeacherID());
            out.writeChar(GlobalVariables.getLetter());
            
            out.close();
            ficheiro.close();
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	/**
     * Reads the list of predefined courses and other global variables from a file.
     */
	@SuppressWarnings("unchecked")
	public static void readFile() 
	{
	    try 
	    {
	    	File file = new File("Courses");
            if(!file.exists()) {
                file.createNewFile();
                
                System.out.println("A criar o ficheiro...\n");
            }
	    	
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            courses = (ArrayList<Course>) ois.readObject();   
	            Student.setNextStudentID(ois.readInt());
	            Teacher.setNextTeacherID(ois.readInt());
	            GlobalVariables.setLetter(ois.readChar());
	            ois.close();
	            fis.close();
	            
	            updatePredefinedCourses(courses);
	        } 
	    
	    catch (FileNotFoundException e) 
	    {
	    	e.printStackTrace();
	    } 
	    
	    catch (IOException e1) 
	    {
	        // TODO Auto-generated catch block
	    	e1.printStackTrace();
	    } 
	    
	    catch (ClassNotFoundException e) 
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	/**
     * Updates the list of predefined courses with the deserialized courses from the file.
     *
     * @param deserializedCourses The list of courses read from the file.
     */
	public static void updatePredefinedCourses(ArrayList<Course> deserializedCourses) 
	{
	    for (Course course : deserializedCourses) 
	    {
	        switch (course.getCourseName()) 
	        {
	            case "Ciências":
	                PredefinedCourses.sciencesSubjects.clear();
	                PredefinedCourses.sciencesSubjects.addAll(course.getSubjects());
	                updatePredefinedClasses(PredefinedCourses.sciences, course);
	                break;
	            case "Artes":
	                PredefinedCourses.artsSubjects.clear();
	                PredefinedCourses.artsSubjects.addAll(course.getSubjects());
	                updatePredefinedClasses(PredefinedCourses.arts, course);
	                break;
	            case "Economia":
	                PredefinedCourses.economySubjects.clear();
	                PredefinedCourses.economySubjects.addAll(course.getSubjects());
	                updatePredefinedClasses(PredefinedCourses.economy, course);
	                break;
	            case "Humanidades":
	                PredefinedCourses.humanSciencesSubjects.clear();
	                PredefinedCourses.humanSciencesSubjects.addAll(course.getSubjects());
	                updatePredefinedClasses(PredefinedCourses.economy, course);
	                break;
	        }
	    }
	}

	/**
     * Updates the list of classes in the predefined courses with the deserialized classes from the file.
     *
     * @param deserializedCourses The list of courses read from the file.
     */
	private static void updatePredefinedClasses(Course predefinedCourse, Course deserializedCourse) 
	{
	    predefinedCourse.setClasses(deserializedCourse.getClasses());
	}
    
    private static void createTimetable(SchoolClass schoolClass) 
	{	
		System.out.println("\n====== Formulário ========\n");
		
		for(int i = 0; i < schoolClass.getTimetable().size(); i++) 
		{
			ArrayList<Subject> availableSubjects = schoolClass.getAvailableSubjects(schoolClass.getTimetable().get(i));
			
			if(schoolClass.getTimetable().get(i).getTimePeriod().get(0).equals(LocalTime.of(8, 30))) 
			{
				System.out.println(schoolClass.getTimetable().get(i).getDayOfWeek() + ": \n");
			}
			
			System.out.println(schoolClass.getTimetable().get(i).timePeriodText() + "Adicionar Aula: \n");
			String aux = Read.aQuestion();
			
			if(aux.equals("sim")) 
			{
				System.out.println();
				System.out.println(schoolClass.getTimetable().get(i).timePeriodText() + "Escolha a disciplina: ");
				
				if(availableSubjects.size() != 0) 
				{
					Subject auxSubject = Subject.aSubject(availableSubjects);
					
					for(Teacher teacher : schoolClass.getSubjectTeachers()) 
					{
						if(teacher.getSubjectTaught().equals(auxSubject)) teacher.getTimetable().get(i).setHasClass(true);
					}
					
					schoolClass.getTimetable().get(i).setSubject(auxSubject);
					schoolClass.getTimetable().get(i).setHasClass(true);
				}
				
				else System.out.println("\nNão há professores disponíveis a essa hora!\n");
			}
		}
		
		 System.out.println("\n======= Sucedido ========");
	}

    /**
     * Creates a form for capturing student information and adds the student to the enrolled course.
     */
	public static void createStudentForm() 
	{
		Student student = new Student();
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		questions.add(new Question("Escreva o nome do aluno: ", "Name", "String"));
		questions.add(new Question("Escreva o género do aluno: ", "Gender", "Gender"));
		questions.add(new Question("Escreva a morada do aluno: ", "Address", "String"));
		questions.add(new Question("Escreva a data de nascimento do aluno (ano-mês-dia): ", "Birthday", "LocalDate"));
		questions.add(new Question("Escreva o curso do aluno: ", "EnrolledCourse", "Course"));
		questions.add(new Question("Escreva a disciplina opcional do aluno: ", "OptionalSubject", "OptionalSubject"));
		
		Form studentForm = new Form("Criar Aluno", questions, student);
		
		studentForm.build();
		
		System.out.println();
		student.getEnrolledCourse().enrollClass(student);
		
		System.out.println("\nO ID do Aluno é: " + student.getStudentID());
	}
	
	/**
     * Creates a form for capturing teacher information and assigns the teacher to the subject taught.
     */
	public static void createTeacherForm() 
	{
		Teacher teacher = new Teacher();
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		questions.add(new Question("Escreva o nome do professor: ", "Name", "String"));
		questions.add(new Question("Escreva o género do professor: ", "Gender", "Gender"));
		questions.add(new Question("Escreva a morada do professor: ", "Address", "String"));
		questions.add(new Question("Escreva a data de nascimento do professor (Ano-Mês-Dia): ", "Birthday", "LocalDate"));
		questions.add(new Question("Escreva a disciplina do professor: ", "SubjectTaught", "Subject"));
		
		Form teacherForm = new Form("Criar Professor", questions, teacher);
		
		teacherForm.build();
		
		teacher.getSubjectTaught().addTeacher(teacher);
		
		System.out.println("\nO ID do Professor é: " + teacher.getTeacherID());
	}
	
	/**
     * Creates and displays a timetable for a selected school class.
     */
	public static void createTimetableForm() 
	{
	    System.out.println("\nEscolha um curso da turma para fazer o horário: ");

	    Course selectedCourse = Course.aCourse();

	    System.out.println("\nEscolha a turma para fazer o horário:");

	    if (selectedCourse.getClasses().size() != 0) 
	    {
	        displayClassList(selectedCourse.getClasses());

	        int classChoice = Read.anInt();

	        if (classChoice >= 1 && classChoice <= selectedCourse.getClasses().size()) 
	        {
	            createTimetable(selectedCourse.getClasses().get(classChoice - 1));
	        } 
	        
	        else 
	        {
	            System.out.println("\nEscolha Inválida!");
	        }
	    } 
	    
	    else 
	    {
	        System.out.println("\nNão existem turmas inscritas neste curso!");
	    }
	}
	
	/**
     * Assigns a teacher to a selected class within a course.
     */
	public static void assignTeacherToClass() 
	{
System.out.println("\nEscolha um curso da turma: ");
	    
	    displayCourseList(PredefinedCourses.courses);
	    int courseChoiceForClass = Read.anInt() - 1;
	    
	    if (courseChoiceForClass >= 0 && courseChoiceForClass < PredefinedCourses.courses.size()) 
	    {
	        Course selectedCourse = PredefinedCourses.courses.get(courseChoiceForClass);
	
	        System.out.println("\nEscolha a turma para atribuir um professor:");
	        
	        if(selectedCourse.getClasses().size() != 0) 
	        {
	        	displayClassList(selectedCourse.getClasses());
	            
	            int classChoice = Read.anInt() - 1;
	
	            if (classChoice >= 0 && classChoice < selectedCourse.getClasses().size()) 
	            {
	            	System.out.println("\nEscreva o ID do professor: \n");
	       		 
	       	     	int teacherIdToView = Read.anInt();
	       	     
	       	     	Teacher teacherToView = findTeacherById(teacherIdToView);
	       	     	
	       	     	selectedCourse.getClasses().get(classChoice).addTeacher(teacherToView);
	            } 
	            
	            else 
	            {
	                System.out.println("\nEscolha Inválida!");
	            }
	        }
	        
	        else System.out.println("\nNão existem turmas inscritas neste curso!");
	    } 
	    
	    else 
	    {
	        System.out.println("\nEscolha Inválida!");
	    }
	    
	}

	
	/**
     * Edits the details of a student based on the specified parameter.
     *
     * @param parameterName The parameter to be edited (e.g., "Name", "Gender").
     */
	public static void editStudentDetails(String parameterName) 
	{
		System.out.println("\nEscreva o ID do aluno:\n");
		int studentIdToEdit = Read.anInt();
	     
	    Student studentToEdit = findStudentById(studentIdToEdit);
	     
	    if (studentToEdit != null) 
	    {
	        switch (parameterName) 
	        {
	            case "Name":
	                System.out.println("\nEscreva o novo nome do aluno: \n");
	                studentToEdit.setName(Read.aString());
	                break;

	            case "Gender":
	                System.out.println("\nEscreva o novo género do aluno: \n");
	                studentToEdit.setGender(Read.aGender());
	                break;

	            case "Birthday":
	                System.out.println("\nEscreva a nova data de nascimento do aluno: \n");
	                studentToEdit.setBirthday(Read.aLocalDate());
	                break;

	            case "Address":
	                System.out.println("\nEscreva a nova morada do aluno: \n");
	                studentToEdit.setAddress(Read.aString());
	                break;

	            case "EnrolledCourse and SchoolClass":
	                studentToEdit.getEnrolledClass().removeStudent(studentToEdit);
	               for (Subject subject : studentToEdit.getEnrolledClass().getClassSubjects()) 
	               {
	            	   subject.removeStudent(studentToEdit);
	               }

	                System.out.println("\nEscreva o novo curso do aluno: \n");
	                studentToEdit.setEnrolledCourse(Course.aCourse());

	                System.out.println("\nEscreva a disciplina opcional do aluno: \n");
	                studentToEdit.setOptionalSubject(Course.aOptionalSubject(studentToEdit.getEnrolledCourse()));

	                studentToEdit.getEnrolledCourse().enrollClass(studentToEdit);
	                break;

	            default:
	                System.out.println("Parâmetro desconhecido: " + parameterName);
	                break;
	        }
	    }
	     
	    else 
	    {
	        System.out.println("\nAluno não foi encontrado!");
	    }
	}
	
	/**
     * Edits the details of a teacher based on the specified parameter.
     *
     * @param parameterName The parameter to be edited (e.g., "Name", "Gender").
     */
	public static void editTeacherDetails(String parameterName) 
	{
		System.out.println("\nEscreva o ID do professor:\n");
		int teacherIdToEdit = Read.anInt();
	     
	    Teacher teacherToEdit = findTeacherById(teacherIdToEdit);
	     
	    if (teacherToEdit != null) 
	    {
	        if(parameterName.equals("Name"))
	        {
	        	System.out.println("\nEscreva o novo nome do professor: \n");
	        	teacherToEdit.setName(Read.aString());
	        }
	        
	        if(parameterName.equals("Gender")) 
	        {
	        	System.out.println("\nEscreva o novo género do professor: \n");
	        	teacherToEdit.setGender(Read.aGender());
	        }
	        
	        if(parameterName.equals("Birthday")) 
	        {
	        	System.out.println("\nEscreva a nova data de nascimento do professor: \n");
	        	teacherToEdit.setBirthday(Read.aLocalDate());
	        }
	        
	        if(parameterName.equals("Address")) 
	        {
	        	System.out.println("\nEscreva a nova morada do professor: \n");
	        	teacherToEdit.setGender(Read.aString());
	        }
	        
	        if(parameterName.equals("SubjectTaught")) 
	        {	
	        	teacherToEdit.setSubjectTaught(Subject.aSubject());
	        	
	        	teacherToEdit.getSubjectTaught().addTeacher(teacherToEdit); //fazer clone para o professor e depois eleminar o professor
	        }
	    } 
	     
	    else 
	    {
	        System.out.println("\nProfessor não foi encontrado!");
	    }
	}
	
	/**
     * Views the details of a timetable based on a class.
     */
	public static void viewTimetableDetails() 
	{
		System.out.println("\nEscolha um curso da turma para fazer o horário: ");
        
        displayCourseList(PredefinedCourses.courses);
        int courseChoiceForClass = Read.anInt() - 1;
        
        if (courseChoiceForClass >= 0 && courseChoiceForClass < PredefinedCourses.courses.size()) 
        {
            Course selectedCourse = PredefinedCourses.courses.get(courseChoiceForClass);

            System.out.println("\nEscolha a turma para fazer o horário:");
            
            if(selectedCourse.getClasses().size() != 0) 
            {
            	displayClassList(selectedCourse.getClasses());
                
                int classChoice = Read.anInt() - 1;

                if (classChoice >= 0 && classChoice < selectedCourse.getClasses().size()) 
                {
                    TimeCell.writeTimetable(selectedCourse.getClasses().get(classChoice).getTimetable());
                } 
                
                else 
                {
                    System.out.println("\nEscolha Inválida!");
                }
            }
            
            else System.out.println("\nNão existem turmas inscritas neste curso!");
        } 
        
        else 
        {
            System.out.println("\nEscolha Inválida!");
        }
	}
	
	/**
     * Views the details of a student based on their ID.
     */
	 public static void viewStudentDetails() 
	 {
	 	 // View Student Details
		 System.out.println("\nEscreva o ID do aluno:\n");
	     int studentIdToView = Read.anInt();
	     
	     Student studentToView = findStudentById(studentIdToView);
	     
	     if (studentToView != null) 
	     {
	         System.out.println("\n" + studentToView.toString());
	     } 
	     
	     else 
	     {
	         System.out.println("\nAluno não foi encontrado!");
	     }
	     
	 }
	 
	 /**
	  * Views the details of a teacher based on their ID.
	  */
	 public static void viewTeacherDetails() 
	 {
		 System.out.println("\nEscreva o ID do professor para ver os detalhes: \n");
		 
	     int teacherIdToView = Read.anInt();
	     
	     Teacher teacherToView = findTeacherById(teacherIdToView);
	     
	     if (teacherToView != null) 
	     {
	         System.out.println("\nDetalhes do Professor:");
	         System.out.println("\n" + teacherToView.toString());
	     } 
	     
	     else 
	     {
	         System.out.println("\nProfessor não foi encontrado!");
	     }
	 	
	 }
	 
	 /**
	  * Views the details of a course based on user selection.
	  */
	public static void viewCourseDetails() 
	{
		// View Course Details
		
		System.out.println("\nEscolha o curso para ver os detalhes:\n");
	    
	    Course selectedCourse = Course.aCourse();
	    
	    System.out.println("\nDetalhes do Curso: \n");
	    System.out.println("\n" + selectedCourse.toString());
	    
	}
	
	/**
     * Views the details of a subject based on user selection from a specific course.
     */
	public static void viewSubjectDetails() 
	{
	
	    // Choose a course
	    System.out.println("\nEscolha o curso para ver os detalhes da disciplina:");
	    
	    displayCourseList(PredefinedCourses.courses);
	    
	    System.out.println("Escreva o número da opção: \n");
	    int courseChoice = Read.anInt() - 1;
	
	    if (courseChoice >= 0 && courseChoice < PredefinedCourses.courses.size()) 
	    {
	        Course selectedCourse = PredefinedCourses.courses.get(courseChoice);
	
	        // Display the list of subjects in the chosen course
	        System.out.println("\nDisciplinas em " + selectedCourse.getCourseName() + ":");
	        displaySubjectList(selectedCourse.getSubjects());
	
	        // Enter the subject number
	        System.out.println("\nEscreva o número da opção: \n");
	        int subjectChoice = Read.anInt() - 1;
	        
	        String subjectName = selectedCourse.getSubjects().get(subjectChoice).getSubjectName();
	
	        // Find the subject in the selected course
	        Subject selectedSubject = findSubjectByName(selectedCourse, subjectName);
	
	        if (selectedSubject != null) 
	        {
	            // Print subject details
	            System.out.println("\nDetalhes da disciplina para " + selectedSubject.getSubjectName() + ":\n");
	            System.out.println(selectedSubject.toString());
	        } 
	        
	        else 
	        {
	            System.out.println("\nEscolha Inválida!");
	        }
	    } 
	    
	    else 
	    {
	        System.out.println("\nEscolha Inválida!");
	    }
	}
	
	/**
     * Views the details of a class based on user selection from a specific course.
     */
	public static void viewClassDetails() 
	{
		// View Class Details
	    System.out.println("\nEscolha um curso para ver os detalhes da turma: ");
	    
	    displayCourseList(PredefinedCourses.courses);
	    int courseChoiceForClass = Read.anInt() - 1;
	    
	    if (courseChoiceForClass >= 0 && courseChoiceForClass < PredefinedCourses.courses.size()) 
	    {
	        Course selectedCourse = PredefinedCourses.courses.get(courseChoiceForClass);
	
	        System.out.println("\nEscolha a turma para ver os detalhes:");
	        
	        if(selectedCourse.getClasses().size() != 0) 
	        {
	        	displayClassList(selectedCourse.getClasses());
	            
	            int classChoice = Read.anInt() - 1;
	            
	            System.out.println();
	
	            if (classChoice >= 0 && classChoice < selectedCourse.getClasses().size()) 
	            {
	                System.out.println(selectedCourse.getClasses().get(classChoice).toString());
	            } 
	            
	            else 
	            {
	                System.out.println("\nEscolha Inválida!");
	            }
	        }
	        
	        else System.out.println("\nNão existem turmas inscritas neste curso!");
	    } 
	    
	    else 
	    {
	        System.out.println("\nEscolha Inválida!");
	    }
	    
	}
	
	/**
     * Views the grades of a student and calculates their average.
     */
	public static void viewStudentGrades() 
	{
        // Select a student
        System.out.println("\nEscreva o ID do aluno para ver as notas: \n");
        int studentID = Read.anInt();
        Student selectedStudent = findStudentById(studentID);

        if (selectedStudent != null) 
        {
            // Display grades for each subject
            ArrayList<StudentGrade> studentGrades = selectedStudent.getStudentGrades();
            
            System.out.println("\n========= Notas =========\n");
            
            for (StudentGrade grade : studentGrades) 
            {
                System.out.println("Disciplina: " + grade.getSubject().getSubjectName() +
                                   ", Nota: " + grade.getGradeValue());
                
                System.out.println("\n======= Sucedido ========");
                
                System.out.println();
            }
        } 
        
        else 
        {
            System.out.println("\nO aluno não foi encontrado!");
        }
        
    }

	private static Student findStudentById(int studentID) 
	 {
         for (Course course : PredefinedCourses.courses) 
         {
             for (SchoolClass schoolClass : course.getClasses()) 
             {
                 for (Student student : schoolClass.getStudents()) 
                 {
                     if (student.getStudentID() == studentID) 
                     {
                         return student;
                     }
                 }
             }
         }
         return null;
     }
	 
	/**
     * Deletes a teacher from the system based on their ID.
     */
	 private static Teacher findTeacherById(int teacherID) 
	 {
		 for (Subject subject : PredefinedSubjects.subjects) 
		 {
             for (Teacher teacher : subject.getTeachers()) 
             {
                 if (teacher.getTeacherID() == teacherID) 
                 {
                     return teacher;
                 }
             }
         }
		 
		 return null;
     }
	 
	/**
	 * Displays all students enrolled in the system.
	 */
	 private static Subject findSubjectByName(Course course, String subjectName) 
	 {
		for (Subject subject : course.getSubjects()) 
		{
			if (subject.getSubjectName().equalsIgnoreCase(subjectName)) 
			{
                return subject;
            }
        }
        return null;
	 }
	
	// METHODS FOR LISTING SOMETHING (COURSES, CLASSES AND SUBJECTS)
    
    private static double findStudentAverage(Student student) 
	{
	    if (student.getStudentGrades().isEmpty()) 
	    {
	        return 0.0;
	    }
	
	    double totalGrade = 0.0;
	    
	    int numberOfGrades = 0;
	
	    for (StudentGrade grade : student.getStudentGrades()) 
	    {
	        totalGrade += grade.getGradeValue();
	        
	        numberOfGrades++;
	    }
	
	    return totalGrade / numberOfGrades;
	}

	private static SchoolClass findBestClass(ArrayList<SchoolClass> classes) 
	{
	    SchoolClass bestClass = null;
	    
	    double bestAverage = 0.0;
	
	    for (SchoolClass schoolClass : classes) 
	    {
	        double classAverage = findClassAverage(schoolClass);
	
	        if (classAverage > bestAverage) 
	        {
	            bestAverage = classAverage;
	            bestClass = schoolClass;
	        }
	    }
	
	    return bestClass;
	}

	private static double findClassAverage(SchoolClass schoolClass) 
	{
	    if (schoolClass.getStudents().isEmpty()) 
	    {
	        return 0.0;
	    }
	
	    double totalGrades = 0.0;
	    
	    int numStudents = 0;
	
	    for (Student student : schoolClass.getStudents()) 
	    {
	        ArrayList<StudentGrade> grades = student.getStudentGrades();
	        
	        for (StudentGrade grade : grades) 
	        {
	            totalGrades += grade.getGradeValue();
	        }
	        
	        numStudents++;
	    }
	
	    return totalGrades / numStudents;
	}

	private static void displayCourseList(ArrayList<Course> courses) 
    {
        System.out.println("\nCursos Disponíveis:\n");
        
        for (int i = 1; i <= courses.size(); i++) 
        {
            System.out.println((i) + ".	" + courses.get(i - 1).getCourseName());
        }
        
        System.out.println();
    }
    
    private static void displayClassList(ArrayList<SchoolClass> list) 
    {
        System.out.println("\nTurmas Disponíveis:\n");
        
        for (int i = 1; i <= list.size(); i++) 
        {
            System.out.println((i) + ".	" + list.get(i - 1).getClassName());
        }
        
        System.out.println();
    }

    private static void displaySubjectList(ArrayList<Subject> subjects) 
    {
        for (int i = 1; i <= subjects.size(); i++) 
        {
            System.out.println((i) + ".	" + subjects.get(i - 1).getSubjectName());
        }
        
        System.out.println();
    }
    
    /**
     * Assigns a grade to a student for a specific subject.
     */
    public static void assignGrade() {
        // Select a student
        System.out.println("\nEscreva o ID do aluno que quer atribuir uma nota: \n");
        int studentID = Read.anInt();
        Student selectedStudent = findStudentById(studentID);

        if (selectedStudent == null) {
            System.out.println("\nEstudante não encontrado. Verifique o ID do estudante.");
            return;
        }

        // Display available subjects
        System.out.println("\nDisciplinas Disponíveis: \n");
        displaySubjectList(selectedStudent.getEnrolledClass().getClassSubjects());

        // Select a subject by name
        System.out.println("Escreva a opção da disciplina: \n");
        int subjectNumber = Read.anInt();

        if (subjectNumber < 1 || subjectNumber > selectedStudent.getEnrolledClass().getClassSubjects().size()) {
            System.out.println("\nOpção de disciplina inválida. Tente novamente.");
            return;
        }

        Subject selectedSubject = selectedStudent.getEnrolledClass().getClassSubjects().get(subjectNumber - 1);

        // Check if the student already has a grade for the selected subject
        if (hasGradeForSubject(selectedStudent, selectedSubject)) {
            System.out.println("\nO aluno já tem uma nota para esta disciplina.");
        } else {
            // Get a valid grade between 0 and 20
            double gradeValue = getValidGrade();

            // Create a new StudentGrade object and add it to the list
            StudentGrade newGrade = new StudentGrade(selectedSubject, gradeValue);
            selectedStudent.getStudentGrades().add(newGrade);

            System.out.println("\nNota adicionada!");
        }
    }
    
    /**
     * Calculates and displays the average grade of a student.
     */
    public static void printAndCalculateAverage() 
	{
	    System.out.println("\nEscreva o ID do aluno para calcular a média: ");
	    int studentID = Read.anInt();
	    
	    Student selectedStudent = findStudentById(studentID);
	
	    if (selectedStudent != null) 
	    {
	        if (selectedStudent.getStudentGrades().isEmpty()) 
	        {
	            System.out.println("\nO aluno não tem notas. Média: 0.0");
	            return;
	        }
	
	        double totalGrade = 0.0;
	        int numberOfGrades = 0;
	
	        for (StudentGrade grade : selectedStudent.getStudentGrades()) 
	        {
	            totalGrade += grade.getGradeValue();
	            numberOfGrades++;
	        }
	
	        double average = totalGrade / numberOfGrades;
	        System.out.println("\nMédia do aluno " + selectedStudent.getName() + ": " + average);
	    } else {
	        System.out.println("\nAluno não encontrado.");
	    }
	}

    /**
     * Deletes a student from the system based on their ID.
     */
    public static void deleteStudent() 
    {
        System.out.println("\nEscreva o ID do aluno que quer apagar:");
        
        int aluno = Read.anInt();
        
        Student astudent = findStudentById(aluno);
        
        if(astudent != null) 
        {
            astudent.getEnrolledClass().removeStudent(astudent);
            
            for(Course course : courses) 
            {
                for(SchoolClass schoolClass : course.getClasses()) 
                {
                    schoolClass.removeStudent(astudent);
                }
            }
            System.out.println("\nAluno removido com sucesso!");
        }
        
        else 
        {
            System.out.println("\nAluno não encontrado com o ID fornecido!");
        }
    }
    
    /**
     * Deletes a teacher from the system based on their ID.
     */
    public static void deleteTeacher() 
    {
        System.out.println("\nEscreva o ID do professor que quer apagar:");
        
        int teacher = Read.anInt();
        
        Teacher ateacher = findTeacherById(teacher);
        
        if(ateacher != null) 
        {
            ateacher.getSubjectTaught().removeTeacher(ateacher);
            System.out.println("\nProfessor removido!\n");
        } 
        
        else 
        {
            System.out.println("\nProfessor não encontrado com o ID fornecido!");
        }
    }
    
    /**
     * Displays all students enrolled in the system.
     */
    public static void showAllStudents() 
    {
        ArrayList<Student> students = getAllStudentsEnrolled();
        if(students.size() != 0) 
        {
            for(int i = 0; i < students.size(); i++) 
            {
                System.out.println(students.get(i).toString() + "\n");
            }
        }
        
        else 
        {
            System.out.println("\nNão foram criados alunos!");
        }
    }
    
    /**
     * Displays all teachers in the system.
     */
    public static void showAllTeachers() 
	{
	    ArrayList<Teacher> teachers = getAllTeacher();
	    
	    if(teachers.size() != 0) 
	    {
	        for(int i = 0; i < teachers.size(); i++) 
	        {
	            System.out.println(teachers.get(i).toString() + "\n");
	        }
	    } 
	    
	    else 
	    {
	        System.out.println("\nNão foram criados professores!");
	    }
	}

    /**
     * Displays all classes across all courses.
     */
	public static void showAllClasses() 
	{
	    ArrayList<SchoolClass> classes = getAllClasses();
	    if(classes.size() != 0) 
	    {
	        for(int i = 0; i < classes.size(); i++) 
	        {
	            System.out.println(classes.get(i).toString() + "\n");
	        }
	    } 
	    
	    else 
	    {
	        System.out.println("\nNão foram criadas turmas!");
	    }
	}
	
	/**
     * Displays the courses with the most students.
     */
	public static void showMostStudents() 
	{
	    ArrayList<Course> moreStudents = getMostStudents();

	    if (!moreStudents.isEmpty()) 
	    {
	        System.out.println("\nCursos com mais alunos:\n");
	        
	        for(Course course : moreStudents)
	        {
	            System.out.println("" + course.getCourseName());
	        }
	        
	        int numStudents = 0;
	        
	        for (SchoolClass schoolClass : moreStudents.get(0).getClasses()) 
	        {
	            numStudents = schoolClass.getStudents().size();
	        }

	        System.out.println("\nNúmero total de alunos: " + numStudents);
	    }
	    
	    else 
	    {
	        System.out.println("\nNão foram criados cursos!");
	    }
	}
	
	/**
     * Displays the class with the best average grade in a specific course.
     */
	public static void showBestAverageClass() 
	{
	    System.out.println("\nEscolha o curso:");
	
	    // Display available courses with numbers
	    displayCourseList(PredefinedCourses.courses);
	
	    // Prompt user to choose a course by entering the number
	    int courseNumber = Read.anInt();
	
	    // Validate the course number
	    if (courseNumber >= 1 && courseNumber <= PredefinedCourses.courses.size()) 
	    {
	        Course selectedCourse = PredefinedCourses.courses.get(courseNumber - 1);
	
	        // Find the best class for the selected course
	        SchoolClass bestClass = findBestClass(selectedCourse.getClasses());
	
	        if (bestClass != null) 
	        {
	            System.out.println("\nA turma com a melhor média para o curso " + selectedCourse.getCourseName() +
	                    " é: " + bestClass.getClassName());
	        } 
	        
	        else 
	        {
	            System.out.println("\nNão há turmas inscritas no curso " + selectedCourse.getCourseName() + "\n");
	        }
	    } 
	    
	    else 
	    {
	        System.out.println("\nOpção de curso inválida. Tente novamente.");
	    }
	}
	
	/**
     * Displays the student with the best average grade across all courses and classes.
     */
	public static void showStudentWithBestAverage() 
	{
	
		if (PredefinedCourses.courses.isEmpty()) 
		{
	        System.out.println("\nNenhum curso pré-definido. Não é possível calcular a média!");
	        return;
	    }
	
	    double highestAverage = 0.0;
	    Student studentWithBestAverage = null;
	
	    for (Course course : PredefinedCourses.courses) 
	    {
	        for (SchoolClass schoolClass : course.getClasses()) 
	        {
	            for (Student student : schoolClass.getStudents()) 
	            {
	                double studentAverage = findStudentAverage(student);
	                
	                if (studentAverage > highestAverage) 
	                {
	                    highestAverage = studentAverage;
	                    
	                    studentWithBestAverage = student;
	                }
	            }
	        }
	    }
	
	    if (studentWithBestAverage != null) 
	    {
	        System.out.println("\nAluno com a melhor média: " + studentWithBestAverage.getName());
	        
	        System.out.println("\nMédia: " + highestAverage);
	    } else {
	        System.out.println("Nenhum aluno encontrado.");
	    }
	}

	//METHODS TO GET ALL THE STUDENTS AND THE TEACHERS AND THE CLASSES
	
	/**
     * Checks if a student already has a grade for a specified subject.
     *
     * @param student The student to check.
     * @param subject The subject to check for a grade.
     * @return true if the student already has a grade for the subject, false otherwise.
     */
	private static boolean hasGradeForSubject(Student student, Subject subject) 
	{
	    for (StudentGrade grade : student.getStudentGrades()) 
	    {
	        if (grade.getSubject().equals(subject)) 
	        {
	            return true;
	        }
	    }
	    return false;
	}

	 /**
     * Retrieves all students enrolled in all courses and classes.
     *
     * @return An ArrayList of all enrolled students.
     */
	private static ArrayList<Student> getAllStudentsEnrolled() 
	{
	    ArrayList<Student> allStudents = new ArrayList<>();
	    
	    for(Course course : PredefinedCourses.courses) 
	    {
	        for (SchoolClass schoolClass : course.getClasses()) 
	        {
	            allStudents.addAll(schoolClass.getStudents());
	        }
	    }
	    
	    return allStudents;
	}
	
	/**
     * Retrieves the courses with the most students enrolled.
     *
     * @return An ArrayList of courses with the most students.
     */
	private static ArrayList<Course> getMostStudents() 
	{ 
		ArrayList<Course> moreStudents = new ArrayList<>();
        
		int maxStudents = 0;
        
		for (Course course : PredefinedCourses.courses) 
		{
            int numStudents = 0;
                
            for(SchoolClass schoolClass : course.getClasses()) 
            {
            	numStudents = numStudents + schoolClass.getStudents().size();
            }	
            
            if (numStudents > maxStudents) 
            {
                maxStudents = numStudents;
                
                moreStudents.clear();
                
                moreStudents.add(course);
            } 
            
            else if (numStudents == maxStudents) 
            {
                moreStudents.add(course);
            }
        }
        
        return moreStudents;
	}
	
	/**
     * Retrieves all teachers across all subjects.
     *
     * @return An ArrayList of all teachers.
     */
	private static ArrayList<Teacher> getAllTeacher() 
    {
        ArrayList<Teacher> allTeachers = new ArrayList<>();
        
        for(Subject subject : PredefinedSubjects.subjects) 
        {
            allTeachers.addAll(subject.getTeachers());
        }
        
        return allTeachers;
    }
    
	 /**
     * Retrieves a valid grade input from the user within the range 0 to 20.
     *
     * @return The valid grade inputted by the user.
     */
	private static double getValidGrade() 
	{
	
	    double gradeValue;
	
	    do 
	    {
	        System.out.println("\nEscreva a nota entre 0 e 20: \n");
	        gradeValue = Read.aDouble();
	
	        if (gradeValue < 0 || gradeValue > 20) 
	        {
	            System.out.println("\nNota inválida. Tente novamente.");
	        }
	    } 
	    
	    while (gradeValue < 0 || gradeValue > 20);
	
	    return gradeValue;
	}
	
	/**
     * Retrieves all classes across all courses.
     *
     * @return An ArrayList of all classes.
     */
	private static ArrayList<SchoolClass> getAllClasses() 
    {
        ArrayList<SchoolClass> allclasses = new ArrayList<>();
        
        for(Course course : PredefinedCourses.courses) 
        {
                allclasses.addAll(course.getClasses());
        }
        
        return allclasses;
    }
}