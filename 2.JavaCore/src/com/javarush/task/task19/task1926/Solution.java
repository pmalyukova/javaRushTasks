package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line;

        ArrayList<String> array = new ArrayList<>();
        while ((line = file.readLine()) != null){
            array.add(line);
        }

        for (String s : array){
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            System.out.println(sb.toString());
        }
        file.close();

    }
}
