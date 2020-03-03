package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class RemoveByIdCommand implements Command {
    Collection collection;
    public RemoveByIdCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public <Integer> void execute(Integer id) {
        collection.removeById((java.lang.Integer) id);
    }
}
