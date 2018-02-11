package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DimaMarina on 14.01.2017.
 */
public final class CommandExecutor
{
   private static Map<Operation, Command> method = new HashMap<Operation, Command>();
   static{
       method.put(Operation.INFO, new InfoCommand());
       method.put(Operation.DEPOSIT, new DepositCommand());
       method.put(Operation.WITHDRAW, new WithdrawCommand());
       method.put(Operation.EXIT, new ExitCommand());
       method.put(Operation.LOGIN, new LoginCommand());
   }
    //
    public static final void execute(Operation operation) throws InterruptOperationException
    {
        if (method.containsKey(operation))
        method.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
