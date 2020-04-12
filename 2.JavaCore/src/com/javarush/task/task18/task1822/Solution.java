package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        String s1;
        rd.close();
        BufferedReader fileRd = new BufferedReader(new FileReader(s));
        while ((s1 = fileRd.readLine()) != null){
            if (s1.substring(0, s1.indexOf(" ")).equals(args[0]))
                System.out.println(s1);
        }
        fileRd.close();
    }
}
