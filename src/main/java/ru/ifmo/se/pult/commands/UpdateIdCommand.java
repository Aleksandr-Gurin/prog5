package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class UpdateIdCommand implements Command {
    App app;
    public UpdateIdCommand(App app){
        this.app = app;
    }

    @Override
    public <Integer> void execute(Integer ip) {
        app.updateId((java.lang.Integer) ip);
    }
}
