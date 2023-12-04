package classes;

public class Professor 
{
	private String nome;
	private String genero;
	private DataNascimento dataNascimento;
	private Disciplina disciplina;
	
	public Professor() 
	{
		this.nome = "";
		this.genero = "";
		this.dataNascimento = new DataNascimento();
		this.disciplina =  new Disciplina();
	}
	
	public Professor(String nome, String genero, DataNascimento dataNascimento, Disciplina disciplina) 
	{
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.disciplina = disciplina;
	}
	
	public String getNome() 
	{
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public DataNascimento getDataNascimento() 
    {
        return dataNascimento;
    }

    public void setDataNascimento(DataNascimento dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) 
    {
        this.disciplina = disciplina;
    }
}
