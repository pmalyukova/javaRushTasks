package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = file.readLine()) != null){
            sb.append(line);
        }
        file.close();

        Document document = Jsoup.parse(sb.toString(),"", Parser.xmlParser());//класс Document захватывает
                                                       //страницу, определяем откуда берем данные
        Elements element = document.select(args[0]);//задаем с какого места
        for (Element elem: element ){//захватываем все данные которые есть на странице
            System.out.println(elem);
        }


    }
}
