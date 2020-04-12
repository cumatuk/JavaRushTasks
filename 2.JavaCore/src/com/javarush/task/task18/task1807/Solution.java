package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        byte myByte;
        int result = 0;
        String s = rd.readLine();
        rd.close();
        FileInputStream rd1 = new FileInputStream(s);
        while (rd1.available() > 0){
            myByte = (byte)rd1.read();
            if (myByte == 44)
                result++;
        }
        System.out.println(result);
        rd1.close();
      // char n = ',';
      // System.out.println((byte)n);

    }
}
