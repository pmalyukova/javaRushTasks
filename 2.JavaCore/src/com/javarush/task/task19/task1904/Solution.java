package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if (fileScanner.hasNext()){  //пока есть элементы в файле
                String s = fileScanner.nextLine(); //получаем следующий элемент
                String[] parts = s.split(" ");//разбиваем по пробелам и записываем в элемент массива

                Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[5]), Integer.parseInt(parts[4])-1,
                    Integer.parseInt(parts[3]));
                person = new Person(parts[1],parts[2],parts[0],calendar.getTime());
            }

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
