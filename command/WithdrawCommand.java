package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

/**
 * Created by hanaria on 4/28/17.
 */
class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int moneyToTake;

        while(true)
        {
            try
            {
                ConsoleHelper.writeMessage("Count money you want");
                moneyToTake = Integer.parseInt(ConsoleHelper.readString());
            }
            catch (NumberFormatException e){
                ConsoleHelper.writeMessage("Money number format exception");
                continue;
            }
            if(moneyToTake <= 0){
                ConsoleHelper.writeMessage("Enter not empty value");
                continue;
            }
            if(!currencyManipulator.isAmountAvailable(moneyToTake))
            {
                ConsoleHelper.writeMessage("Not enough money");
            }
            try
            {
                currencyManipulator.withdrawAmount(moneyToTake);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("exact amount not available");
                continue;
            }
            break;
        }
   }
}