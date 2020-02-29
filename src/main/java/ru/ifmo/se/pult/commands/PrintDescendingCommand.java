package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class PrintDescendingCommand implements Command {
    App app;
    public PrintDescendingCommand(App app){
        this.app = app;
    }

    @Override
    public <T> void execute(T data) {
        app.printDescending();
    }
}