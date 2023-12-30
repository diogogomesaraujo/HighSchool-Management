package form;

import classes.*;
import myInputs.Read;

import java.time.LocalTime;
import java.util.ArrayList;
import java.io.*;

public class Forms 
{
	public static ArrayList <Course> courses = PredefinedCourses.courses;
	
	public static void writeInFile() {
        try{
            FileOutputStream ficheiro = new FileOutputStream("Courses");
            ObjectOutputStream out = new ObjectOutputStream(ficheiro);
            out.writeObject(PredefinedCourses.courses);
            out.close();
            ficheiro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("unchecked")
	public static void readFile() {
	    try {
	    	File file = new File("Courses");
            if(!file.exists()) {
                file.createNewFile();
            }
	    	
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            courses = (ArrayList<Course>) ois.readObject();    
	            ois.close();
	            fis.close();
	            
	            updatePredefinedCourses(courses);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	public static void updatePredefinedCourses(ArrayList<Course> deserializedCourses) {
	    for (Course course : deserializedCourses) {
	        switch (course.getCourseName()) {
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

	private static void updatePredefinedClasses(Course predefinedCourse, Course deserializedCourse) {
	    predefinedCourse.setClasses(deserializedCourse.getClasses());
	}
            
    
    //METHODS TO CREATE DIFFERENT OBJECTS
	
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
		
		System.out.println("O ID do Aluno é: " + student.getStudentID() + "\n");
	}
	
	public static void createTeacherForm() 
	{
		Teacher teacher = new Teacher();
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		questions.add(new Question("Escreva o nome do professor: ", "Name", "String"));
		questions.add(new Question("Escreva o género do professor: ", "Gender", "Gender"));
		questions.add(new Question("Escreva a morada do professor: ", "Address", "String"));
		questions.add(new Question("Escreva a data de nascimento do professor: ", "Birthday", "LocalDate"));
		questions.add(new Question("Escreva a disciplina do professor: ", "SubjectTaught", "Subject"));
		
		Form teacherForm = new Form("Criar Professor", questions, teacher);
		
		teacherForm.build();
		
		teacher.getSubjectTaught().addTeacher(teacher);
		
		System.out.println("O ID do Professor é: " + teacher.getTeacherID() + "\n");
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
				System.out.println(schoolClass.getTimetable().get(i).timePeriodText() + "Escreva o nome da disciplina: ");
				
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
				
				else System.out.println("Não há professores disponíveis a essa hora!\n");
			}
		}
		
		 System.out.println("\n======= Sucedido ========");
	}
	
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

	
	// METHODS TO EDIT DIFFERENT OBJECTS
	
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
	
	//VIEW THE DIFFERENT OBJECTs
	
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
                    TimeCell.writeTimetable(selectedCourse.getClasses().get(classChoice).getTimetable());;
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
	
	//Find Functions:
	
	 public static void viewStudentDetails() 
	 {
	 	 // View Student Details
		 System.out.println("\nEscreva o ID do aluno:\n");
	     int studentIdToView = Read.anInt();
	     
	     Student studentToView = findStudentById(studentIdToView);
	     
	     if (studentToView != null) 
	     {
	         System.out.println(studentToView.toString());
	     } 
	     
	     else 
	     {
	         System.out.println("\nAluno não foi encontrado!");
	     }
	     
	 }

	public static void viewTeacherDetails() 
	 {
		 System.out.print("\nEscreva o ID do professor para ver os detalhes: \n");
		 
	     int teacherIdToView = Read.anInt();
	     
	     Teacher teacherToView = findTeacherById(teacherIdToView);
	     
	     if (teacherToView != null) 
	     {
	         System.out.println("\nDetalhes do Professor:");
	         System.out.println(teacherToView.toString());
	     } 
	     
	     else 
	     {
	         System.out.println("\nProfessor não foi encontrado!");
	     }
	 	
	 }

	public static void viewCourseDetails() 
	{
		// View Course Details
		
	    System.out.println("\nEscolha o curso para ver os detalhes:\n");
	    
	    Course selectedCourse = Course.aCourse();
	    
	    System.out.println("\nDetalhes do Curso: ");
	    System.out.println(selectedCourse.toString());
	    
	}

	public static void viewSubjectDetails() 
	{
	
	    // Choose a course
	    System.out.println("\nEscolha o curso para ver os detalhes da disciplina:\n");
	    
	    displayCourseList(PredefinedCourses.courses);
	    
	    System.out.print("Escreva o número da opção ");
	    int courseChoice = Read.anInt() - 1;
	
	    if (courseChoice >= 0 && courseChoice < PredefinedCourses.courses.size()) 
	    {
	        Course selectedCourse = PredefinedCourses.courses.get(courseChoice);
	
	        // Display the list of subjects in the chosen course
	        System.out.println("\nDisciplinas em " + selectedCourse.getCourseName() + ":");
	        displaySubjectList(selectedCourse.getSubjects());
	
	        // Enter the subject number
	        System.out.print("\nEscreva o número da opção ");
	        int subjectChoice = Read.anInt() - 1;
	        
	        String subjectName = selectedCourse.getSubjects().get(subjectChoice).getSubjectName();
	
	        // Find the subject in the selected course
	        Subject selectedSubject = findSubjectByName(selectedCourse, subjectName);
	
	        if (selectedSubject != null) 
	        {
	            // Print subject details
	            System.out.println("\nDetalhes da disciplina para " + selectedSubject.getSubjectName() + ":");
	            System.out.println(selectedSubject.toString());
	        } 
	        
	        else 
	        {
	            System.out.println("Escolha Inválida!");
	        }
	    } 
	    
	    else 
	    {
	        System.out.println("Escolha Inválida!");
	    }
	}

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
            System.out.println("O aluno não foi encontrado!");
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
    
    public static void assignGrade() 
    {
        // Select a student
        System.out.println("\nEscreva o ID do aluno que quer atribuir uma nota: \n");
        int studentID = Read.anInt();
        Student selectedStudent = findStudentById(studentID);

        // Display available subjects
        System.out.println("\nDisciplinas Disponíveis: \n");
        displaySubjectList(selectedStudent.getEnrolledCourse().getSubjects());

        // Select a subject by name
        System.out.println("Escreva a opção da disciplina: \n");
        int subjectNumber = Read.anInt();
        Subject selectedSubject = selectedStudent.getEnrolledCourse().getSubjects().get(subjectNumber - 1);
        
        System.out.println("\nEscreva a nota para o aluno " + selectedStudent.getName() +
                " a " + selectedSubject.getSubjectName() + ": \n");
        double gradeValue = Read.aDouble();

        // Create a new StudentGrade object and add it to the list
        StudentGrade newGrade = new StudentGrade(selectedSubject, gradeValue);
        selectedStudent.getStudentGrades().add(newGrade);

        System.out.println("\nNota adicionada!");
    }
}
