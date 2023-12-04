package classes;

public class DataNascimento 
{
	private int ano;
	private int mes;
	private int dia;
	
	public DataNascimento() 
	{
		this.ano = 2000;
		this.mes = 1;
		this.dia = 1;
	}
	
	public DataNascimento(int ano, int mes, int dia) 
	{
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}
	
    public int getAno() 
    {
        return ano;
    }

    public void setAno(int ano) 
    {
        this.ano = ano;
    }

    public int getMes() 
    {
        return mes;
    }

    public void setMes(int mes) 
    {
        this.mes = mes;
    }

    public int getDia() 
    {
        return dia;
    }

    public void setDia(int dia) 
    {
        this.dia = dia;
    }
}
