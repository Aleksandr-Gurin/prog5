package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Collection;
import ru.ifmo.se.pult.Command;

public class FilterLessThanNumberOfParticipantsCommand implements Command<Integer> {
    Collection collection;
    public FilterLessThanNumberOfParticipantsCommand(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(Integer nop) {
        collection.filterLessThanNumberOfParticipants(nop);
    }
}