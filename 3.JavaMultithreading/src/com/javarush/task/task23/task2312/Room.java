package com.javarush.task.task23.task2312;

public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int hright, Snake snake) {
        this.width = width;
        this.height = hright;
        this.snake = snake;
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

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public static Room game;

    public void run(){

    }

    public void sleep(){

    }

    public void print(){

    }

    public void createMouse(){
        mouse = new Mouse(((int)(Math.random() * width)), ((int)(Math.random() * height)));
    }

    public void eatMouse(){
        createMouse();
    }

    public static void main(String[] args) {
        Snake snake = new Snake(10, 10);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(400, 400, snake);
        game.createMouse();
        game.run();
    }
}
