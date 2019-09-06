package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);
        int count;
        for (int i = 1; fileReader.ready(); i++) {
            count =fileReader.read();
            if (i%2 == 0) {
                fileWriter.write(count);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
