package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(args[1]));
        String result;
        String read;
        StringBuilder myBuilder = new StringBuilder();
        while (fileRd.ready()){
            read = fileRd.readLine();
            String[] myArr = read.split(" ");
            for (String val : myArr){
                if (val.length() > 6)
                    myBuilder.append(val + ",");
            }
        }
        fileRd.close();
        result = myBuilder.toString();
        result = result.substring(0, result.length() - 1);
        fileWr.write(result);
        fileWr.close();
    }
}
