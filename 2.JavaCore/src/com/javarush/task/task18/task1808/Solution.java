package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        String file3 = rd.readLine();
        rd.close();
        FileInputStream rd1 = new FileInputStream(file1);
        FileOutputStream wrd1 = new FileOutputStream(file2);
        FileOutputStream wrd2 = new FileOutputStream(file3);
        int count = rd1.available();
        byte[] myArray = new byte[count];
        int countFile2;
        if (count % 2 != 0)
            countFile2 = count / 2 + 1;
        else
            countFile2 = count / 2;
       // while (rd1.available() >= countFile2){
       //     wrd1.write(rd1.read());
       // }
       // while (rd1.available() > 0){
       //     wrd2.write(rd1.read());
       // }
        while (rd1.available() > 0){
            rd1.read(myArray);
        }
        System.out.println(count);
        System.out.println(countFile2);
        wrd1.write(myArray, 0, countFile2);
        wrd2.write(myArray, countFile2, (count - countFile2));
        rd1.close();
        wrd1.close();
        wrd2.close();
    }
}
