package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public void run(){

    }

    public void move(){

    }

    public void print(){

    }
    static Hippodrome game;
    public static void main(String[] args) {
        Horse horse1 = new Horse("Horse1", 3.0, 0.0);
        Horse horse2 = new Horse("Horse2", 3.0, 0.0);
        Horse horse3 = new Horse("Horse3", 3.0, 0.0);
        List<Horse> myList = new ArrayList<>();
        myList.add(horse1);
        myList.add(horse2);
        myList.add(horse3);
        game = new Hippodrome(myList);
    }
}
