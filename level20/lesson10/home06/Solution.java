package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable  {

    public static void main(String args[]) throws FileNotFoundException, IOException ,NotSerializableException {
        SubSolution ss  = new SubSolution();
        //
        ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("ss.out"));
        //
        oos.writeObject(ss);
        oos.close();

    }

    public static class SubSolution extends Solution  {
        //

        private void writeObject(ObjectOutputStream stream) throws IOException
        {
            throw new NotSerializableException();
        }
        //
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
        {
            throw new NotSerializableException();
        }


    }

}
