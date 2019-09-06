package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());

        int count = 0;
        String line = "";
        while (fileReader.ready()){
            char ch = (char) fileReader.read();
            line += String.valueOf(ch);
        }
        line = line.replaceAll("\\p{Punct}", " ");
        line = line.replaceAll("\n", " ");
        //System.out.println(line);

        String[] mas = line.split(" ");
        for (String x : mas){
            if (x.equals("world")){
                count++;
            }
        }
        System.out.println(count);
        reader.close();
        fileReader.close();
    }
}
