package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        FileInputStream frd = new FileInputStream(file1);
        FileOutputStream fwr = new FileOutputStream(file2);
        byte[] myArr = new byte[frd.available()];
        while (frd.available() > 0)
            frd.read(myArr);
        byte tmp;
        for (int i = 0; i < myArr.length / 2; i++) {
            tmp = myArr[i];
            myArr[i] = myArr[myArr.length - 1 - i];
            myArr[myArr.length -1 - i] = tmp;
        }
        fwr.write(myArr);
        frd.close();
        fwr.close();
    }
}
