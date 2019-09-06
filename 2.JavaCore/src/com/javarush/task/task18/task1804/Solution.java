package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer, Integer> minByteMap = new HashMap<>();
        ArrayList<Integer> byteList = new ArrayList<>();
        while (inputStream.available()>0){
            byteList.add(inputStream.read());
        }
        inputStream.close();
        for (Integer c : byteList){
            int count = 0;
            for (Integer c1 : byteList){
                if (c == c1)
                    count++;
            }
            minByteMap.put(c, count);
        }
        int minByte = 1000;
        for (Map.Entry<Integer, Integer> pair : minByteMap.entrySet()){
            if (pair.getValue() < minByte){
                minByte = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : minByteMap.entrySet()){
            if (pair.getValue().equals(minByte))
                System.out.print(pair.getKey()+ " ");
        }
    }
}
