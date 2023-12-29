package form;

import classes.*;
import myInputs.Read;

import java.time.LocalTime;
import java.util.ArrayList;

public class Forms 
{
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
        
        displayCourseList(PredefinedCourses.courses);
        int courseChoiceForClass = Read.anInt();
        
        if (courseChoiceForClass >= 0 && courseChoiceForClass < PredefinedCourses.courses.size()) 
        {
            Course selectedCourse = PredefinedCourses.courses.get(courseChoiceForClass);

            System.out.println("\nEscolha a turma para fazer o horário:");
            
            if(selectedCourse.getClasses().size() != 0) 
            {
            	displayClassList(selectedCourse.getClasses());
                
                int classChoice = Read.anInt();

                if (classChoice >= 0 && classChoice < selectedCourse.getClasses().size()) 
                {
                    createTimetable(selectedCourse.getClasses().get(classChoice));
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
	
	// METHODS TO EDIT DIFFERENT OBJECTS
	
	public static void editStudentDetails(String parameterName) 
	{
		System.out.println("\nEscreva o ID do aluno:\n");
		int studentIdToEdit = Read.anInt();
	     
	    Student studentToEdit = findStudentById(studentIdToEdit);
	     
	    if (studentToEdit != null) 
	    {
	        if(parameterName.equals("Name"))
	        {
	        	System.out.println("\nEscreva o novo nome do aluno: \n");
	        	studentToEdit.setName(Read.aString());
	        }
	        
	        if(parameterName.equals("Gender")) 
	        {
	        	System.out.println("\nEscreva o novo género do aluno: \n");
	        	studentToEdit.setGender(Read.aGender());
	        }
	        
	        if(parameterName.equals("Birthday")) 
	        {
	        	System.out.println("\nEscreva a nova data de nascimento do aluno: \n");
	        	studentToEdit.setBirthday(Read.aLocalDate());
	        }
	        
	        if(parameterName.equals("Address")) 
	        {
	        	System.out.println("\nEscreva a nova morada do aluno: \n");
	        	studentToEdit.setGender(Read.aString());
	        }
	        
	        if(parameterName.equals("EnrolledCourse and SchoolClass")) 
	        {
	        	studentToEdit.getEnrolledClass().removeStudent(studentToEdit);;
	        	
	        	System.out.println("\nEscreva o novo curso do aluno: \n");
	        	studentToEdit.setEnrolledCourse(Course.aCourse());
	        	
	        	System.out.println("\nEscreva a disciplina opcional do aluno: \n");
	        	studentToEdit.setOptionalSubject(Course.aOptionalSubject(studentToEdit.getEnrolledCourse()));
	        	
	        	studentToEdit.getEnrolledCourse().enrollClass(studentToEdit);
	        }
	    } 
	     
	    else 
	    {
	        System.out.println("\nAluno não foi encontrado!");
	    }
	}
	
	public static void viewTimetableDetails() 
	{
		System.out.println("\nEscolha um curso da turma para fazer o horário: ");
        
        displayCourseList(PredefinedCourses.courses);
        int courseChoiceForClass = Read.anInt();
        
        if (courseChoiceForClass >= 0 && courseChoiceForClass < PredefinedCourses.courses.size()) 
        {
            Course selectedCourse = PredefinedCourses.courses.get(courseChoiceForClass);

            System.out.println("\nEscolha a turma para fazer o horário:");
            
            if(selectedCourse.getClasses().size() != 0) 
            {
            	displayClassList(selectedCourse.getClasses());
                
                int classChoice = Read.anInt();

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
	    
	    displayCourseList(PredefinedCourses.courses);
	    
	    System.out.print("\nEscreva o número da opção ");
	    int courseChoice2 = Read.anInt();
	    
	    if (courseChoice2 >= 0 && courseChoice2 < PredefinedCourses.courses.size()) 
	    {
	    	System.out.println("\nDetalhes da disciplina para " + PredefinedCourses.courses.get(courseChoice2).getCourseName() + ":\n");
	    	
	    	System.out.println(PredefinedCourses.courses.get(courseChoice2).toString());
	    } 
	    
	    else 
	    {
	        System.out.println("Escolha Inválida!");
	    }
	    
	}

	public static void viewSubjectDetails() 
	{
	
	    // Choose a course
	    System.out.println("\nEscolha o curso para ver os detalhes da disciplina:\n");
	    
	    displayCourseList(PredefinedCourses.courses);
	    
	    System.out.print("Escreva o número da opção ");
	    int courseChoice = Read.anInt();
	
	    if (courseChoice >= 0 && courseChoice < PredefinedCourses.courses.size()) {
	        Course selectedCourse = PredefinedCourses.courses.get(courseChoice);
	
	        // Display the list of subjects in the chosen course
	        System.out.println("\nDisciplinas em " + selectedCourse.getCourseName() + ":");
	        displaySubjectList(selectedCourse.getSubjects());
	
	        // Enter the subject number
	        System.out.print("\nEscreva o número da opção ");
	        int subjectChoice = Read.anInt();
	        
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
	    int courseChoiceForClass = Read.anInt();
	    
	    if (courseChoiceForClass >= 0 && courseChoiceForClass < PredefinedCourses.courses.size()) 
	    {
	        Course selectedCourse = PredefinedCourses.courses.get(courseChoiceForClass);
	
	        System.out.println("\nEscolha a turma para ver os detalhes:");
	        
	        if(selectedCourse.getClasses().size() != 0) 
	        {
	        	displayClassList(selectedCourse.getClasses());
	            
	            int classChoice = Read.anInt();
	
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
        
        for (int i = 0; i < courses.size(); i++) 
        {
            System.out.println((i) + ".	" + courses.get(i).getCourseName());
        }
        
        System.out.println();
    }
    
    private static void displayClassList(ArrayList<SchoolClass> list) 
    {
        System.out.println("\nTurmas Disponíveis:\n");
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.println((i) + ".	" + list.get(i).getClassName());
        }
        
        System.out.println();
    }

    private static void displaySubjectList(ArrayList<Subject> subjects) 
    {
        for (int i = 0; i < subjects.size(); i++) 
        {
            System.out.println((i) + ".	" + subjects.get(i).getSubjectName());
        }
        
        System.out.println();
    }
}
