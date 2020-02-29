package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class InfoCommand implements Command {
    App app;
    public InfoCommand(App app){
        this.app = app;
    }

    @Override
    public <Object> void execute(Object data) {
        app.info();
    }
}
