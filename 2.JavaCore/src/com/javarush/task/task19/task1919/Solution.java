package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        while (reader.ready()){
            String[] tmp = reader.readLine().split(" ");
            if (!map.containsKey(tmp[0])){
                map.put(tmp[0], Double.parseDouble(tmp[1]));
            }
            else map.put(tmp[0], (map.get(tmp[0])+ Double.parseDouble(tmp[1])));
        }
        for (Map.Entry<String,Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        reader.close();
    }
}
