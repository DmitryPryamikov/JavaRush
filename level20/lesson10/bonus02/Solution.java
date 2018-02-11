package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int rectangleCount=0;
        for (int i =0 ; i <a.length;i++)
        {
            for (int j=0; j<a[0].length; j++)
            {
                //

                if (a[i][j]==1)
                {
                    rectangleCount++;
                    int ii=i;
                    int jj=j;
                    while (ii<a[i].length)
                    {
                        if (a[ii][j]==1)
                            ii++;
                        else break;
                    }
                    while (jj<a.length)
                    {
                        if (a[i][jj]==1)
                            jj++;
                        else break;
                    }
                    //
                    for (int i1 =i; i1 <ii; i1++)
                    {
                        for (int j1 = j; j1<jj; j1++)
                        {
                            a[i1][j1]=0;
                        }
                    }
                }
                //

            }
        }
        return rectangleCount;
    }
}
