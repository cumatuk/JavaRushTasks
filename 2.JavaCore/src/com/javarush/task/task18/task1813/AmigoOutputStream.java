package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream  {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream myStream;
    public AmigoOutputStream (FileOutputStream myStream) throws FileNotFoundException {
        super(fileName);
        this.myStream = myStream;
    }

    @Override
    public void write(int b) throws IOException {
        myStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        myStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        myStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        myStream.flush();
    }

    @Override
    public void close() throws IOException {
        myStream.flush();
        myStream.write("JavaRush © All rights reserved.".getBytes());
        myStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
