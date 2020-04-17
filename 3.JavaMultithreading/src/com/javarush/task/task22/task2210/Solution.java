package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer myTokenizer = new StringTokenizer(query, delimiter);
        List<String> myArr = new ArrayList<String>();
        while (myTokenizer.hasMoreTokens()){
            myArr.add(myTokenizer.nextToken());
        }
        String[] result = new String[myArr.size()];
        myArr.toArray(result);
        return result;
    }
}
