package ru.ifmo.se.pult.commands;

import ru.ifmo.se.musicians.MusicBand;
import ru.ifmo.se.pult.App;
import ru.ifmo.se.pult.Command;

public class AddCommand implements Command {
    App app;
    public AddCommand(App app){
        this.app = app;
    }

    @Override
    public <MusicBand> void execute(MusicBand musicBand) {
        app.add((ru.ifmo.se.musicians.MusicBand) musicBand);
    }
}
