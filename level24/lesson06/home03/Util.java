package com.javarush.test.level24.lesson06.home03;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    /*2. В классе Util в методе getAllJeans добавьте пропущенную часть java-кода:
2.1) разберитесь в том, что уже есть в методе getAllJeans класса Util
2.2) создайте абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуйте остальные методы
2.3) создайте классы Levis и Denim от AbstractJeans, реализуйте оставшийся метод
2.4) в классе AbstractJeans реализуйте метод toString() используя  Alt+Insert -> toString()
2.5) метод toString класса AbstractJeans должен начинаться с имени сабкласса, например, Levis{id=1, length=34, size=6, price=150.0}*/
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here
        abstract class AbstractJeans implements Jeans
        {
            @Override
            public String toString() {
                // TODO Auto-generated method stub
                return this.getClass().getSimpleName()+"{id="+_id+", length="+_length+", size="+_size+", price="+_price+"}";
            }

            int _id;
            int _length;
            int _size;
            double _price;

            public AbstractJeans(int id, int length, int size, double price) {
                // TODO Auto-generated constructor stub
                _id=id;
                _length=length;
                _size=size;
                _price=price;
            }

            @Override
            public int getId() {
                // TODO Auto-generated method stub
                return _id;
            }

            @Override
            public double getPrice() {
                // TODO Auto-generated method stub
                return _price;
            }

            @Override
            public int getLength() {
                // TODO Auto-generated method stub
                return _length;
            }

            @Override
            public int getSize() {
                // TODO Auto-generated method stub
                return _size;
            }

        }
        //
        class Levis extends AbstractJeans
        {

            public Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
                // TODO Auto-generated constructor stub
            }

            @Override
            public String getTM() {
                // TODO Auto-generated method stub
                return Company.Levis.name();
            }

        }
        //
        class Denim extends AbstractJeans
        {

            public Denim(int id, int length, int size, double price) {
                super(id, length, size, price);
                // TODO Auto-generated constructor stub
            }

            @Override
            public String getTM() {
                // TODO Auto-generated method stub
                return Company.Denim.name();
            }

        }
        class Colins extends AbstractJeans {

            public Colins(int id, int length, int size, double price) {
                super(id, length, size, price);
                // TODO Auto-generated constructor stub
            }

            @Override
            public String getTM() {
                // TODO Auto-generated method stub
                return Company.Colins.name();
            }

        }
        class CalvinKleinJeans extends AbstractJeans{

            public CalvinKleinJeans(int id, int length, int size, double price) {
                super(id, length, size, price);
                // TODO Auto-generated constructor stub
            }

            @Override
            public String getTM() {
                // TODO Auto-generated method stub
                return Company.CalvinKleinJeans.name();
            }

        }
        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
            if (Company.Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else {
                jeans = new AbstractJeans(id, length, size, price) {
                    public String getTM() {
                        return company.fullName;
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}
