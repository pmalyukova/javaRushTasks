package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException{
        //implement this method - реализуйте этот метод
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            load(new FileInputStream(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties(); //создаем объект
        for (Map.Entry<String,String> pair :properties.entrySet()){//перебираем все элементы в готовом properties
            prop.put(pair.getKey(),pair.getValue()); // и сохраняем в созданном объекте
        }
        prop.store(outputStream,""); //метод store записывает пары ключей и элементов в поток выходных символов
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties(); // создали объект
        prop.load(inputStream);// подключили к нему поток ввода данных
        for (Map.Entry<Object, Object> pair : prop.entrySet()){ //перебираем все элементы в новом объекте с потоком
            properties.put((String) pair.getKey(), (String) pair.getValue());//и добавлям каждую пару в Map properties
        }
    }

    public static void main(String[] args) {

    }
}
