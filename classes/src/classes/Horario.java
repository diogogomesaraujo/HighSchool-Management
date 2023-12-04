package classes;
import java.util.*;

public class Horario 
{
	private ArrayList<Disciplina> disciplinas;
	private Hora hora;
	
	public Horario() 
	{
		this.disciplinas = new ArrayList<Disciplina>();
		this.hora = new Hora();
	}
	
	public Horario(Hora hora, ArrayList<Disciplina> disciplinas) 
	{
		this.disciplinas = disciplinas;
		this.hora = hora;
	}
	
	public Hora getHora() 
	{
        return hora;
    }

    public void setHora(Hora hora) 
    {
        this.hora = hora;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) 
    {
        this.disciplinas = disciplinas;
    }
}
