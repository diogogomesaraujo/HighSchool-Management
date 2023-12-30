package form;

import java.io.*;
import java.util.ArrayList;
import classes.*;

public class CourseDataUtil 
{

    public static void serializeCourses(String filename) 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            oos.writeObject(PredefinedCourses.courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void deserializeCourses(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            ArrayList<Course> newCourses = (ArrayList<Course>) ois.readObject();
            updatePredefinedCoursesList(newCourses);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void updatePredefinedCoursesList(ArrayList<Course> newCourses) 
    {
        ArrayList<Course> existingCourses = PredefinedCourses.courses;
        existingCourses.clear();
        existingCourses.addAll(newCourses);
    }
}


