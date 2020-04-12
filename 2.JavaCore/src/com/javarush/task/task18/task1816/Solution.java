package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream myStr = new FileInputStream(args[0]);
        int i;
        int n = 0;
        while ((i = myStr.read())!= - 1){
            if (((char)i >= 'a' && (char)i <= 'z') || ((char)i >= 'A' && (char)i <= 'Z'))
                n++;
        }
        System.out.println(n);
        myStr.close();
    }
}
