package classes;
import java.util.*;

public class Aluno 
{
	private String nome;
	private int numero;
	private String genero;
	private DataNascimento dataNascimento;
	private String morada;
	private ArrayList<Disciplina> disciplinas;
	
	public Aluno() 
	{
		this.nome = "";
		this.numero = 0;
		this.genero = "";
		this.morada = "";
		this.disciplinas = new ArrayList<Disciplina>();
		this.dataNascimento = new DataNascimento();
	}
	
	public Aluno(String nome, int numero, String genero, String morada, ArrayList<Disciplina> disciplinas, DataNascimento dataNascimento) 
	{
		this.nome = nome;
		this.numero = numero;
		this.genero = genero;
		this.morada = morada;
		this.disciplinas = disciplinas;
		this.dataNascimento = dataNascimento;
	}
	
	public ArrayList<Disciplina> getDisciplinas()
	{
		return disciplinas;
	}
	
	public void setDisciplinas(ArrayList<Disciplina> disciplinas) 
	{
		this.disciplinas = disciplinas;
	}
	
	public String getNome() 
	{
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public String getMorada() 
    {
        return morada;
    }

    public void setMorada(String morada) 
    {
        this.morada = morada;
    }
	
    public DataNascimento getDataNascimento() 
    {
        return dataNascimento;
    }

    public void setDataNascimento(DataNascimento dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }
}
