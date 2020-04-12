package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] str = fileScanner.nextLine().split(" ", 4);

            String date = str[3];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd M y", Locale.ENGLISH);
            try {
                Date date1 = simpleDateFormat.parse(date);
                return new Person(str[1], str[2], str[0], date1);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
