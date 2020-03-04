package ru.ifmo.se.pult.commands;

import ru.ifmo.se.musicians.MusicBand;
import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class RemoveGreaterCommand implements Command<MusicBand> {
    Collection collection;
    public RemoveGreaterCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(MusicBand musicBand) {
        collection.removeGreater(musicBand);
    }
}
