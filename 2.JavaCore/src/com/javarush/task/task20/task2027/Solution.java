package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
      int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");
       // detectAllWords(crossword, "home", "same");
        for (Word word : list)
            System.out.println(word);
        System.out.println("Array size is " + list.size());
/*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> myList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] wordArray = words[i].toCharArray();
            for (int j = 0; j < crossword.length; j++) {
                for (int k = 0; k < crossword[j].length; k++) {
                    if ((int)wordArray[0] == crossword[j][k]){
                        if (k <= crossword[j].length - wordArray.length){       //right is ok
                            for (int l = 1; l < wordArray.length;) {
                                if ((int)wordArray[l] == crossword[j][k + l]){
                                    if (l == wordArray.length - 1){
                                        Word word = new Word(words[i]);
                                        word.setStartPoint(k, j);
                                        word.setEndPoint(k + l, j);
                                        myList.add(word);
                                    }
                                    l++;
                                }
                                else break;
                            }
                          if (j <= crossword.length - wordArray.length){         //rightDown is ok
                              for (int l = 1; l < wordArray.length;) {
                                  if ((int)wordArray[l] == crossword[j + l][k + l]){
                                      if (l == wordArray.length - 1){
                                          Word word = new Word(words[i]);
                                          word.setStartPoint(k, j);
                                          word.setEndPoint(k + l, j + l);
                                          myList.add(word);
                                      }
                                      l++;
                                  }
                                  else break;
                              }
                          }
                            if (j >= wordArray.length - 1){                         //upRight is ok
                                for (int l = 1; l < wordArray.length;) {
                                    if ((int)wordArray[l] == crossword[j - l][k + l]){
                                        if (l == wordArray.length - 1){
                                            Word word = new Word(words[i]);
                                            word.setStartPoint(k, j);
                                            word.setEndPoint(k + l, j - l);
                                            myList.add(word);
                                        }
                                        l++;
                                    }
                                    else break;
                                }
                            }
                        }
                        if (k >= wordArray.length - 1){                           //left is ok
                            for (int l = 1; l < wordArray.length;) {
                                if ((int)wordArray[l] == crossword[j][k - l]){
                                    if (l == wordArray.length - 1){
                                        Word word = new Word(words[i]);
                                        word.setStartPoint(k, j);
                                        word.setEndPoint(k - l, j);
                                        myList.add(word);
                                    }
                                    l++;
                                }
                                else break;
                            }
                            if (j <= crossword.length - wordArray.length){         //leftDown is ok
                                for (int l = 1; l < wordArray.length;) {
                                    if ((int)wordArray[l] == crossword[j + l][k - l]){
                                        if (l == wordArray.length - 1){
                                            Word word = new Word(words[i]);
                                            word.setStartPoint(k, j);
                                            word.setEndPoint(k - l, j + l);
                                            myList.add(word);
                                        }
                                        l++;
                                    }
                                    else break;
                                }
                            }
                            if (j >= wordArray.length - 1){                         //upLeft is ok
                                for (int l = 1; l < wordArray.length;) {
                                    if ((int)wordArray[l] == crossword[j - l][k - l]){
                                        if (l == wordArray.length - 1){
                                            Word word = new Word(words[i]);
                                            word.setStartPoint(k, j);
                                            word.setEndPoint(k - l, j - l);
                                            myList.add(word);
                                        }
                                        l++;
                                    }
                                    else break;
                                }
                            }
                        }
                        if (j >= wordArray.length - 1){                         //up is ok
                            for (int l = 1; l < wordArray.length;) {
                                if ((int)wordArray[l] == crossword[j - l][k]){
                                    if (l == wordArray.length - 1){
                                        Word word = new Word(words[i]);
                                        word.setStartPoint(k, j);
                                        word.setEndPoint(k, j - l);
                                        myList.add(word);
                                    }
                                    l++;
                                }
                                else break;
                            }
                        }
                        if (j <= crossword.length - wordArray.length){         //down is ok
                            for (int l = 1; l < wordArray.length;) {
                                if ((int)wordArray[l] == crossword[j + l][k]){
                                    if (l == wordArray.length - 1){
                                        Word word = new Word(words[i]);
                                        word.setStartPoint(k, j);
                                        word.setEndPoint(k, j + l);
                                        myList.add(word);
                                    }
                                    l++;
                                }
                                else break;
                            }
                        }
                    }
                }
            }
        }
        return myList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
