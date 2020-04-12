package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        rd.close();
        FileInputStream rd1 =new FileInputStream(s);
        int maxByte = 0;
        while (rd1.available() > 0){
            int data = rd1.read();
            if (data > maxByte)
                maxByte = data;
        }
        rd1.close();
        System.out.println(maxByte);
    }
}
