package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader nameFile = new FileReader(reader.readLine());
        BufferedReader bufFile = new BufferedReader(nameFile);

        String res;
        while ((res = bufFile.readLine()) != null){
            if (res.startsWith(args[0]+ " ")){
                System.out.println(res);
            }
        }
        reader.close();
        nameFile.close();
        bufFile.close();
    }
}