package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(args[1]));
        while (fileRd.ready()){
            String[] myArr = fileRd.readLine().split(" ");
            for (String val : myArr){
                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(val);
                if (matcher.find())
                    fileWr.write(val + " ");
            }
        }
        fileRd.close();
        fileWr.close();
    }
}
