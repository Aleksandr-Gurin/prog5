package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class ClearCommand implements Command {
    Collection collection;
    public ClearCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public <T> void execute(T data) {
        collection.clear();
    }
}
