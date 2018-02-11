package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main (String[] args) throws TooShortStringException
    {
        Solution ss = new Solution();
        System.out.println(ss.getPartOfString("Мама мыла грязную раму "));
    }
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null||string.isEmpty())
        {
            throw new Solution.TooShortStringException();
        }
        char spaceIndex = ' ';
        int spaceCount=0;
        StringBuilder sb = new StringBuilder();
        if (string.indexOf(spaceIndex)==-1)
        {
            throw new Solution.TooShortStringException();
        }
        else
        {
            int sIndex = string.indexOf(spaceIndex);
            spaceCount++;

            for (int i = sIndex+1; i<string.length();i++)
            {
                if (string.charAt(i)==' '&&spaceCount==4)
                {
                    break;
                }
                else if ((string.charAt(i)==' '&&spaceCount<4))
                {
                    spaceCount++;
                    sb.append(string.charAt(i));
                }
                else
                {
                    sb.append(string.charAt(i));
                }

            }

        }
        if (spaceCount==4)
        {
            return sb.toString();
        }
        else
        {
            throw new Solution.TooShortStringException();

        }

    }

    public static class TooShortStringException extends Exception {
    }
}