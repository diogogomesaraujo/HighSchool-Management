package classes;

public class Hora 
{
	private int horas;
	private int minutos;
	
	public Hora() 
	{
		this.horas = 0;
		this.minutos = 0;
	}
	
	public Hora(int horas, int minutos) 
	{
		this.horas = horas;
		this.minutos = minutos;
	}
	
	public int getHoras() 
	{
		return horas;
	}
	
	public void setHoras(int horas) 
	{
		this.horas = horas;
	}
	
	public int getMinutos() 
	{
		return minutos;
	}
	
	public void setMinutos(int minutos) 
	{
		this.minutos = minutos;
	}
}
