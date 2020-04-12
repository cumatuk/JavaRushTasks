package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();
        String data, result = "";
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        while (fileRd.ready()){
            data = fileRd.readLine();
            String[] myArr = data.split(" ");
            for (int i = 0; i < myArr.length; i++){
                if (myArr[i].matches("[0-9]*")) {
                    if (map.containsKey(Integer.parseInt(myArr[i])))
                        myArr[i] = map.get(Integer.parseInt(myArr[i]));
                }
            }
            for (String val : myArr){
                result += val + " ";
            }
            System.out.println(result.substring(0, result.length() - 1));
            result = "";
        }
        fileRd.close();
    }
}
