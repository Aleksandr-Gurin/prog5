package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class ExecuteScriptCommand implements Command {
    App app;
    public ExecuteScriptCommand(App app){
        this.app = app;
    }

    @Override
    public <T> void execute(T data) {

    }
}
