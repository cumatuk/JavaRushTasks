package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        String file3 = rd.readLine();
        rd.close();
        FileInputStream myIn1 = new FileInputStream(file2);
        FileInputStream myIn2 = new FileInputStream(file3);
        FileOutputStream myOut = new FileOutputStream(file1, true);
        while (myIn1.available() > 0){
            myOut.write(myIn1.read());
        }
        while (myIn2.available() > 0){
            myOut.write(myIn2.read());
        }
        myIn1.close();
        myIn2.close();
        myOut.close();
    }
}
