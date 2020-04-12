package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream rd = new FileInputStream(args[0]);
        int[] myArr = new int[128];
        while (rd.available() > 0)
            myArr[rd.read()]++;
        rd.close();
        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] > 0)
                System.out.println((char)i + " " + myArr[i]);
        }
    }
}
