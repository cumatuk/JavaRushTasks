package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String result = "";
       try {
           StringBuilder tmp = new StringBuilder();
           String[] myArr = string.split(" ");
               for (int i = 1; i < 5; i++) {
                   tmp.append(myArr[i]);
                   if (i != 4)
                       tmp.append(" ");
               }
               result = tmp.toString();
       }
       catch (Exception e){
           throw new TooShortStringException();
       }
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
