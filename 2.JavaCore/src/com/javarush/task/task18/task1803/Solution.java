package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        rd.close();
        FileInputStream rd1 =new FileInputStream(s);
        ArrayList<Byte> myArr = new ArrayList<>();
      //  ArrayList<Byte> toPrint = new ArrayList<>();
        int maxNum = 0;
        int maxNummax = 0;
        while (rd1.available() > 0){
            myArr.add((byte)rd1.read());
        }
        for (int i = 0; i < myArr.size(); i++) {
            for (int j = 0; j < myArr.size(); j++) {
                if (myArr.get(i) == myArr.get(j))
                    maxNum++;
            }
            if (maxNum > maxNummax)
                maxNummax = maxNum;
            maxNum = 0;
        }
        for (int i = 0; i < myArr.size(); i++) {
            for (int j = i; j < myArr.size(); j++) {
                if (myArr.get(i) == myArr.get(j))
                    maxNum++;
            }
            if (maxNum == maxNummax)
                System.out.print(myArr.get(i) + " ");
            maxNum = 0;
        }
        rd1.close();
    }
}
