package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name2));
        String line;
        String result;
        while ((line = bufferedReader.readLine()) != null) {
            Pattern pattern = Pattern.compile("(\\p{Punct})");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                result = matcher.replaceAll("");
                bufferedWriter.write(result);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
