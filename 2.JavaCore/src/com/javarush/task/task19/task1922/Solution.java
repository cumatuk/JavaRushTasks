package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        rd.close();
        String data;
        int count = 0;
        BufferedReader fileRd = new BufferedReader(new FileReader(name));
        while (fileRd.ready()){
            data = fileRd.readLine();
            String[] myArr = data.split(" ");
            for (String val : myArr){
                if (words.contains(val))
                    count++;
            }
            if (count == 2)
                System.out.println(data);
            count = 0;
        }
        fileRd.close();
    }
}
