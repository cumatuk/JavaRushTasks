package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        rd.close();
        FileInputStream rd1 =new FileInputStream(s);
        int minByte = 32000;
        while (rd1.available() > 0){
            int data = rd1.read();
            if (data < minByte)
                minByte = data;
        }
        rd1.close();
        System.out.println(minByte);
    }
}
