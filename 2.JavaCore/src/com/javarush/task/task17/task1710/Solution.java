package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
      //  BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
      //  String s = rd.readLine();
      //  String name;
      //  int id;
        SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formatterOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
     //   Date bd;
     //   char sex;
        switch (args[0]){
            case "-c":{
             /*   s = s.substring(3, s.length());
                name = s.substring(0, s.indexOf(" "));
                s = s.substring(s.indexOf(" ") + 1, s.length());
                sex = s.charAt(0);
                bd = formatterIn.parse(s.substring(s.indexOf(" ") + 1, s.length()));
                if (sex == 'м')
                    allPeople.add(Person.createMale(name, bd));
                else if (sex == 'ж')
                    allPeople.add(Person.createFemale(name, bd));
                System.out.println(allPeople.size() - 1);
             */
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(args[1], formatterIn.parse(args[3])));
                else if (args[2].equals("ж"))
                    allPeople.add(Person.createFemale(args[1], formatterIn.parse(args[3])));
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "-u":{
               /* s = s.substring(3, s.length());
                id = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                s = s.substring(s.indexOf(" ") + 1, s.length());
                name = s.substring(0, s.indexOf(" "));
                s = s.substring(s.indexOf(" ") + 1, s.length());
                sex = s.charAt(0);
                bd = formatterIn.parse(s.substring(s.indexOf(" ") + 1, s.length()));
               */
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(formatterIn.parse(args[4]));
                if (args[3].equals("м"))
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                else if (args[3].equals("ж"))
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                break;
            }
            case "-d":{
              /*  id = Integer.parseInt(s.substring(3, s.length()));
                allPeople.get(id).setName(null);
                allPeople.get(id).setBirthDate(null);
                allPeople.get(id).setSex(null);
               */
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                break;
            }
            case "-i":{
             /*   id = Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length()));
                System.out.print(allPeople.get(id).getName() + " ");
                if (allPeople.get(id).getSex().equals(Sex.MALE))
                    System.out.print("м ");
                else if (allPeople.get(id).getSex().equals(Sex.FEMALE))
                    System.out.print("ж ");
                System.out.print(formatterOut.format(allPeople.get(id).getBirthDate()));
              */
                System.out.print(allPeople.get(Integer.parseInt(args[1])).getName() + " ");
                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE))
                    System.out.print("м ");
                else if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE))
                    System.out.print("ж ");
                System.out.print(formatterOut.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                break;
            }

        }
    }
}
