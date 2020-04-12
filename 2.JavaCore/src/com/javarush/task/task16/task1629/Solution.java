package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{
        private String s1, s2, s3;
        private int i = 1;
        public void run(){
           try {
              while (i < 4){
                   s1 = reader.readLine();
                   i++;
                   s2 = reader.readLine();
                   i++;
                   s3 = reader.readLine();
                   i++;
               }

           }
           catch (IOException e){
               e.getStackTrace();
           }
        }
        public void printResult(){
            if (!s1.equals(s2.equals(s3.equals(null))))
            System.out.println(s1 + " " + s2 + " " + s3);
        }
    }
}
