package com.javarush.test.level14.lesson06.home01;

class BelarusianHen extends Hen
{
String mCountry;

public BelarusianHen (String country)
		{
		mCountry = country;
		}
	int getCountOfEggsPerMonth(){
		return 10;
	}
	//
	String getDescription()
	{
		//System.out.println(super.getDescription() +" Моя страна - "+mCountry+". Я несу "+ getCountOfEggsPerMonth()+" яиц в месяц.");
	  return super.getDescription() +" Моя страна - "+mCountry+". Я несу "+ getCountOfEggsPerMonth()+" яиц в месяц.";
	}
}