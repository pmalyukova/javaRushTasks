package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(name.readLine()));
        name.close();
        String str;
        ArrayList<String> list = new ArrayList<>();
        while ((str = file.readLine()) != null){ //читаем построчно
            list.add(str);
        }
        file.close();

        for (int i = 0; i <list.size() ; i++) {
            String[] words = list.get(i).split(" "); //с каждой строки собираем слова отдельно
            for (int j = 0; j < words.length; j++) {
                for (Map.Entry entry : map.entrySet()){
                    if (words[j].matches(entry.getKey().toString())){
                        words[j] = entry.getValue().toString();
                    }
                }
                System.out.println(words[j] + " ");
            }
            System.out.println();
        }
    }
}
