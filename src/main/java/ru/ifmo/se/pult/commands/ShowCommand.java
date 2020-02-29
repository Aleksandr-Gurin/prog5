package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class ShowCommand implements Command {
    App app;
    public ShowCommand(App app){
        this.app = app;
    }

    @Override
    public <T> void execute(T data) {
        app.show();
    }
}
