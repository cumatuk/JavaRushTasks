package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream value;
    public QuestionFileOutputStream (AmigoOutputStream value){
        this.value = value;
    }
    public void flush() throws IOException{
        value.flush();
    }
    public void write(int b) throws IOException{
        value.write(b);
    }
    public void write(byte[] b) throws IOException{
        value.write(b);
    }
    public void write(byte[] b, int off, int len) throws IOException{
        value.write(b, off, len);
    }
    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        rd.close();
        if (s.equals("Д"))
            value.close();
    }
}

