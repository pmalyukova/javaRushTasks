package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        //Scanner sc = new Scanner(fis);

        while (fis.available()>0)
        {
            System.out.print((char)fis.read());
        }

        fis.close();
        br.close();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
////        BufferedReader buff = new BufferedReader(new FileReader(fileName));
//        FileInputStream inStream = new FileInputStream(fileName);
//        Scanner sc = new Scanner(inStream);
//
//        while (sc.hasNext()){
//            Object x = sc.next();
//            System.out.println(x);
//        }
//
//
//        reader.close();
//        sc.close();
//        //inStream.close();
//        // напишите тут ваш код
    }
}