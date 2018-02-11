package com.javarush.test.level21.lesson05.task02;


import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this==o)
            return true;
        if (this.getClass()!=o.getClass()||o==null)
            return false;
        Solution n = (Solution) o;
        return ((this.first==n.first)||(first!=null&&first.equals(n.first)))&&((this.last==n.last)||(this.last!=null&&this.last.equals(n.last)));
    }
    //((this.first==lSol.first)||(first!=null&&first.equals(lSol.first)))&&((this.last==lSol.last)||(this.last!=null&&this.last.equals(lSol.last)));

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }

    @Override
    public int hashCode() {
        final int  prime = 31;
        int result = 1;
        result = prime*result+((first==null)?0:first.hashCode());
        result = prime*result+((last==null)?0:last.hashCode());

        return result;
    }
}
