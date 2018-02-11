package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
 Считать в консоли 2 имени файла - file1, file2.
 Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
 Нужно создать объединенную версию строк, записать их в список lines
 Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
 Пример:
 оригинальный   редактированный    общий
 file1:         file2:             результат:(lines)

 строка1        строка1            SAME строка1
 строка2                           REMOVED строка2
 строка3        строка3            SAME строка3
 строка4                           REMOVED строка4
 строка5        строка5            SAME строка5
 строка0                           ADDED строка0
 строка1        строка1            SAME строка1
 строка2                           REMOVED строка2
 строка3        строка3            SAME строка3
 строка5                           ADDED строка5
 строка4        строка4            SAME строка4
 строка5                           REMOVED строка5
 */

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        //
        List<String> fileOne = new ArrayList<String>();
        //
        List<String> fileTwo = new ArrayList<String>();
        //
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(
                System.in));
        //
        String fileNameOne = nameReader.readLine();
        //
        String fileNameTwo = nameReader.readLine();
        //
        nameReader.close();
        //
        String line = "";
        //
        BufferedReader readFileOne = new BufferedReader(new FileReader(
                fileNameOne));
        //
        while ((line = readFileOne.readLine()) != null) {
            fileOne.add(line);
        }
        //
        readFileOne.close();
        line = "";
        //
        BufferedReader readFileTwo = new BufferedReader(new FileReader(
                fileNameTwo));
        //
        while ((line = readFileTwo.readLine()) != null) {
            fileTwo.add(line);
        }
        //
        readFileTwo.close();
        // /////////////////////////////////////////////////aloritmth
        if (fileOne.isEmpty() && fileTwo.isEmpty()) {

        } else if (fileOne.isEmpty() && !fileTwo.isEmpty()) {
            for (String s : fileTwo) {
                new LineItem(Type.ADDED, s);
            }
        } else if ((!fileOne.isEmpty()) && (fileTwo.isEmpty())) {
            for (String s : fileOne) {
                new LineItem(Type.REMOVED, s);
            }

        } else {
            for (int i = 0; i < fileOne.size(); i++) {
                if (fileTwo.isEmpty()) {
                    lines.add(new LineItem(Type.REMOVED, fileOne.get(i)));
                    //
                    //System.out.println(Type.REMOVED + " " + fileOne.get(i));
                    //
                } else {

                    if (fileOne.get(i).equals(fileTwo.get(0))) {
                        lines.add(new LineItem(Type.SAME, fileOne.get(i)));
                        fileTwo.remove(0);
                        //
                        //System.out.println(Type.SAME + " " + fileOne.get(i));
                        //
                    } else if ((fileOne.get(i)).equals((fileTwo.size()==1?"":fileTwo.get(1)))) {
                        Type thisType = Type.ADDED;
                        lines.add(new LineItem(Type.ADDED, fileTwo.get(0)));
                        //
                        //System.out.println(Type.ADDED + " " + fileTwo.get(0));
                        //
                        fileTwo.remove(0);
                        while (thisType == Type.ADDED) {
                            if ((fileOne.get(i)).equals(fileTwo.get(0))) {
                                thisType = Type.SAME;
                                lines.add(new LineItem(Type.SAME, fileOne.get(i)));
                                //
                                //System.out.println(Type.SAME + " "+ fileOne.get(i));
                                //
                                fileTwo.remove(0);
                            } else if ((fileOne.get(i)).equals((fileTwo.size()==1?"":fileTwo.get(1)))) {
                                thisType = Type.ADDED;
                                lines.add(new LineItem(Type.ADDED, fileOne
                                        .get(0)));

                                //
                                //System.out.println(Type.ADDED + " "+ fileTwo.get(0));
                                //
                                fileTwo.remove(0);
                                //
                            } else if (!(fileOne.get(i)).equals((fileTwo.size()==1?"":fileTwo.get(1)))) {
                                thisType = Type.REMOVED;
                                lines.add(new LineItem(Type.REMOVED, fileOne
                                        .get(i)));
                                //
                                //System.out.println(Type.REMOVED + " "		+ fileOne.get(i));
                                //
                            }
                        }
                    }
                    // removed
                    else if (!(fileOne.get(i)).equals((fileTwo.size()==1?"":fileTwo.get(1)))) {
                        lines.add(new LineItem(Type.REMOVED, fileOne.get(i)));
                        //
                        //System.out.println(Type.REMOVED + " " + fileOne.get(i));
                        //
                    }

                }
            }
        }
        // ////////////////////////////////////////
        if (!fileTwo.isEmpty()) {
            for (String s : fileTwo) {
                lines.add(new LineItem(Type.ADDED, s));
            }
        }
        // /////////////
		/*for (LineItem l : lines) {
			System.out.println(l.type + " " + l.line);
		}*/

    }

    public static enum Type {
        ADDED, // добавлена новая строка
        REMOVED, // удалена строка
        SAME // без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
