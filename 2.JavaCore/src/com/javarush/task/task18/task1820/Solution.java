package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();
        BufferedReader myIn = new BufferedReader(new FileReader(file1));
        BufferedWriter myOut = new BufferedWriter(new FileWriter(file2));
        int i;
        String s1, s2 = "", s4 = "";
        while ((s1 = myIn.readLine()) != null)
            s2 += s1;
    //    System.out.println(s2);
        String[] s3 = s2.split(" ");
        for (String val : s3){
            if (val.contains("."))
                i = (int)Math.round(Double.parseDouble(val));
            else i = Integer.parseInt(val);
        //    System.out.println(i);
            s4 = s4 + i + " ";
        }
        myOut.write(s4);
        myIn.close();
        myOut.close();
    }
}
