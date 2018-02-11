package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by DimaMarina on 15.01.2017.
 */
public class LoginCommand implements Command
{

    String cardNumber, cardPinNumber;
    private ResourceBundle validCreditCards =  ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res =  ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
            while (true)
            {
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                cardNumber = ConsoleHelper.readString();
                cardPinNumber = ConsoleHelper.readString();
                if (inputDataValid(cardNumber, cardPinNumber))
                {
                    if (cardIsVerified(cardNumber, cardPinNumber)) break;
                    else
                    {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));

    }

    private boolean inputDataValid(String cardNumber, String pinNumber)
    {
        return cardNumber != null && pinNumber != null && cardNumber.length() == 12 && pinNumber.length() == 4;
    }

    private boolean cardIsVerified(String cn, String pn)
    {
        return validCreditCards.containsKey(cn) && pn.equals(validCreditCards.getString(cn));
    }
}


