package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis;
        String fileName;
        while (true){ //пока вводятся имена файлов
            fileName = reader.readLine();
            try {
                fis = new FileInputStream(fileName); // создаем для файлов потоки чтения
                fis.close();
            } catch (FileNotFoundException e) { //если файл не найден
                System.out.println(fileName);//выводим имя файла на экран
                reader.close(); //закрываем поток
                break;//завершаем работу программы
            }
        }

    }
}
