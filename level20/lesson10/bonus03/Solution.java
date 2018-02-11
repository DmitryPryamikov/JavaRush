package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
 1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
 2. Метод detectAllWords должен найти все слова из words в массиве crossword.
 3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
 text - это само слово, располагается между начальным и конечным элементами
 4. Все слова есть в массиве.
 5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
 6. Метод main не участвует в тестировании
 */
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][] { { 'f', 'd', 'e', 'r', 'l', 'k' },
                { 'u', 's', 'a', 'm', 'e', 'o' },
                { 'l', 'n', 'g', 'r', 'o', 'v' },
                { 'm', 'l', 'p', 'r', 'r', 'h' },
                { 'p', 'o', 'e', 'e', 'j', 'j' } };
        List<Word> words = detectAllWords(crossword, "home", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop",
                "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "voel", "lock", "r", "re", "eo", "oe", null, "", " ");


        // "r", "re", "eo", "oe", null, "", " "
        for (Word w : words) {
            System.out.println(w);
        }
		/*
		 * Ожидаемый результат home - (5, 3) - (2, 0) same - (1, 1) - (4, 1)
		 */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<Word>();

        for (String s : words) {
            // get first char
            if (s == null)
                s = "";
            if ((!s.equals(" ")) && (!s.equals(""))) {
                char c = s.charAt(0);
                //
                int endi = 0;
                int endj = 0;
                String word = ""+s.charAt(0);
                outerLoop:
                for (int i = 0; i < crossword.length; i++) {
                    for (int j = 0; j < crossword[0].length; j++) {
                        // find first symbol
                        if (crossword[i][j] == c) {
                            // get matrix around this value 3x3 if value on
                            // ground
                            // dimension will change
                            int Rightlimit = (j + 1) > crossword[0].length - 1 ? j
                                    : j + 1;// int Rightlimit =
                            // (j+1)>crossword[0].length-1?j:j+1;
                            //
                            int Leftlimit = (j - 1) < 0 ? j : j - 1;// int
                            // Leftlimit
                            // =
                            // (j-1)<0?j:j-1
                            //
                            int BottomLimit = (i + 1) > crossword.length - 1 ? i
                                    : i + 1;// int BottomLimit =
                            // (i+1)>crossword.length-1?i:i+1
                            //
                            int UpLimit = (i - 1) < 0 ? i : i - 1;// int UpLimit
                            // =
                            // (i-1)<0?i:i-1
                            //

                            if (s.length() > 1) {
                                String temp="";
                                Direction wordDirection = null;

                                inner_loop: for (int jj = Leftlimit; jj <= Rightlimit; jj++) {
                                    for (int ii = UpLimit; ii <= BottomLimit; ii++) {
                                        if (crossword[ii][jj] == s.charAt(1)) {
                                            //
                                            endi=i;
                                            endj=j;
                                            //
                                            wordDirection = getDirection(i, j,	ii, jj);
                                            //
                                            if (wordDirection==null)
                                            {
                                                continue;
                                            }
                                            try {
                                                for (int ci = 1; ci < s
                                                        .length(); ci++) {
                                                    endi = endi
                                                            + wordDirection
                                                            .getHorizontalMove();
                                                    endj = endj
                                                            + wordDirection
                                                            .getVerticalMove();
                                                    temp = temp
                                                            + (char) crossword[endi][endj];

                                                }
                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                temp = "";
                                            }
                                            //
                                            word = word+temp;

                                            if (word.equals(s)) {
                                                Word m_Word = new Word(s);
                                                m_Word.setStartPoint(j, i);
                                                m_Word.setEndPoint(endj, endi);
                                                wordList.add(m_Word);
                                                temp="";
                                                break outerLoop;

                                            }
                                            else{
                                                word =Character.toString(word.charAt(0));
                                                temp="";
                                            }
                                        }


                                    }

                                }

                            }
                            else
                            {
                                if (word.equals(s)) {
                                    Word m_Word = new Word(s);
                                    m_Word.setStartPoint(j, i);
                                    m_Word.setEndPoint(endj=j, endi=i);
                                    wordList.add(m_Word);
                                    break outerLoop;
                                }
                            }

                            // /////////////////////
                        }// end inner loop

                    }
                }
            }
        }

        return wordList;
    }

    private static Direction getDirection(int i, int j, int ii, int jj) {
        Direction wordDirection = null;
        // LEFTSIDE
        if (ii - i > 0) {
            if (jj - j < 0) {
                wordDirection = Direction.BOTTOMLEFT;
            } else if (jj == j) {
                wordDirection = Direction.DOWN;
            } else if (jj - j > 0) {
                wordDirection = Direction.BOTTOMRIGHT;
            }
        }
        // CENTERSIDE
        if (ii == i) {
            if (jj - j < 0) {
                wordDirection = Direction.LEFT;
            }

            else if (jj - j > 0) {
                wordDirection = Direction.RIGHT;
            }

        } else if (ii - i < 0) {
            if (jj - j < 0) {
                wordDirection = Direction.UPLEFT;
            } else if (jj == j) {
                wordDirection = Direction.UP;
            } else if (jj - j > 0) {
                wordDirection = Direction.UPRIGHT;
            }
        }
        return wordDirection;
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
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX,
                    startY, endX, endY);
        }
    }

    enum Direction {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1), UPLEFT(-1, -1), UPRIGHT(
                -1, 1), BOTTOMRIGHT(1, 1), BOTTOMLEFT(1, -1);
        //
        private int hmove;
        private int vmove;

        //
        Direction(int hor, int vert) {
            hmove = hor;
            vmove = vert;
        }

        int getVerticalMove() {
            return vmove;
        }

        //
        int getHorizontalMove() {
            return hmove;
        }

    }
}