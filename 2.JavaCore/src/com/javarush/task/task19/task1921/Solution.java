package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        String data, name = "", birth = "";
        Date birthday;
        while (fileRd.ready()){
            data = fileRd.readLine();
            String[] myArr = data.split(" ");
            for (int i = 0; i < myArr.length - 3; i++) {
                name += myArr[i] + " ";
            }
            name = name.substring(0, name.length() - 1);
            birth = myArr[myArr.length - 3] + " " + myArr[myArr.length - 2] + " " + myArr[myArr.length - 1];
            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            birthday = myFormat.parse(birth);
            PEOPLE.add(new Person(name, birthday));
            name = "";
        }
        fileRd.close();
    }
}
