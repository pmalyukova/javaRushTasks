package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        FileReader fileReader = new FileReader(new File("C:\\Users\\PolinaMalyukova\\Desktop\\1.txt"));
//        BufferedReader reader = new BufferedReader(fileReader);

            StringBuilder name;
            int year, month, day;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rec = line.split(" ");
                year = Integer.parseInt(rec[rec.length - 1]);
                month = Integer.parseInt(rec[rec.length - 2]) - 1;
                day = Integer.parseInt(rec[rec.length - 3]);
                name = new StringBuilder();
                for (int i = 0; i < rec.length - 3; i++) {
                    name.append(rec[i]).append(" ");
                }
                name.replace(name.length() - 1, name.length(), ""); //убрали пробел в конце строки

                PEOPLE.add(new Person(name.toString(), new GregorianCalendar(year, month, day).getTime()));

            }
            reader.close();
        }
    }