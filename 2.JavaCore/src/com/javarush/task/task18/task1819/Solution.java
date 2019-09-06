package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream inFile2 = new FileInputStream(file2);
        FileInputStream inFile1 = new FileInputStream(file1);
        BufferedInputStream buf1 = new BufferedInputStream(inFile1);
        BufferedInputStream buf2 = new BufferedInputStream(inFile2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (buf2.available()>0){
            arrayList.add(buf2.read());
        }
        while (buf1.available()>0){
            arrayList.add(buf1.read());
        }
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
        FileOutputStream outFile1 = new FileOutputStream(file1);
        for (int s : arrayList){
            outFile1.write(s);
        }
        inFile1.close();
        inFile2.close();
        outFile1.close();
    }
}
