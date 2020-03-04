package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class UpdateIdCommand implements Command<Integer> {
    App app;
    public UpdateIdCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Integer ip) {
        app.updateId(ip);
    }
}
