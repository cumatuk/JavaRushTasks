package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s1 = rd.readLine();
        String s2 = rd.readLine();
        rd.close();
        rd = new BufferedReader(new FileReader(s1));
        while ((s1 = rd.readLine()) != null){
            allLines.add(s1);
        }
        rd.close();
        rd = new BufferedReader(new FileReader(s2));
        while ((s1 = rd.readLine()) != null){
            forRemoveLines.add(s1);
        }
        rd.close();
        Solution mySol = new Solution();
        mySol.joinData();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

}
