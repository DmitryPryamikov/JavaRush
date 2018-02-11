package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String line, fileName;

        //
        fileName = reader.readLine();
        //
        OutputStream ofs = new FileOutputStream(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(ofs));
        while (!((line = reader.readLine()).equals("exit")))
        {
            bufferedWriter.write(line);
            bufferedWriter.newLine();

        }
        if (line.equals("exit"))
        {
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
        ofs.close();
    }
}
/*public static void writeFile1() throws IOException {
	File fout = new File("out.txt");
	FileOutputStream fos = new FileOutputStream(fout);

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

	for (int i = 0; i < 10; i++) {
		bw.write("something");
		bw.newLine();
	}

	bw.close();
}*/