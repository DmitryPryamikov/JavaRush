package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
 В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
 Метод main не участвует в тестировании.
 */
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object arg0) {

        if (arg0 == this) {
            return true;
        }
        if (arg0==null || arg0.getClass()!=this.getClass())
            return false;
        Solution lSol = (Solution)arg0;

        return ((this.first==lSol.first)||(first!=null&&first.equals(lSol.first)))&&((this.last==lSol.last)||(this.last!=null&&this.last.equals(lSol.last)));
    }

    @Override
    public int hashCode() {
        final int  prime = 31;
        int result = 1;
        result = prime*result+((first==null)?0:first.hashCode());
        result = prime*result+((last==null)?0:last.hashCode());

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        Solution ss = new Solution("Donald", "Duck");
        // Solution ss1 = new Solution("Donald", "Duck");
        //
        // System.out.println(ss.hashCode());
        // System.out.println(ss1.hashCode());
        System.out.println(ss.equals(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
