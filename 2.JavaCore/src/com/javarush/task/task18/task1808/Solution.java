package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream in1 = new FileInputStream(fileName1);
        FileOutputStream out2 = new FileOutputStream(fileName2);
        FileOutputStream out3 = new FileOutputStream(fileName3);
        while (in1.available() > 0){
            if (in1.available()%2 == 0){
                byte[] o1 = new byte[in1.available()/2];
                byte[] o2 = new byte[in1.available()/2];
                int count1 = in1.read(o1);
                int count2 = in1.read(o2);
                out2.write(o1, 0, count1);
                out3.write(o2, 0, count2);
            }
            else {
                byte[] o1 = new byte[in1.available()/2 + 1];
                byte[] o2 = new byte[in1.available()/2];
                int count1 = in1.read(o1);
                int count2 = in1.read(o2);
                out2.write(o1,0,count1);
                out3.write(o2,0,count2);
            }
        }
        in1.close();
        out2.close();
        out3.close();
    }
}
