package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class RemoveByIdCommand implements Command {
    App app;
    public RemoveByIdCommand(App app){
        this.app = app;
    }

    @Override
    public <Integer> void execute(Integer id) {
        app.removeById((java.lang.Integer) id);
    }
}
