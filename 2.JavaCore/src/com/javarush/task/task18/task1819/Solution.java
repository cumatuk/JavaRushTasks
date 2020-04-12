package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        FileInputStream myIn = new FileInputStream(file1);
        byte[] myArr =new byte[myIn.available()];
        myIn.read(myArr);
        myIn.close();
        FileOutputStream myOut = new FileOutputStream(file1);
        FileInputStream myIn1 = new FileInputStream(file2);
        int n = myIn1.available();
        while (myIn1.available() > 0){
            myOut.write(myIn1.read());
        }
        myOut.write(myArr);
        myIn1.close();
        myOut.close();
    }
}
