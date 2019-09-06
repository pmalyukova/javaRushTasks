package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH );
            Person person;
            if (args[0].equals("-c")){
                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], dateFormat.parse(args[3]));
                }
                else {person = Person.createFemale(args[1], dateFormat.parse(args[3]));
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
            else if (args[0].equals("-u")){
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if (args[3].equals("м")){
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                }
                else allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(dateFormat.parse(args[4]));
            }
            else if (args[0].equals("-d")){
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            }
            else if (args[0].equals("-i")){
                dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                        (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                        dateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


