package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            InputStream inputStream = new FileInputStream(your_file_name);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            Solution savedObject = new Solution(5);
            out.writeObject(savedObject);
            Solution loadedObject = new Solution( 7);
            loadedObject = (Solution) in.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
