package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class PrintDescendingCommand implements Command {
    Collection collection;
    public PrintDescendingCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Object object) {
        collection.printDescending();
    }
}