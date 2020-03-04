package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class RemoveByIdCommand implements Command<Integer> {
    Collection collection;
    public RemoveByIdCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Integer id) {
        collection.removeById(id);
    }
}
