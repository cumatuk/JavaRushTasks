package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream rd = new FileInputStream(args[1]);
        FileOutputStream wr = new FileOutputStream(args[2]);
        int myByte;
        if (args[0].equals("-e")){
            while (rd.available() > 0) {
                myByte = rd.read();
                if (myByte != -128)
                    myByte = -myByte;
                wr.write(myByte);
            }
        }
        else if (args[0].equals("-d")){
            while (rd.available() > 0) {
                myByte = rd.read();
                if (myByte != -128)
                    myByte = -myByte;
                wr.write(myByte);
            }
        }
        wr.close();
        rd.close();
    }
}
