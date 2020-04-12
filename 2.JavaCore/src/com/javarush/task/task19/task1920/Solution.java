package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        String data, name;
        Double val, tmp, max = 0.0d;
        TreeSet<String> mySet = new TreeSet<>();
        Map<String, Double> myMap = new HashMap<>();
        while (fileRd.ready()){
            data = fileRd.readLine();
            name = data.substring(0, data.indexOf(" "));
            val = Double.parseDouble(data.substring(data.indexOf(" ") + 1, data.length()));
            if (myMap.containsKey(name)){
                tmp = myMap.get(name);
                myMap.replace(name, tmp + val);
            }
            else {
                myMap.put(name, val);
            }
        }
        for (Map.Entry pair : myMap.entrySet()){
            if ((double)pair.getValue() > max)
                max = (double)pair.getValue();
        }
        for (Map.Entry pair : myMap.entrySet()){
            if ((double)pair.getValue() == max)
                mySet.add(pair.getKey().toString());
        }
        for (String inSet : mySet)
            System.out.println(inSet);
        fileRd.close();
    }
}
