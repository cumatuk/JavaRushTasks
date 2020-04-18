package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];
        Solution sol1 = new Solution();
        Solution sol2 = new Solution();
        result[0] = sol1;
        result[1] = sol2;
        result[0].innerClasses[0] = sol1.new InnerClass();
        result[0].innerClasses[1] = sol1.new InnerClass();
        result[1].innerClasses[0] = sol2.new InnerClass();
        result[1].innerClasses[1] = sol2.new InnerClass();
        return result;
    }

    public static void main(String[] args) {

    }
}
