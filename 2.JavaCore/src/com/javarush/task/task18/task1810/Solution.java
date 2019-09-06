package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            FileInputStream fileName = new FileInputStream(reader.readLine());
            if (fileName.available()<1000){
                fileName.close();
                reader.close();
                throw new DownloadException();
            }

        }
    }

    public static class DownloadException extends Exception {

    }
}
