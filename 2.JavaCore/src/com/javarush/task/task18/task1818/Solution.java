package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        FileOutputStream out = new FileOutputStream(name1, true);
        FileInputStream in1 = new FileInputStream(name2);
        FileInputStream in2 = new FileInputStream(name3);
        BufferedInputStream bin1 = new BufferedInputStream(in1);
        BufferedInputStream bin2 = new BufferedInputStream(in2);
        int i, j;
        while ((i=bin1.read()) != -1){
            out.write(i);
        }
        bin1.close();
        while ((j=bin2.read()) != -1){
            out.write(j);
        }
        bin2.close();
        out.close();
    }
}
