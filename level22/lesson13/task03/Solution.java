package com.javarush.test.level22.lesson13.task03;

public class Solution {
	/* Проверка номера телефона
	Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
	Критерии валидности:
	1) если номер начинается с '+', то он содержит 12 цифр
	2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
	3) может содержать 0-2 знаков '-', которые не могут идти подряд
	4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
	5) скобки внутри содержат четко 3 цифры
	6) номер не содержит букв
	7) номер заканчивается на цифру

	Примеры:
	+380501234567 - true
	+38(050)1234567 - true
	+38050123-45-67 - true
	050123-4567 - true

	+38)050(1234567 - false
	+38(050)1-23-45-6-7 - false
	050ххх4567 - false
	050123456 - false
	(0)501234567 - false
	*/
/*
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //38xx501A34567 false
        System.out.println("38xx501A34567 "+checkTelNumber("38xx501A34567"));
        //3805012345 true
        System.out.println("3805012345 "+checkTelNumber("3805012345"));
        //+380501234567 true
        System.out.println("+380501234567 "+checkTelNumber("+380501234567"));
        //++380501234567 false
        System.out.println("++380501234567 "+checkTelNumber("++380501234567"));
        //+38(0501234567 false
        System.out.println("+38(0501234567 "+checkTelNumber("+38(0501234567"));
        //+38)050(1234567 false
        System.out.println("+38)050(1234567 "+checkTelNumber("+38)050(1234567"));
        //+38(050)1234567 true
        System.out.println("+38(050)1234567 "+checkTelNumber("+38(050)1234567"));
        //+38(05)1234567 false
        System.out.println("+38(05)1234567 "+checkTelNumber("+38(05)1234567"));
        //(3)80501234567 false
        System.out.println("(3)80501234567 "+checkTelNumber("(3)80501234567"));
        //(380)501234567 false
        System.out.println("(380)501234567 "+checkTelNumber("(380)501234567"));
        //380-50123-45 true
        System.out.println("380-50123-45 "+checkTelNumber("380-50123-45"));
        //(380)501-234567 false
        System.out.println("(380)501-234567 "+checkTelNumber("(380)501-234567"));
        //(38-0)501234567 false
        System.out.println("(38-0)501234567 "+checkTelNumber("(38-0)501234567"));
        //380-(501)234567 false
        System.out.println("380-(501)234567 "+checkTelNumber("380-(501)234567"));
        //380(50-1)234567 false
        System.out.println("380(50-1)234567 "+checkTelNumber("380(50-1)234567"));
        //380(501)(23)4567 false
        System.out.println("380(501)(23)4567 "+checkTelNumber("380(501)(23)4567"));
        //+38050123(456)7 true
        System.out.println("+38050123(456)7 "+checkTelNumber("+38050123(456)7"));
        //+380501234(567) false
        System.out.println("+380501234(567) "+checkTelNumber("+380501234(567)"));
        //3-805-0123-45 false
        System.out.println("3-805-0123-45 "+checkTelNumber("3-805-0123-45"));
        //-3805-012345 false
        System.out.println("-3805-012345 "+checkTelNumber("-3805-012345"));
        //3805-012345- false
        System.out.println("3805-012345- "+checkTelNumber("3805-012345-"));
        // +380501234567 true
        System.out.println("+380501234567 "+checkTelNumber("+380501234567"));
        // +38(050)1234567 true
        System.out.println("+38(050)1234567 "+checkTelNumber("+38(050)1234567"));
        //+38(05)01234567 false
        System.out.println("+38(05)01234567 "+checkTelNumber("+38(05)01234567"));
        //+38(0501)234567 false
        System.out.println("+38(0501)234567 "+checkTelNumber("+38(0501)234567"));
        //+38050123-45-67 true
        System.out.println("+38050123-45-67 "+checkTelNumber("+38050123-45-67"));
        //050123-4567 true
        System.out.println("050123-4567 "+checkTelNumber("050123-4567"));
        //+38)050(1234567 false
        System.out.println("+38)050(1234567 "+checkTelNumber("+38)050(1234567"));
        //+38(050)1-23-45-6-7 false
        System.out.println("+38(050)1-23-45-6-7 "+checkTelNumber("+38(050)1-23-45-6-7"));
        //050ххх4567 false
        System.out.println("050ххх4567 "+checkTelNumber("050ххх4567"));
        //050123456 false
        System.out.println("050123456 "+checkTelNumber("050123456"));
        //050123456 false
        System.out.println("050123456 "+checkTelNumber("050123456"));
        //+38-(050)1234567 false
        System.out.println("+38-(050)1234567 "+checkTelNumber("+38-(050)1234567"));
        //+5(0--5)1234567 false
        System.out.println("+5(0--5)1234567 "+checkTelNumber("+5(0--5)1234567"));
        //7-4-4123689-5 false
        System.out.println("7-4-4123689-5 "+checkTelNumber("7-4-4123689-5"));
        //1-23456789-0 true
        System.out.println("1-23456789-0 "+checkTelNumber("1-23456789-0"));
        //+38051202(345)7 true
        System.out.println("+38051202(345)7 "+checkTelNumber("+38051202(345)7"));
        //+38051202(345)-7 true
        System.out.println("+38051202(345)-7 "+checkTelNumber("+38051202(345)-7"));
        //+-313450531202 true
        System.out.println("+-313450531202 "+checkTelNumber("+-313450531202"));
        //+313450--531202 false
        System.out.println("+313450--531202 "+checkTelNumber("+313450--531202"));





        //

    }
    //*/
    public static boolean checkTelNumber(String telNumber) {
        return ((telNumber.matches("^\\+[\\(\\-]?(\\d[\\(\\)\\-]?){11}\\d$") || telNumber.matches("^\\(?(\\d[\\-\\(\\)]?){9}\\d$"))
                && telNumber.matches("[\\+]?\\d*(\\(\\d{3}\\))?\\d*\\-?\\d*\\-?\\d*\\d$"));
    }


}