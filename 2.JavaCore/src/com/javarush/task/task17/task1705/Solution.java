package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/* 
Сад-огород
*/

public class Solution {


    public static void main(String[] args) {

    }

    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit){
            this.fruits.add(index,fruit);
        }
        public synchronized void removeFruit(int index){
            this.fruits.remove(index);
        }
        public synchronized void addVegetable(int index, String vegetable){
            this.vegetables.add(index,vegetable);
        }
        public synchronized void removeVegetable(int index){
            this.vegetables.remove(index);
        }
    }
}
