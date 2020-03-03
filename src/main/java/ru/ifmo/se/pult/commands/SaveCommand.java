package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;
import ru.ifmo.se.pult.FileManager;

public class SaveCommand implements Command {
    FileManager fileManager;
    public SaveCommand(FileManager fileManager){
        this.fileManager = fileManager;
    }

    @Override
    public <T> void execute(T data) {
        fileManager.saveFile();
    }
}
