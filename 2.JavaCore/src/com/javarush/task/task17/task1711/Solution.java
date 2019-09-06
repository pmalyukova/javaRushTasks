package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void addPerson(String name, String sex, Date date) {
        if ((sex.equals("м"))) allPeople.add(Person.createMale(name, date));
        else if ((sex.equals("ж"))) allPeople.add(Person.createFemale(name, date));
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length == 0) System.exit(0);
        SimpleDateFormat formatBD = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; ) {
                        addPerson(args[++i], args[++i], formatBD.parse(args[++i]));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; ) {
                        int id = Integer.parseInt(args[++i]);
                        allPeople.get(id).setName(args[++i]);
                        allPeople.get(id).setSex(args[++i].equals("м") ? Sex.MALE : Sex.FEMALE);
                        allPeople.get(id).setBirthDate(formatBD.parse(args[++i]));
                    }
                }
                break;
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setBirthDate(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setName(null);
                    }
                }
                break;
            }
            case "-i": {
                SimpleDateFormat d = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; ) {
                        Person p = allPeople.get(Integer.parseInt(args[++i]));
                        if (p.getBirthDate() != null)
                            System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м" : "ж") + " " + d.format(p.getBirthDate()));
                    }
                }
                break;
            }
        }
    }
}