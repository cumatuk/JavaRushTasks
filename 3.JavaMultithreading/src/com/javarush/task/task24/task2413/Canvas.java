package com.javarush.task.task24.task2413;

public class Canvas {
    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
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

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setPoint(double x, double y, char c){
        int xInt = (int)Math.round(x);
        int yInt = (int)Math.round(y);
        if (xInt < 0 || yInt < 0 || yInt >= matrix.length || xInt >= matrix[0].length) {
        }
        else {
            matrix[yInt][xInt] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0){
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }


}
