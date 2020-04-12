package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        String data;
        BufferedReader fileRd = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(file2));
        while (fileRd.ready()){
            data = fileRd.readLine();
            data = data.replaceAll("\\p{Punct}", "");
            fileWr.write(data);
        }
        fileRd.close();
        fileWr.close();
    }
}
