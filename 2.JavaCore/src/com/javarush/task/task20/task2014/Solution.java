package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("20-07-04.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution savedObject = new Solution(18);
        try {
            assert oos != null;
            oos.writeObject(savedObject);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("20-07-04.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution loadedObject = null;
        try {
            loadedObject = (Solution) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(savedObject.toString());
        System.out.println(loadedObject.toString());
        System.out.println(savedObject.string.equals(loadedObject.string));

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
