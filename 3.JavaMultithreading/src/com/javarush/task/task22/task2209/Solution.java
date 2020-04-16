package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine()), "UTF-8"));
        rd.close();
        StringBuilder str = new StringBuilder();
        while (fileRd.ready()){
            str.append(fileRd.readLine() + " ");
        }
        fileRd.close();
        String[] myArr = str.toString().split("\\s+");
        StringBuilder result = getLine(myArr);
        System.out.println(result.toString());
    }
    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        List<Integer> isDone = new ArrayList<>();
        int num = 0;

        while (num < words.length) {
            for (int i = 0; i < words.length; i++) {
                if (!isDone.contains(i)) {
                    if (num == 0) {
                        result.append(words[i] + " ");
                        isDone.add(i);
                        num++;
                        break;
                    }
                    else {
                        if (result.substring(0, 1).equalsIgnoreCase(words[i].substring(words[i].length() - 1))) {
                            result.insert(0, words[i] + " ");
                            isDone.add(i);
                            num++;
                            break;
                        }
                        if (result.substring(result.length() - 2, result.length() - 1).equalsIgnoreCase(words[i].substring(0, 1))) {
                            result.append(words[i] + " ");
                            isDone.add(i);
                            num++;
                            break;
                        }
                    }
                }
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result;
    }
}
