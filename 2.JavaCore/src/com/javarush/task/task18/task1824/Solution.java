package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String s = "";
        FileInputStream myRd;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                s = rd.readLine();
                myRd = new FileInputStream(s);
                myRd.close();
            }
        }
        catch (FileNotFoundException e){
            e.getStackTrace();
            System.out.println(s);
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }
}
