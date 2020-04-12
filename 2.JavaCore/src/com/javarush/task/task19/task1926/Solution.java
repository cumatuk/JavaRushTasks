package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();
        String result;
        StringBuilder myBuilder = new StringBuilder();
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        while (fileRd.ready()){
            result = fileRd.readLine();
            myBuilder.append(result);
            myBuilder.reverse();
            result = myBuilder.toString();
            System.out.println(result);
            myBuilder.setLength(0);
        }
        fileRd.close();
    }
}
