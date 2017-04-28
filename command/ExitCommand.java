package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Do yout want to exit <y, n>");
        if(ConsoleHelper.readString().equals("y")){
            ConsoleHelper.writeMessage("Good buy!");
        }
    }
}