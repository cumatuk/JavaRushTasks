package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
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
        ArrayList<Byte> toPrint = new ArrayList<>();
        int minNum = 0;
        int minNumMin = 0;
        while (rd1.available() > 0){
            myArr.add((byte)rd1.read());
        }
        for (int i = 0; i < myArr.size(); i++) {
            for (int j = 0; j < myArr.size(); j++) {
                if (myArr.get(i) == myArr.get(j))
                    minNum++;
            }
            if (minNum < minNumMin || minNumMin == 0)
               // if (minNum != 1)
                minNumMin = minNum;
            minNum = 0;
        }
        for (int i = 0; i < myArr.size(); i++) {
            for (int j = 0; j < myArr.size(); j++) {
                if (myArr.get(i) == myArr.get(j))
                    minNum++;
            }
            if (minNum == minNumMin)
                toPrint.add(myArr.get(i));
            minNum = 0;
        }
        rd1.close();
        for (int i = 0; i < toPrint.size(); i++) {
            for (int j = i + 1; j < toPrint.size(); j++) {
                if (toPrint.get(j).equals(toPrint.get(i)))
                    toPrint.remove(j);
            }
        }
        for (Byte myByte : toPrint)
            System.out.print(myByte + " ");
    }
}
