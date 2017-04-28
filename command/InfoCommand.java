package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class InfoCommand implements Command {
    @Override
    public void execute() {
        boolean isEmpty = false;
        for(CurrencyManipulator currencyManipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {

            if (currencyManipulator.hasMoney()){
                if (currencyManipulator.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                    isEmpty = true;
                }
            }
        }
        if(!isEmpty){
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}