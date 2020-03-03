package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class ShowCommand implements Command {
    Collection collection;
    public ShowCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public <T> void execute(T data) {
        collection.show();
    }
}
