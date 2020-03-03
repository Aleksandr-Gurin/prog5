package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.MusicBand;
import ru.ifmo.se.musicians.MusicGenre;

import java.util.*;

/**
 * Класс, управляющий коллекцией
 */
public class Collection {
    private LinkedHashSet<MusicBand> musicBands;
    Reader reader;
    App app;

    private Date initDate = new Date();

    /**
     * Constructor collection
     * @param musicBands Коллекция, которой управляет класс
     */
    public Collection(LinkedHashSet<MusicBand> musicBands, Reader reader) {
        this.musicBands = musicBands;
        this.reader = reader;
    }

    /**
     * Добавляет новый элемент в коллекцию
     * @param musicBand добавляемый элемент
     */
    public void add(MusicBand musicBand) {
        musicBands.add(musicBand);
        System.out.println("Объект добавлен в коллекцию");
        app.pushHistory("add");
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
        System.out.println("Объекты удалены");
        app.pushHistory("remove_greater");
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
        System.out.println("Объекты удалены");
        app.pushHistory("remove_lower");
    }

    /**
     * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
     */
    public void show() {
        for (MusicBand musicBand: musicBands){
            System.out.println(musicBand.toString());
        }
        app.pushHistory("show");
    }

    /**
     * Возвращает дату инициализации коллекции
     * @return Date
     */
    public Date getInitDate() {
        return initDate;
    }

    /**
     * Выводит элементы в обратном порядке
     */
    public void printDescending() {
        ArrayList<MusicBand> musicBandArrayList = new ArrayList<>(musicBands);
        Collections.sort(musicBandArrayList, (MusicBand mb1,MusicBand mb2) -> {
            if (mb1.compareTo(mb2) < 0) return 1;
            else if(mb1.compareTo(mb2) > 0) return -1;
            else return 0;
        });
        for (MusicBand musicBand: musicBandArrayList) System.out.println(musicBand.toString());
        app.pushHistory("print_descending");
    }

    /**
     * Возвращает коллекцию
     * @return LinkedHashSet
     */
    public LinkedHashSet<MusicBand> getCollection(){
        return musicBands;
    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        musicBands.clear();
        System.out.println("Коллекция очищена");
        app.pushHistory("clear");
    }

    /**
     * Возвращает элементы, значение поля numberOfParticipants которых меньше заданного
     * @param nop numberOfParticipants
     */
    public void filterLessThanNumberOfParticipants(int nop) {
        for (MusicBand musicBand : musicBands) {
            if (musicBand.getNumberOfParticipants() < nop) {
                System.out.println(musicBand.toString());
            }
        }
        app.pushHistory("filter_less_than_number_of_participants");
    }

    /**
     * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     */
    public void info() {
        System.out.println("Тип: " + musicBands.getClass() + "\nДата инициализации: " + getInitDate() + "\nКоличество элементов: " + musicBands.size());
        app.pushHistory("info");
    }

    /**
     * Удаляет элемент из коллекции по его id
     * @param id id, удаляемого элемента
     */
    public void removeById(Integer id) {
        musicBands.remove(id);
        System.out.println("Объект удален");
        app.pushHistory("remove_by_id");
    }

    /**
     * Выводит любой объект из коллекции, значение поля genre которого является максимальным
     */
    public void maxByGenre() {
        MusicGenre musicGenre = MusicGenre.BLUES;
        for (MusicGenre mg : MusicGenre.values()) {
            if (musicGenre.compareTo(mg) > 0) {
                musicGenre = mg;
            }
        }
        MusicBand mb = null;

        if (musicBands.size() > 0) {
            for (MusicBand musicBand : musicBands) {
                if (musicBand.getGenre().compareTo(musicGenre) > 0) {
                    musicGenre = musicBand.getGenre();
                    mb = musicBand;
                }
            }
        }
        System.out.println(mb);
        app.pushHistory("max_by_genre");
    }
}
