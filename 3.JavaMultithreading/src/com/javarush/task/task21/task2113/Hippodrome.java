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
        for (int i = 1; i < 101; i++) {
            this.move();
            this.print();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e){
                e.getStackTrace();
            }
        }
    }

    public void move(){
        for (Horse horse : this.horses){
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : this.horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
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
        game.run();
        game.printWinner();
    }
    public Horse getWinner(){
        Horse maxDistHorse = horses.get(0);
        double maxDist = 0.0;
        for (Horse horse : horses)
            if (horse.getDistance() > maxDist) {
                maxDist = horse.getDistance();
                maxDistHorse = horse;
            }
        return maxDistHorse;
    }
    public void printWinner(){
        System.out.println("Winner is " + this.getWinner().getName() + "!");
    }
}
