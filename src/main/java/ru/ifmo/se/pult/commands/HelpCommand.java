package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class HelpCommand implements Command {
    App app;
    public HelpCommand(App app){
        this.app = app;
    }

    @Override
    public <Object> void execute(Object bool) {
        app.help();
    }
}
