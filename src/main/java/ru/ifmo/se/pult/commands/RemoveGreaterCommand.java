package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class RemoveGreaterCommand implements Command {
    Collection collection;
    public RemoveGreaterCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public <MusicBand> void execute(MusicBand musicBand) {
        collection.removeGreater((ru.ifmo.se.musicians.MusicBand) musicBand);
    }
}
