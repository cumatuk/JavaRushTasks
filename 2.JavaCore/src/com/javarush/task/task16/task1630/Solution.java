package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = rd.readLine();
            secondFileName = rd.readLine();
            rd.close();
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        String s, n = "";
        public void setFileName(String fullFileName){
            this.fileName = fullFileName;
        }
        public String getFileContent() {
            return n;
        }
        public void run(){

            try {
                BufferedReader rd = new BufferedReader(new FileReader(fileName));
                while (!(s = rd.readLine()).equals(null)){
                    s = s + " ";
                    n += s;
                }
            }
            catch (Exception e){
                e.getStackTrace();
            }

        }
    }
}
