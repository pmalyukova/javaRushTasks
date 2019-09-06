package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<Integer> byteList = new ArrayList<>(); //для вывода значений самых часто повторяющихся
        HashMap<Integer, Integer> byteMap = new HashMap<>();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            byteList.add(data);
        }
        fileInputStream.close();
        for (Integer c : byteList){
            int count = 0;
            for (Integer d : byteList){
                if (c == d){
                    count++;
                }
            }
            byteMap.put(c,count);
        }

        int maxByte = 0;
        for (Map.Entry<Integer, Integer> pair : byteMap.entrySet()){
            if (pair.getValue() > maxByte){
                maxByte = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : byteMap.entrySet()){
            if (pair.getValue().equals(maxByte)){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
