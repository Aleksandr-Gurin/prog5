package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.MusicBand;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * Класс, управляющий коллекцией
 */
public class Collection {
    private LinkedHashSet<MusicBand> musicBands;

    private Date initDate = new Date();

    /**
     * Constructor collection
     * @param musicBands Коллекция, которой управляет класс
     */
    public Collection(LinkedHashSet<MusicBand> musicBands) {
        this.musicBands = musicBands;
    }

    /**
     * Добавляет элемент в коллекцию
     * @param musicBand Добавляемый элемент
     */
    public void add(MusicBand musicBand) {
        musicBands.add(musicBand);
    }

    /**
     * Обновляет значения элемента в коллекции
     * @param id id, обновляемого элемента
     * @param mb Объект, который содержит значения, кторые должен принять обновляемый элемент
     */
    public void update(int id, MusicBand mb) {
        for(MusicBand musicBand: musicBands){
            if (musicBand.getId() == id) {
                musicBand.setNumberOfParticipants(mb.getNumberOfParticipants());
                musicBand.setName(mb.getName());
                musicBand.setGenre(mb.getGenre());
                musicBand.setFrontMan(mb.getFrontMan());
                musicBand.setEstablishmentDate(mb.getEstablishmentDate());
                musicBand.setCoordinates(mb.getCoordinates());
            }
        }
    }

    /**
     * Удаляет элемент коллекции
     * @param id id, удаляемого элемента
     */
    public void remove(int id) {
        MusicBand musicBand = null;
        boolean flag = true;
        for (MusicBand mb : musicBands) {
            if (mb.getId() == id) {
                musicBand = mb;
                flag = false;
            }
        }
        if (!flag){
            musicBands.remove(musicBand);
        }
        if (flag) {
            System.out.println("id не найден, повторите команду");
        }
    }

    /**
     * Удаляет элементы коллекции, которые больше данного
     * @param musicBand Объект, с которым сравниваются элементы коллекции
     */
    public void removeGreater(MusicBand musicBand){
        ArrayList<MusicBand> deleted = new ArrayList<>();
        for (MusicBand mb : musicBands) {
            if (mb.compareTo(musicBand) > 0) {
                deleted.add(musicBand);
            }
        }
        if(musicBands.size() > 0) {
            for (MusicBand mb: deleted){
                musicBands.remove(mb);
            }
        }
    }

    /**
     * Удаляет элементы коллекции, которые меньше данного
     * @param musicBand Объект, с которым сравниваются элементы коллекции
     */
    public void removeLower(MusicBand musicBand) {
        ArrayList<MusicBand> deleted = new ArrayList<>();
        for (MusicBand mb : musicBands) {
            if (mb.compareTo(musicBand) < 0) {
                deleted.add(musicBand);
            }
        }
        if(musicBands.size() > 0) {
            for (MusicBand mb: deleted){
                musicBands.remove(mb);
            }
        }
    }

    /**
     * Удаляет все элементы коллекции
     */
    public void clear() {
        musicBands.clear();
    }

    /**
     * Возвращает дату инициализации коллекции
     * @return Date
     */
    public Date getInitDate() {
        return initDate;
    }

    /**
     * Возвращает коллекцию
     * @return LinkedHashSet
     */
    public LinkedHashSet<MusicBand> getCollection(){
        return musicBands;
    }
}
