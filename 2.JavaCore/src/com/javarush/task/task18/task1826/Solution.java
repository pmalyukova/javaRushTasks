package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        String cryptType = args[0];
        String fileIn = args[1];
        String fileOut = args[2];

        cryptFile(fileIn,fileOut,cryptType);

    }
    public static void cryptFile(String fileIn, String fileOut, String cryptoType) throws Exception{
        FileInputStream inputStream = new FileInputStream(fileIn);
        FileOutputStream outputStream = new FileOutputStream(fileOut);
        int key = 1;
        if (cryptoType.equals("-e")){
            while (inputStream.available()>0){
                int data = inputStream.read()^key;
                outputStream.write(data);
            }
            inputStream.close();
        }
        else if (cryptoType.equals("-d")){
            while (inputStream.available()>0){
                int data = inputStream.read()^key;
                outputStream.write(data);
            }
            inputStream.close();
        }
        outputStream.close();
    }

}
