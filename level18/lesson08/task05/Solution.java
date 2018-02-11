package com.javarush.test.level18.lesson08.task05;

import java.util.List;

/* Таблица
Измените класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели
Метод getHeaderText должен возвращать текст в верхнем регистре - используйте метод toUpperCase()
*/

public class Solution {
    //
    public class TableInterfaceWrapper implements ATableInterface {
        private ATableInterface mATableInteface;

        //
        public  TableInterfaceWrapper(ATableInterface inter) {
            // TODO Auto-generated constructor stub
            mATableInteface = inter;
        }

        @Override
        public void setModel(List rows) {
            // TODO Auto-generated method stub
            System.out.println(rows.size());
           mATableInteface.setModel(rows);

        }

        @Override
        public String getHeaderText() {
            // TODO Auto-generated method stub
            return mATableInteface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            // TODO Auto-generated method stub
           mATableInteface.setHeaderText(newHeaderText);

        }

    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }
}