package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("name", "Ivanov");
        myMap.put("country", "Belarus");
        myMap.put("city", "Minsk");
        myMap.put("street", null);
        System.out.println(getQuery(myMap));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        boolean notEmpty = false;
        String strResult = "";
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue()!=null){
                result.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
                notEmpty = true;
            }
        }
        if (notEmpty)
            strResult = result.toString().substring(0, result.toString().lastIndexOf(" and"));
        return strResult;
    }
}
