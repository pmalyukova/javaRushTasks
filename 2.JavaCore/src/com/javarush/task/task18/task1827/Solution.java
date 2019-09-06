package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 4) return;
        String productName = padRight(args[1], 30);
        String price = padRight(args[2], 8);
        String quantity = padRight(args[3], 4);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        String id = padRight(String.valueOf(getMaxId(fileName) + 1), 8);

        if (args[0].equals("-c")) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.newLine();
            bufferedWriter.write(id + productName + price + quantity);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
    }

    private static String padRight(String input, int length) {
        if (input.length() < length) {
            return String.format("%1$-" + length + "s", input);
        } else {
            return input.substring(0, length);
        }
    }

    private static long getMaxId(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        long maxId = 0;
        long currId;
        String line;
        while ((line = fileReader.readLine()) != null) {
            currId = Integer.parseInt(line.substring(0, 8).trim());
            if (currId > maxId) {
                maxId = currId;
            }
        }
        fileReader.close();
        return maxId;
    }
}