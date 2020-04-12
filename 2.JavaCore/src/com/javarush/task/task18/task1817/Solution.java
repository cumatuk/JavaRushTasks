package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream myStr = new FileInputStream(args[0]);
        int i;
        int n = myStr.available();
        int x = 0;
        double res = 0.0;
        while ((i = myStr.read())!= - 1){
            if ((char)i == ' ')
                x++;
        }
        res = ((double) x/n)*100.0;
        System.out.printf("%.2f %n", res);
        myStr.close();
    }
}
