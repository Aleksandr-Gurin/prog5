package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.MusicBand;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

public class Collection {
    private LinkedHashSet<MusicBand> musicBands;

    private Date initDate = new Date();

    public Collection(LinkedHashSet<MusicBand> musicBands) {
        this.musicBands = musicBands;
    }

    public void add(MusicBand musicBand) {
        musicBands.add(musicBand);
    }

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

    public void clear() {
        musicBands.clear();
    }

    public Date getInitDate() {
        return initDate;
    }

    public LinkedHashSet<MusicBand> getCollection(){
        return musicBands;
    }
}
