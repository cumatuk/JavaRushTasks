package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
        BufferedWriter fileWr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"));
        while (fileRd.ready()){
            fileWr.write(fileRd.readLine());
        }
        fileRd.close();
        fileWr.close();
    }
}
