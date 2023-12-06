package classes;

public class Timetable implements Vector2 
{
    private Object[][] schedule;

    public Timetable(int rows, int columns) 
    {
        schedule = new Object[rows][columns];
    }

    @Override
    public Object getValue(int row, int column) 
    {
        return schedule[row][column];
    }

    @Override
    public void setValue(int row, int column, Object value) 
    {
        schedule[row][column] = value;
    }
}