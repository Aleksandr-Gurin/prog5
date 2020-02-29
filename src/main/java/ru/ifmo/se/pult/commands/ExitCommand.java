package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class ExitCommand implements Command {
    App app;
    public ExitCommand(App app){
        this.app = app;
    }

    @Override
    public <T> void execute(T data) {
        app.exit();
    }
}
