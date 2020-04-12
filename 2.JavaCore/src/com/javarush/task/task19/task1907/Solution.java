package com.javarush.task.task19.task1907;

/* 
Считаем слово
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
        int count = 0;
        String data;
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        while (fileRd.ready()){
            data = fileRd.readLine();
            data = data.replaceAll("[^a-zA-Z]", " ");
            String[] stringArr = data.split(" ");
            for (String word : stringArr){
                if (word.equals("world"))
                    count++;
            }
        }
        System.out.println(count);
        fileRd.close();
    }
}
