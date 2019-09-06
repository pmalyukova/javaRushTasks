package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int result = 0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[i].length ; j++) {
                if (a[i][j] == 1){
                    findRectangle(i, j , a);
                    result++;
                }
            }
        }
        return result;
    }

    private static void findRectangle(int i, int j, byte[][] a) {
        int endI = -1;
        int endJ = -1;
        for (int k = j; k < a.length ; k++) {
            if (a[i][k] == 0){
                endJ = k - 1;
                break;
            }
            if (k == a.length - 1)
                endJ = k;
        }
        for (int k = i; k <a[0].length ; k++) {
            if (a[k][j] == 0){
                endI = k - 1;
                break;
            }
            if (k == a[0].length - 1)
                endI = k;
        }
        clearRectangle(a, i, j, endI, endJ);
    }

    private static void clearRectangle(byte[][] a, int i, int j, int endI, int endJ) {
        for (int k = i; k <= endI ; k++) {
            for (int l = j; l <= endJ ; l++) {
                a[k][l] = 0;
            }
        }
    }
}
