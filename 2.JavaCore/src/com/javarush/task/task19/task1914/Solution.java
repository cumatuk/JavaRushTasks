package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream origStream = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        testString.printSomething();
        System.setOut(origStream);
        String result = outStream.toString();
        int a, b, c = 0;
        String[] myArr = result.split(" ");
        a = Integer.parseInt(myArr[0]);
        b = Integer.parseInt(myArr[2]);
        switch (myArr[1]){
            case "+":{
                c = a + b;
                break;
            }
            case "-":{
                c = a - b;
                break;
            }
            case "*":{
                c = a * b;
                break;
            }
        }
        result = a + " " + myArr[1] + " " + b + " " + myArr[3] + " " + c;
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

