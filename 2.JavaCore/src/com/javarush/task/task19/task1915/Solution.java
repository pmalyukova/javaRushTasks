package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;//запоминаем настоящий PrintStream в специальную переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//Создаем динамический массив
        PrintStream stream = new PrintStream(outputStream); //создаем адаптер к классу PrintStream
        System.setOut(stream);//Устанавливаем его как текущий System.out

        testString.printSomething();//Вызываем функцию, которая ничего не знает о наших манипуляциях
        String result = outputStream.toString();//Преобразовываем записанные в наш ByteArray данные в строку

        System.setOut(consoleStream);//Возвращаем все как было

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileOutputStream fileOutputStream= new FileOutputStream(name);
        reader.close();
        System.out.println(result);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

