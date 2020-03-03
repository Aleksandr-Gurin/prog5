package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class InfoCommand implements Command {
    Collection collection;
    public InfoCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public <Object> void execute(Object data) {
        collection.info();
    }
}
