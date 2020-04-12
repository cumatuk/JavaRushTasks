package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = rd.readLine()).equals("exit")){
            new ReadThread(s).start();
        }
        rd.close();
    }

    public static class ReadThread extends Thread  {
        private String filename;
        public ReadThread(String fileName) {
            this.filename = fileName;
          //  this.start();
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try {
                FileInputStream myRd = new FileInputStream(filename);
                byte[] myArr = new byte[myRd.available()];
                int n = 0, max = 0, maxI = 0;
                myRd.read(myArr);
                myRd.close();
                for (int i = 0; i < myArr.length; i++) {
                    for (int j = i; j < myArr.length; j++) {
                        if (myArr[i] == myArr[j])
                            n++;
                    }
                        if (n > max) {
                            max = n;
                            maxI = i;
                        }
                        n = 0;
                }
                resultMap.put(filename, (int)myArr[maxI]);
            }
            catch (IOException e){
                e.getStackTrace();
            }

        }
    }
}
