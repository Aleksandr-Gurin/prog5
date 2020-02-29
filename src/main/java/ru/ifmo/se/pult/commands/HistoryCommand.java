package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class HistoryCommand implements Command {
    App app;
    public HistoryCommand(App app){
        this.app = app;
    }

    @Override
    public <T> void execute(T data) {
        app.history();
    }
}
