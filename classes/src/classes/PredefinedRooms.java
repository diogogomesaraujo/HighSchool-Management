package classes;

public interface PredefinedRooms
{
    public static final Room r01 = new Room("0.1", "Ginásio", 30, TimeCell.buildEmptyTimetable());
    public static final Room r02 = new Room("0.2", "Pavilhão", 60, TimeCell.buildEmptyTimetable());

    public static final Room r11 = new Room("1.1", "Sala de Aula", 30, TimeCell.buildEmptyTimetable());
    public static final Room r12 = new Room("1.2", "Sala de Aula", 30, TimeCell.buildEmptyTimetable());
    public static final Room r13 = new Room("1.3", "Sala de Aula", 30, TimeCell.buildEmptyTimetable());
    public static final Room r14 = new Room("1.4", "Sala de Aula", 30, TimeCell.buildEmptyTimetable());
    public static final Room r15 = new Room("1.5", "Laboratório", 15, TimeCell.buildEmptyTimetable());
    public static final Room r16 = new Room("1.4", "Sala de Desenho", 30, TimeCell.buildEmptyTimetable());

}
