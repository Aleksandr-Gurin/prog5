package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;
import ru.ifmo.se.pult.FileManager;

public class SaveCommand implements Command {
    App app;
    public SaveCommand(App app){
        this.app = app;
    }

    @Override
    public void execute(Object object) {
        app.saveFile();
    }
}
