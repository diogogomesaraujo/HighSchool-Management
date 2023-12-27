package form;

import classes.*;
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
		
		student.getEnrolledCourse().enrollClass(student);
	}
	
	public static void createTeacherForm() 
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
	}
	
	public static void createTimetable(SchoolClass schoolClass) 
	{
		
	}
	
	public static void main(String[]args) 
	{
		createStudentForm();
	}
	
	
}
