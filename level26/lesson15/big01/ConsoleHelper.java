package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


/**
 * Created by DimaMarina on 12.12.2016.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //
    public static void writeMessage(String message)
    {
        System.out.println(message);

    }
    //
    public static String readString() throws InterruptOperationException
    {
        String s = "";
        try
        {
            s= reader.readLine();
            if (s.equalsIgnoreCase(res.getString("operation.EXIT")))
                throw  new InterruptOperationException();
        }
        catch (IOException e){}
        return  s;
    }
    //
    public static String askCurrencyCode() throws InterruptOperationException
    {
        String message="";

        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {

                       message = readString();
                if (message.length()==3)
                {
                   break;
                }
                else
                {
                    writeMessage(res.getString("invalid.data"));
                }

            }
        message = message.toUpperCase();



        return  message;

    }
    //--------------------------------------------
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String [] array;
        //
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true)
        {
            String message = readString();
            array = message.split(" ");
            int nominal;
            int quantity;
            try
            {
                nominal = Integer.parseInt(array[0]);
                quantity = Integer.parseInt(array[1]);

            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (nominal<=0||quantity<=0||array.length>2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;

        }

        return array;
    }
    //----------------------------------
    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            writeMessage("Введите номер операции");
            String s = readString();
            int result = 0;
            //
            try
            {
                result = Integer.parseInt(s);
                Operation op = Operation.getAllowableOperationByOrdinal(result);
                return op;
            }
            catch (IllegalArgumentException e)
            {
                writeMessage("invalid data");
            }

        }
    }
    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
