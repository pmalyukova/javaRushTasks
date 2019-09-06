package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleStream);

        String[] value = outputStream.toString().split(" ");
        int a = Integer.parseInt(value[0]);
        int b = Integer.parseInt(value[2]);
        int result = 0;
        switch (value[1]){
            case "+":{
                result = a + b;
                break;
            }
            case "-": {
                result = a - b;
                break;
            }
            case "*": {
                result = a * b;
                break;
            }
        }
        System.out.println(outputStream.toString().replace("\n","").replace("\r", "") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

