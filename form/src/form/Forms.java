package form;

import classes.*;
import myInputs.Read;

import java.time.LocalTime;
import java.util.ArrayList;

public class Forms 
{
	public static void createStudentForm() 
	{
		Student student = new Student();
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		questions.add(new Question("Escreva o nome do aluno: ", "Name", "String"));
		questions.add(new Question("Escreva o género do aluno: ", "Gender", "Gender"));
		questions.add(new Question("Escreva a morada do aluno: ", "Address", "String"));
		questions.add(new Question("Escreva a data de nascimento do aluno: ", "Birthday", "LocalDateTime"));
		questions.add(new Question("Escreva o curso do aluno: ", "EnrolledCourse", "Course"));
		questions.add(new Question("Escreva a disciplina opcional do aluno: ", "OptionalSubject", "OptionalSubject"));
		
		Form studentForm = new Form("Criar Aluno", questions, student);
		
		studentForm.build();
		
		System.out.println(student.getName());
		System.out.println(student.getAddress());
		System.out.println(student.getGender());
		System.out.println(student.getStudentID());
		System.out.println(student.getBirthday());
		System.out.println(student.getEnrolledCourse());
		System.out.println(student.getOptionalSubject());
		
		student.getEnrolledCourse().enrollClass(student);
		
		System.out.println(student.getEnrolledCourse().getClasses().toString());
	}
	
	public static void createTeacherForm(SchoolClass schoolClass, SchoolClass schoolClass1) 
	{
		Teacher teacher = new Teacher();
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		questions.add(new Question("Escreva o nome do professor: ", "Name", "String"));
		questions.add(new Question("Escreva o género do professor: ", "Gender", "Gender"));
		questions.add(new Question("Escreva a morada do professor: ", "Address", "String"));
		questions.add(new Question("Escreva a data de nascimento do professor: ", "Birthday", "LocalDateTime"));
		questions.add(new Question("Escreva a disciplina do professor: ", "SubjectTaught", "Subject"));
		
		Form teacherForm = new Form("Criar Professor", questions, teacher);
		
		teacherForm.build();
		
		teacher.getSubjectTaught().addTeacher(teacher);
		
		schoolClass.addTeacher(teacher);
		schoolClass1.addTeacher(teacher);
	}
	
	public static void createTimetable(SchoolClass schoolClass) 
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
			
			if(aux.equals("s") || aux.equals("S")) 
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
					
					availableSubjects.remove(auxSubject);
				}
				
				else System.out.println("Não há professores disponíveis a essa hora!\n");
			}
			
			System.out.println();
		}
		
		 System.out.println("\n======= Sucedido ========");
	}
	
	public static void main(String[]args) 
	{
		SchoolClass schoolClass1 = new SchoolClass("10-A", PredefinedCourses.sciencesSubjects);
		SchoolClass schoolClass2 = new SchoolClass("10-A", PredefinedCourses.sciencesSubjects);
		
		createTeacherForm(schoolClass1, schoolClass2);
		createTimetable(schoolClass1);
		
		TimeCell.writeTimetable(schoolClass1.getTimetable());

		createTimetable(schoolClass2);
		
		TimeCell.writeTimetable(schoolClass2.getTimetable());
		
		//createStudentForm();
	}
	
	
}
