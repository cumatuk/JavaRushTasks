package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width, height;
    private Ball ball;
    private Stand stand;
    static Arkanoid game;
    private boolean isGameOver;

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> brick) {
        this.bricks = brick;
    }

    private List<Brick> bricks;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void run(){

    }
    public void move(){
        stand.move();
        ball.move();
    }

    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick brick : bricks)
            brick.draw(canvas);
    }

    public void checkBricksBump(){
        for (int i = 0; i < bricks.size(); i++) {
            if (ball.isIntersec(bricks.get(i))){
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                bricks.remove(i);
            }
        }
    }

    public void checkStandBump(){
        if (ball.isIntersec(stand)){
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    public void checkEndGame(){
        if (ball.y > height)
            isGameOver = true;
    }

    public static void main(String[] args) {

    }
}
