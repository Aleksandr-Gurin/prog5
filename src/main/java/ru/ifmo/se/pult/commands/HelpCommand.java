package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class HelpCommand implements Command {
    App app;
    public HelpCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Object object) {
        app.help();
    }
}
