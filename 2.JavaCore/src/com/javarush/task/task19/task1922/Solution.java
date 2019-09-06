package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(buf.readLine()));
        buf.close();
        while (reader.ready()){
            int count = 0;
            String jj = reader.readLine();
            String[] rr = jj.split(" ");
            for (String v : words) {
                for (String l : rr) {
                    if (l.equals(v)) {
                        count++;
                    }
                }
            }
            if (count == 2) System.out.println(jj);
        }
        reader.close();
    }
}