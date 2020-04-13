package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null)
            return false;
        if (n.getClass() != this.getClass())
            return false;
        if (n == this)
            return true;
        Solution tmp = (Solution) n;
        if (((tmp.first != null && tmp.first.equals(first)) && (tmp.last != null && tmp.last.equals(last)))
                || ((tmp.first == null && first == null) &&(tmp.last == null && last == null))
                || ((tmp.first != null && tmp.first.equals(first)) &&(tmp.last == null && last == null))
                || ((tmp.first == null && first == null) && (tmp.last != null && tmp.last.equals(last))))
        return true;
        return false;
    }

    public int hashCode() {
        return 31 * (first == null? 0 : first.hashCode()) + (last == null ? 0 :last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
