package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(nameFile1);
        FileOutputStream file2 = new FileOutputStream(nameFile2);
//        FileInputStream file1 = new FileInputStream("C:\\Users\\PolinaMalyukova\\Desktop\\1.txt");
//        FileOutputStream file2 = new FileOutputStream("C:\\Users\\PolinaMalyukova\\Desktop\\2.txt");
        reader.close();
            while (file1.available() >0){
                byte[] data = new byte[file1.available()];
                file1.read(data);

                String[] strArrDouble = new String(data).split(" ");
                StringBuilder resultStrLong = new StringBuilder(data.length);

                for (String strDouble : strArrDouble) {
                    resultStrLong.append(Math.round(Double.valueOf(strDouble)));
                    resultStrLong.append(" ");
                }
                file2.write(resultStrLong.toString().getBytes());
            }
        file1.close();
        file2.close();
    }
}
