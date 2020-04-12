package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        FileReader fileRd = new FileReader(file1);
        FileWriter fileWr = new FileWriter(file2);
        int i = 1, data;
        while (fileRd.ready()){
            data = fileRd.read();
            if (i%2 == 0)
                fileWr.write(data);
            i++;
        }
        fileRd.close();
        fileWr.close();
    }
}
