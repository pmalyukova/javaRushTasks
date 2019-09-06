package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
        String str;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp % 2 == 0) {
                arrayList.add(temp);
            }
        }
        scanner.close();
        reader.close();
        Collections.sort(arrayList);
        for (Integer arr : arrayList) {
            System.out.println(arr);
        }
    }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (fileInputStream.available()>0){
//            arrayList.add(fileInputStream.read());
//        }
//        Collections.sort(arrayList);
//        for (int i = 0; i < arrayList.size(); i++) {
//        if (arrayList.get(i)% 2 == 0)
//            System.out.println(arrayList.get(i));
//    }
//        reader.close();
//        fileInputStream.close();
//    }
}
