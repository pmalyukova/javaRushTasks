package com.javarush.task.task18.task1823;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")){
            names.add(fileName);
        }

        for (String x : names){
            new ReadThread(x).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            HashMap<Byte, Integer> map = new HashMap<>();
            byte[] data = new byte[0];
            int max = Integer.MIN_VALUE;
            byte res = Byte.MIN_VALUE;
            try {
                FileInputStream fis = new FileInputStream(this.fileName);
                while (fis.available()>0){
                    data = new byte[fis.available()];
                    fis.read(data);
                }
                fis.close();
            } catch (IOException e) {
               //NOP
            }
            for (byte x : data){
                if (map.containsKey(x)){
                    int count = map.get(x)+1;
                    map.put(x, count);
                }
                else map.put(x, 1);
            }

            for (Map.Entry<Byte, Integer> entry : map.entrySet()){
                if (entry.getValue()>max){
                    max = entry.getValue();
                    res = entry.getKey();
                }
            }
            synchronized (resultMap){
                resultMap.put(this.fileName, (int) res);
            }
        }
    }
}
