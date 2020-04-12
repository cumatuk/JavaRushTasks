package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        rd.close();
        FileInputStream rd1 =new FileInputStream(s);
        ArrayList<Byte> myArr = new ArrayList<>();
        Set<Byte> mySet = new TreeSet<>();
        byte num = 0;
        /*
        while (rd1.available() > 0){
            myArr.add((byte)rd1.read());
        }

         */
        while (rd1.available() > 0){
            mySet.add((byte)rd1.read());
        }
        rd1.close();
        /*
        for (int i = 0; i < myArr.size(); i++) {
            for (int j = i + 1; j < myArr.size(); j++) {
                if (myArr.get(j).equals(myArr.get(i)))
                    myArr.remove(j);
            }
        }
        for (int i = 0; i < myArr.size() - 1; i++) {
            for (int j = myArr.size() - 1; j > i; j--) {
                if (myArr.get(j) < myArr.get(i)){
                    num = myArr.get(i);
                    myArr.set(i, myArr.get(j));
                    myArr.set(j, num);
                }
            }
        }

        */


        for (Byte myByte : mySet)
            System.out.print(myByte + " ");
    }
}
