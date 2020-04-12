package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s, res, tmp;
        char[] copy = new char[200];
        int k;
        ArrayList<String> myArr = new ArrayList<>();
        while (!(s = rd.readLine()).equals("end"))
            myArr.add(s);
        rd.close();
        for (int i = 0; i < myArr.size(); i++) {
            for (int j = myArr.size() - 1; j > i; j--) {
                if (Integer.parseInt(myArr.get(j).substring(myArr.get(j).lastIndexOf(".part") + 5)) < Integer.parseInt(myArr.get(i).substring(myArr.get(i).lastIndexOf(".part") + 5))){
                    tmp = myArr.get(j);
                    myArr.set(j, myArr.get(i));
                    myArr.set(i, tmp);
                }
            }
        }
      //  System.out.println(myArr);
        res = myArr.get(0).substring(0, myArr.get(0).lastIndexOf("."));
      //  System.out.println(res);
        BufferedWriter wr = new BufferedWriter(new FileWriter(res, true));
        for (String part : myArr){
            BufferedReader rd1 = new BufferedReader(new FileReader(part));
            while ((k = rd1.read(copy)) > 0){
                wr.write(copy,0, k);
            }
            rd1.close();
        }
        wr.close();
    }
}
