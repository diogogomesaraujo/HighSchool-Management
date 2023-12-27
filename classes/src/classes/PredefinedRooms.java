package classes;

import java.util.*;

public class PredefinedRooms 
{
	public static final Room r01 = new Room("0.1", "Ginásio");
	public static final Room r02 = new Room("0.2", "Ginásio");
	
	public static final Room r11 = new Room("1.1", "Sala de Aula");
	public static final Room r12 = new Room("1.2", "Sala de Aula");
	public static final Room r13 = new Room("1.3", "Sala de Aula");
	public static final Room r14 = new Room("1.4", "Sala de Aula");
	public static final Room r15 = new Room("1.5", "Sala de Aula");
	public static final Room r16 = new Room("1.6", "Sala de Desenho");
	public static final Room r17 = new Room("1.7", "Laboratório");
	
	public static final Room r21 = new Room("2.1", "Sala de Aula");
	public static final Room r22 = new Room("2.2", "Sala de Aula");
	public static final Room r23 = new Room("2.3", "Sala de Aula");
	public static final Room r24 = new Room("2.4", "Sala de Aula");
	public static final Room r25 = new Room("2.5", "Sala de Aula");
	public static final Room r26 = new Room("2.6", "Sala de Desenho");
	public static final Room r27 = new Room("2.7", "Laboratório");
	
	public static final ArrayList<Room> rooms = new ArrayList<Room>(Arrays.asList(r01, r02, r11, r12, r13, r14, r15, r16, r17, r21, r22, r23, r24, r25, r26, r27));
}
