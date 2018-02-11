package com.javarush.test.level14.lesson06.home01;

class RussianHen extends Hen
{
	String mCountry;

	public RussianHen (String country)
	{
		mCountry = country;
	}
	int getCountOfEggsPerMonth(){
		return 10;
	}
	//
	String getDescription()
	{
		return super.getDescription() +" Моя страна - "+mCountry+". Я несу "+ getCountOfEggsPerMonth()+" яиц в месяц.";
	}

}