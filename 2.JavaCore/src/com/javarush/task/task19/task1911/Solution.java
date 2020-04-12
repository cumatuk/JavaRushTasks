package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream origStream = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream myOutStream = new PrintStream(outStream);
        System.setOut(myOutStream);
        testString.printSomething();
        System.setOut(origStream);
        String result = outStream.toString();
        result = result.toUpperCase();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
