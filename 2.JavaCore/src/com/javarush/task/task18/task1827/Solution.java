package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();
        long i = 0, id, max = 0;
        int k;
        String s;
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        while ((s = fileRd.readLine()) != null){
            i = Integer.parseInt(s.substring(0, 8).trim());
            if (i > max)
                max = i;
        }
      //  System.out.println(id);
        fileRd.close();
        if (args.length > 0) {
            if (args[0].equals("-c")) {
                id = max + 1;
                String itemToAdd, product = args[1], quantity = args[3], price = args[2], idStr = id + "";
                if (args[1].length() > 30)
                    product = args[1].substring(0, 30);
                else if (args[1].length() < 30){
                    while (product.length() != 30)
                        product = product + " ";
                }
                if (args[2].length() > 8)
                    price = args[2].substring(0, 8);
                else if (args[2].length() < 8){
                    while (price.length() != 8)
                        price = price + " ";
                }
                if (args[3].length() > 4)
                    quantity = args[3].substring(0, 4);
                else if (args[3].length() < 4){
                    while (quantity.length() != 4)
                        quantity = quantity + " ";
                }
                if (idStr.length() < 8){
                    while (idStr.length() != 8)
                        idStr = idStr + " ";
                }
                BufferedWriter fileWr = new BufferedWriter(new FileWriter(fileName, true));
              //  itemToAdd = String.format("%-8d%-30s%-8s%-4s", id, product, price, quantity);
              //  fileWr.write(itemToAdd + "\n");
                fileWr.write("\n" + idStr + product + price + quantity);
                fileWr.close();
            }
        }
    }
}
