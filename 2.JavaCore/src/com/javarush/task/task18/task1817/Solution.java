package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSpace = 0;
        int countChar = 0;
        double res = 0;
        if (args.length >0){
            FileInputStream in = new FileInputStream(args[0]);
            while (in.available() > 0){
                countChar++;
                int data = in.read();
                if (data == Integer.valueOf(' ')){
                    countSpace++;
                }
            }
            in.close();
        }
        if (countChar == 0){
        }
        else {
            res = (double)countSpace/countChar*100;
        }
        System.out.printf("%.2f", res);
    }
}
