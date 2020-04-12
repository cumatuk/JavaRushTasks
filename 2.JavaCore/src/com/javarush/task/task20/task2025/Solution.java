package com.javarush.task.task20.task2025;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

/*
Алгоритмы-числа
*/
public class Solution {
    static ArrayList<Long> myArr = new ArrayList<>();
    static long[][] myArray;
    public static long[] getNumbers(long N) {
        long[] result = null;
        int num = digNum(N);
        myArray = new long[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                myArray[i][j] = pow(i, j + 1);
            }
        }
        calc(0, num, 0, N);
        result = new long[myArr.size()];
        for (int i = 0; i < myArr.size(); i++)
            result [i] = myArr.get(i);
        Arrays.sort(result);
        myArr.clear();
        return result;
    }
    public static void calc(int start, int rank, long extra, long N){
        long n;
        for (int i = start; i < 10; i++) {
            n = i * pow(10, rank - 1) + extra;
            if (n > 0 && n < N)
                isArmstrong(n, N);
            if (rank > 1)
                calc(i, rank - 1, n, N);
        }
    }
    public static long pow(int num, int pow){
        long result = 1L;
        for (int i = 0; i < pow; i++) {
            result *= num;
        }
        return result;
    }
    public static int digNum(long number){
        int result = 0;
        while (number >= 1) {
            result++;
            number /= 10;
        }
        return result;
    }
    public static void isArmstrong (long number, long N){
        int m = digNum(number);
        long tmp, L;
        long D, S = 0L, S1 = 0L;
            while (number >= 1) {
                L = number % 10;
                D = myArray[(int)L][m - 1];
                S+=D;
                number /= 10;
            }
            tmp = S;
            m = digNum(tmp);
        while (tmp >= 1) {
            L = tmp % 10;
            D = myArray[(int)L][m - 1];
            S1+=D;
            tmp /= 10;
        }
            if (S1 == S && !myArr.contains(S) && S < N)
                myArr.add(S);
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long [] result = getNumbers(Long.MAX_VALUE);
        System.out.println(Arrays.toString(result));
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000 + " MB");
    }
}
