package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String login = "", password = "";
        while(true){
            ConsoleHelper.writeMessage("Please enter login: ");
            login = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Please enter password: ");
            password = ConsoleHelper.readString();
            if(login.length() == 12 && password.length() == 4)
            {
                if(login.equals("123456789012") && password.equals("1234")){
                    ConsoleHelper.writeMessage("Login success!");
                    break;
                }
                else ConsoleHelper.writeMessage("Invalid data");

            }
            else ConsoleHelper.writeMessage("login =12 & password = 4");
        }
    }
}