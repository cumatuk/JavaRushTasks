package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine()), "UTF-8"));
        rd.close();
        String[] myArr;
        StringBuilder strB = new StringBuilder();
        String s;
        while (fileRd.ready()) {
            strB.append(fileRd.readLine() + " ");
        }
        fileRd.close();
        myArr = strB.toString().split("\\s+");
            for (int i = 0; i < myArr.length - 1; i++) {
                strB = new StringBuilder(myArr[i]);
                s = strB.reverse().toString();
                for (int j = i + 1; j < myArr.length; j++) {
                    if (myArr[j].equals(s)) {
                        if (!contains(s)) {
                            Pair pair = new Pair();
                            pair.first = myArr[i];
                            pair.second = myArr[j];
                            result.add(pair);
                        }
                    }
                }
            }
        System.out.println(result);
    }
    public static boolean contains(String word){
        boolean isContain = false;
        for (Pair pair : result){
            isContain = pair.first.equals(word)||pair.second.equals(word);
        }
        return isContain;
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
