package ru.ifmo.se.pult.commands;

import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class FilterLessThanNumberOfParticipantsCommand implements Command {
    App app;
    public FilterLessThanNumberOfParticipantsCommand(App app){
        this.app = app;
    }

    @Override
    public <Integer> void execute(Integer nop) {
        app.filterLessThanNumberOfParticipants((java.lang.Integer) nop);
    }
}