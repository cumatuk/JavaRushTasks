package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();
        ArrayList<String> myArr = new ArrayList<>();
        long i = 0;
        String s;
        if (args.length > 0) {
            BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
            switch (args[0]) {
                case "-u": {
                    String idStr = args[1], product = args[2], price = args[3], quantity = args[4];
                    while ((s = fileRd.readLine()) != null) {
                        i = Integer.parseInt(s.substring(0, 8).trim());
                        if (i != Integer.parseInt(args[1]))
                            myArr.add(s);
                        else {
                            if (args[2].length() > 30)
                                product = args[2].substring(0, 30);
                            else if (args[2].length() < 30) {
                                while (product.length() != 30)
                                    product = product + " ";
                            }
                            if (args[3].length() > 8)
                                price = args[3].substring(0, 8);
                            else if (args[3].length() < 8) {
                                while (price.length() != 8)
                                    price = price + " ";
                            }
                            if (args[4].length() > 4)
                                quantity = args[4].substring(0, 4);
                            else if (args[4].length() < 4) {
                                while (quantity.length() != 4)
                                    quantity = quantity + " ";
                            }
                            if (idStr.length() < 8) {
                                while (idStr.length() != 8)
                                    idStr = idStr + " ";
                            }
                            myArr.add(idStr + product + price + quantity);
                        }
                    }
                }
                case "-d": {
                    while ((s = fileRd.readLine()) != null) {
                        i = Integer.parseInt(s.substring(0, 8).trim());
                        if (i != Integer.parseInt(args[1]))
                            myArr.add(s);
                    }
                }
                BufferedWriter fileWr = new BufferedWriter(new FileWriter(fileName));
                for (int j = 0; j < myArr.size(); j++)
                    fileWr.write(myArr.get(j) + "\n");
                myArr.clear();
                fileWr.close();
                fileRd.close();
            }
        }
    }
}
