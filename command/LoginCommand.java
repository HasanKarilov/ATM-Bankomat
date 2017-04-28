package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources." + "verifiedCards", Locale.ENGLISH);
    private String card, pin;

    @Override
    public void execute() throws InterruptOperationException
    {
        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage("Input credit card number");
                card = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("Input credit card pin code");
                pin = ConsoleHelper.readString();
            }
            catch (IllegalArgumentException e){

            }

            if(validCreditCards.containsKey(card))
            {
                if(validCreditCards.getString(card).equals(pin))
                {
                    ConsoleHelper.writeMessage("Verification success!");
                    break;
                }
            }
            ConsoleHelper.writeMessage("Invalid card values");
        }
    }
}