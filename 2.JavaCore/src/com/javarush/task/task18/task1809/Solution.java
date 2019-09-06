package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import javax.jws.soap.SOAPMessageHandlers;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        ArrayList<Integer> temp = new ArrayList<>();
        while (inputStream.available() > 0){
            int data = inputStream.read();
            temp.add(data);
        }
        inputStream.close();
        for (int i = temp.size() - 1; i >= 0; i--){
            outputStream.write(temp.get(i));
        }
        outputStream.close();
    }
}
