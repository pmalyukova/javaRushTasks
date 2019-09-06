package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File(args[0]));
        byte[] symbol = new byte[fis.available()];
        fis.read(symbol);
        Arrays.sort(symbol);
        HashMap<Byte, Integer> map = new HashMap<>();
        int count;
        for (byte x : symbol){
            count=0;
            for (byte y : symbol){
                if (x==y){
                    count++;
                }
            }
            if (!map.containsKey(x)){
                map.put(x,count);
                System.out.println((char)x + " " + count);
            }
        }
        fis.close();
    }
}
