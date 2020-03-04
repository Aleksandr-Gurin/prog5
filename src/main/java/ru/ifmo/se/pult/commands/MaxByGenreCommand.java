package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class MaxByGenreCommand implements Command {
    Collection collection;
    public MaxByGenreCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Object object) {
        collection.maxByGenre();
    }
}
