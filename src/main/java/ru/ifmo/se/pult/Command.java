package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.MusicBand;

public interface Command {
    <T> void execute(T data);
}
