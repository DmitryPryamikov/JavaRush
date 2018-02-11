package com.javarush.test.level18.lesson08.task02;

import java.io.*;

/* Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
2. Считайте строку
3. Если считанная строка равна [Д], то закрыть поток
4. Если считанная строка не равна [Д], то не закрывать поток
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream amigoStream;
    //
    public  QuestionFileOutputStream(AmigoOutputStream stream) {
        // TODO Auto-generated constructor stub
        this.amigoStream = stream;
    }

    @Override
    public void flush() throws IOException {
        // TODO Auto-generated method stub
        amigoStream.flush();

    }

    @Override
    public void write(int b) throws IOException {
        // TODO Auto-generated method stub
        amigoStream.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {
        // TODO Auto-generated method stub
        amigoStream.write(b);

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        // TODO Auto-generated method stub
        amigoStream.write(b,off,len);

    }

    @Override
    public void close() throws IOException {
		/* Расширяем AmigoOutputStream
		Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
		В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
		1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
		2. Считайте строку
		3. Если считанная строка равна [Д], то закрыть поток
		4. Если считанная строка не равна [Д], то не закрывать поток
		*/
        //1
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        //2
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();

        //3 4
        if (answer.equals("Д"))
        {
            amigoStream.close();
        }
        reader.close();

    }

}
