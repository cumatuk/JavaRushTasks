package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        rd.close();
        BufferedReader fileRd = new BufferedReader(new FileReader(name));
        StringBuilder myString = new StringBuilder();
        String text;
        String openTegStr = "<" + args[0];
        String closeTegStr = "</" + args[0] + ">";
        int openCount = 0, closeCount = 0;
        ArrayList<Integer> openAddr = new ArrayList<>();
        ArrayList<Integer> closeAddr = new ArrayList<>();
        while (fileRd.ready()){
            myString.append(fileRd.readLine());
        }
        fileRd.close();
        text = myString.toString().replace("\n", "");
        char[] textHtml = text.toCharArray();
        for (int i = 0; i < textHtml.length; i++) {
            if (textHtml[i] == '<'){
                if (text.substring(i, i + openTegStr.length()).equals(openTegStr)) {
                    openAddr.add(i);
                    openCount++;
                }
                if (text.substring(i, i + closeTegStr.length()).equals(closeTegStr)) {
                    closeAddr.add(i + closeTegStr.length());
                    closeCount++;
                }
            }
            if (openCount == closeCount && openCount != 0){
                for (int j = 0; j < openAddr.size(); j++) {
                    System.out.println(text.substring(openAddr.get(j), closeAddr.get(closeAddr.size() - 1 - j) ));
                }
                openAddr.clear();
                closeAddr.clear();
                openCount = 0;
                closeCount = 0;
            }
        }
    }
}
