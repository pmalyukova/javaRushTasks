package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream.available()>0){
            arrayList.add(fileInputStream.read());
        }
        fileInputStream.close();
        Collections.sort(arrayList);
        ArrayList<Integer> result = new ArrayList<Integer>(new HashSet<Integer>(arrayList));
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
