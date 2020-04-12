package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        // in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream myOut = new ObjectOutputStream(new FileOutputStream("c:/test3.txt"));
        ObjectInputStream myIn = new ObjectInputStream(new FileInputStream("c:/test3.txt"));
        Solution first = new Solution("c:/test2.txt");
        first.writeObject("Test string writing");
        myOut.writeObject(first);
        myOut.close();
        Solution second = (Solution) myIn.readObject();
        second.writeObject("Test string 2 writing");
        myIn.close();
    }
}
