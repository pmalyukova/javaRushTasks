package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out; //помещаем настроящий PrintStream в переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //создаем динамический массив
        PrintStream stream = new PrintStream(outputStream);//создаем адаптер к классу PrintStream
        System.setOut(stream); //подменяем им настоящий System.out

        testString.printSomething();
        String result = outputStream.toString();
        Pattern pattern = Pattern.compile("[t]+[e]");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()){
            result = matcher.replaceAll("??");
        }
        System.setOut(consoleStream);//Возвращаем System.out как было
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
