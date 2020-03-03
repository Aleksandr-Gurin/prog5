package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class FilterLessThanNumberOfParticipantsCommand implements Command {
    Collection collection;
    public FilterLessThanNumberOfParticipantsCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public <Integer> void execute(Integer nop) {
        collection.filterLessThanNumberOfParticipants((java.lang.Integer) nop);
    }
}