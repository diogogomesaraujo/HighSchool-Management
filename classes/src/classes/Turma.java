package classes;
import java.util.*;

public class Turma 
{
	private int anoLetivo;
	private char letra;
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	
	public Turma() 
	{
		this.anoLetivo = 0;
		this.letra = 'A';
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
	}
	
	public Turma(int anoLetivo, char letra, ArrayList<Aluno> alunos, ArrayList<Professor> professores) 
	{
		this.anoLetivo = anoLetivo;
		this.letra = letra;
		this.alunos = alunos;
		this.professores = professores;
	}
	
	public int getAnoLetivo() 
	{
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) 
    {
        this.anoLetivo = anoLetivo;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) 
    {
        this.letra = letra;
    }

    public ArrayList<Aluno> getAlunos() 
    {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) 
    {
        this.alunos = alunos;
    }

    public ArrayList<Professor> getProfessores() 
    {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) 
    {
        this.professores = professores;
    }
}
