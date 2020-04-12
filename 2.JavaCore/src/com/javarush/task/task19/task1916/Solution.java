package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        List<String> file1List = new ArrayList<>();
        List<String> file2List = new ArrayList<>();
        BufferedReader file1Rd = new BufferedReader(new FileReader(file1));
        BufferedReader file2Rd = new BufferedReader(new FileReader(file2));
        while (file1Rd.ready()){
            file1List.add(file1Rd.readLine());
        }
        file1Rd.close();
        while (file2Rd.ready()){
            file2List.add(file2Rd.readLine());
        }
        file2Rd.close();
        int i = 0, j = 0;
        while (i < file1List.size() && j < file2List.size()){
            if (file1List.get(i).equals(file2List.get(j))){
                lines.add(new LineItem(Type.SAME, file1List.get(i)));
                i++;
                j++;
            }
            else{
                if (i < file1List.size() - 1 && file1List.get(i + 1).equals(file2List.get(j))){
                    lines.add(new LineItem(Type.REMOVED, file1List.get(i)));
                    i++;
                    lines.add(new LineItem(Type.SAME, file1List.get(i)));
                    i++;
                    j++;
                }
                if (j < file2List.size() - 1 && file2List.get(j + 1).equals(file1List.get(i))){
                    lines.add(new LineItem(Type.ADDED, file2List.get(j)));
                    j++;
                    lines.add(new LineItem(Type.SAME, file1List.get(i)));
                    i++;
                    j++;
                }
            }
        }
        if (i == file1List.size()){
            lines.add(new LineItem(Type.ADDED, file2List.get(file2List.size() - 1)));
        }
        if (j == file2List.size()){
            lines.add(new LineItem(Type.REMOVED, file1List.get(file1List.size() - 1)));
        }
      //  System.out.println(lines);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
