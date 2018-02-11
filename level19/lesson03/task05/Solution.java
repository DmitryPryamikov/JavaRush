package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer mCustomer;
        private Contact mContact;
        //////
        public DataAdapter(Customer customer, Contact contact) {
            //
            mCustomer = customer;
            mContact = contact;
        }
        //////
        @Override
        public String getCountryCode() {
            String cName="";
            for (Map.Entry<String, String> pair : countries.entrySet())
            {
                if (mCustomer.getCountryName().equals(pair.getValue()))
                {
                    cName = pair.getKey();
                }
            }
            return cName;
        }
        @Override
        public String getCompany() {

            return mCustomer.getCompanyName();
        }
        @Override
        public String getContactFirstName() {
            String [] names = mContact.getName().split(",");
            String name = names[1];
            name = name.trim();
            return name;
        }
        @Override
        public String getContactLastName() {
            String [] names = mContact.getName().split(",");
            String name = names[0];
            name = name.trim();
            return name;
        }
        @Override
        public String getDialString() {
            String phone = mContact.getPhoneNumber();
            //
            StringBuilder builder = new  StringBuilder();
            //
            builder.append("callto://");
            for (int i = 0; i<phone.length();i++)
            {
                char c = phone.charAt(i);
                if ((c=='(')||(c==')')||(c=='-'))
                {

                }
                else
                {
                    builder.append(c);
                }

            }
            return builder.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}