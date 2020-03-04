package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;
import ru.ifmo.se.pult.CommandName;

import java.util.ArrayList;

public class HistoryCommand implements Command<ArrayList<CommandName>> {
    App app;
    public HistoryCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(ArrayList<CommandName> history) {
        app.history(history);
    }
}
