package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split(" ");

            for (String s :
                    words) {
                if (s.length() > 6) stringBuilder.append(s).append(",");
            }
        }

        String resultLine = stringBuilder.toString();
        writer.write(resultLine.substring(0, stringBuilder.length() - 1));

        reader.close();
        writer.close();
    }
}
