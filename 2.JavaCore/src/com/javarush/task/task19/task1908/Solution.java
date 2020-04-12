package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        String data, result = "";
        BufferedReader fileRd = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(file2));
        while (fileRd.ready()){
            data = fileRd.readLine();
            String[] myArr = data.split(" ");
            for (String val : myArr){
                if (val.matches("[0-9]*"))
                    result = result + val + " ";
            }
        }
        fileWr.write(result);
        fileRd.close();
        fileWr.close();
    }
}
