package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;//запоминаем настоящий PrintStream в специальную переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//Создаем динамический массив
        PrintStream stream = new PrintStream(outputStream);//создаем адаптер к классу PrintStream
        System.setOut(stream);//Устанавливаем его как текущий System.out
        testString.printSomething();//Вызываем функцию, которая ничего не знает о наших манипуляциях
        String result = outputStream.toString();//Преобразовываем записанные в наш ByteArray данные в строку
        System.setOut(consoleStream); //Возвращаем все как было

        int count = 0;
        for (String element : result.split("[\\n]+")){
            System.out.println(element);
            if (count++==1){
                System.out.println("JavaRush - курсы Java онлайн");
                count=0;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
