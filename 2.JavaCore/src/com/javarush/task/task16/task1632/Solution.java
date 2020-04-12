package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }
    public static void main(String[] args) {
    }
    public static class MyThread1 extends Thread {
        public void run(){
            while (true){

            }
        }
    }
    public static class MyThread2 extends Thread {
        public void run(){
            if (isInterrupted())
                System.out.println("InterruptedException");
        }
    }
    public static class MyThread3 extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);

                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }
    public static class MyThread4 extends Thread implements Message {

        public void run(){
            while (!this.isInterrupted()){

            }
        }
        public void showWarning(){
                interrupt();
        }
    }
    public static class MyThread5 extends Thread {
        public void run() {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            String s;
            int i = 0;
            try {
                while (!(s = rd.readLine()).equals("N")){
                    i+= Integer.parseInt(s);
                }
                System.out.println(i);
            }
            catch (Exception e){
                e.getStackTrace();
            }
        }
    }
}