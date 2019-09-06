package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(name1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(name2));
        String line;
        String result;
        while ((line=reader.readLine()) != null){
            Pattern pattern = Pattern.compile("\\.");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                result = matcher.replaceAll("!");
                writer.write(result);
            }

        }
        reader.close();
        writer.close();
    }
}
