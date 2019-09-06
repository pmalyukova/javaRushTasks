package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import sun.nio.cs.UTF_32;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (args[0].equals("-u")){
            String id = padRight(args[1],8);
            String productName = padRight(args[2], 30);
            String price = padRight(args[3], 8);
            String quantity = padRight(args[4], 4);

            List<StringBuilder> fileLine = readFileLines(fileName);
            for (StringBuilder list : fileLine){
                if (id.equals(list.substring(0,8))) {
                    list.setLength(0);
                    list.append(id + productName + price + quantity);
                    break;
                }
            }
            wrightFile(fileName, fileLine);
        }

        if (args[0].equals("-d")){
            String id = padRight(args[1],8);
            List<StringBuilder> fileList = readFileLines(fileName);
            Iterator<StringBuilder> iterator = fileList.iterator();
            while (iterator.hasNext()){
                if (id.equals(iterator.next().substring(0,8))){
                    iterator.remove();
                }
            }
            wrightFile(fileName,fileList);
        }
    }

    private static void wrightFile(String fileName, List<StringBuilder> fileLine) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (StringBuilder line : fileLine){
            bufferedWriter.write(line.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static List<StringBuilder> readFileLines(String fileName) throws IOException {
        List<StringBuilder> fileLine = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String buff;
        while ((buff = reader.readLine()) != null){
            fileLine.add(new StringBuilder(buff));
        }
        reader.close();
        return fileLine;
    }

    private static String padRight (String previousName, int count ){
        if (previousName.length() > count){
            return previousName.substring(0,count);
        }
        else
            return String.format("%1$-" + count + "s", previousName);

    }
}
