package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface val;
        public TableInterfaceWrapper (TableInterface val){
            this.val = val;
        }
        public void setModel(List rows){
            System.out.println(rows.size());
            val.setModel(rows);
        }
        public void setHeaderText(String newHeaderText){
            val.setHeaderText(newHeaderText);
        }
        public String getHeaderText(){
            return val.getHeaderText().toUpperCase();
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}