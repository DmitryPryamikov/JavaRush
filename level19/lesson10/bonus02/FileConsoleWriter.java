package com.javarush.test.level19.lesson10.bonus02;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

public class FileConsoleWriter extends FileWriter {



    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
        // TODO Auto-generated constructor stub
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(char[] arg0, int arg1, int arg2) throws IOException {
        // TODO Auto-generated method stub

        super.write(arg0, arg1, arg2);
        System.out.println(String.valueOf(arg0).substring(arg1,arg1+arg2));
    }

    @Override
    public void write(String str) throws IOException
    {

        super.write(str);
        //System.out.println(str);
    }

    @Override
    public void write(int arg0) throws IOException {
        // TODO Auto-generated method stub
        System.out.println ((char) arg0);
        super.write(arg0);

    }

    @Override
    public void write(char[] cbuf) throws IOException
    {


        super.write(cbuf);
        //System.out.println(String.valueOf(cbuf));
    }

    @Override
    public void write(String arg0, int arg1, int arg2) throws IOException {
        // TODO Auto-generated method stub

        super.write(arg0, arg1, arg2);
        System.out.println(arg0.substring(arg1, arg1+arg2));

    }

}