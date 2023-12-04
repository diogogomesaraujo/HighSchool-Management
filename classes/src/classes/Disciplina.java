package classes;
import java.util.*;

public class Disciplina 
{
	private int codigo;
	private String nome;
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	
	public Disciplina() 
	{
		this.codigo = 0;
		this.nome = "";
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
	}
	
	public Disciplina(String nome, int codigo, ArrayList<Aluno> alunos, ArrayList<Professor> professores) 
	{
		this.nome = nome;
		this.codigo = codigo;
		this.alunos = alunos;
		this.professores = professores;
	}
	
	 public int getCodigo() 
	 	{
	        return codigo;
	    }

	    public void setCodigo(int codigo) 
	    {
	        this.codigo = codigo;
	    }

	    public String getNome() 
	    {
	        return nome;
	    }

	    public void setNome(String nome) 
	    {
	        this.nome = nome;
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
