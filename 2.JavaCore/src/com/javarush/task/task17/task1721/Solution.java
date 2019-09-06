package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        String fileName1, fileName2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        String line = null;
        while ((line = reader1.readLine()) != null) {
            allLines.add(line);
        }
        reader1.close();

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)));
        line = null;
        while ((line = reader2.readLine()) != null){
            forRemoveLines.add(line);
        }
        reader2.close();
//        String fileName1 = getNameFile();
//        String fileName2 = getNameFile();
//        String line = null;
//        while (line != null){
//            line = getFileContent(fileName1, allLines);
//        }
//        while (line != null){
//            line = getFileContent(fileName2, forRemoveLines);
//        }
        new Solution().joinData();
    }


//    public static String getNameFile() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        return reader.readLine();
//    }
//
//    public static String getFileContent(String fileName, List<String> list) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//        while (reader.ready()) {
//            list.add(reader.readLine());
//        }
//        return fileName;
//    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
