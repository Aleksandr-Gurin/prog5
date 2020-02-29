package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.*;

import java.io.*;
import java.util.*;

/**
 * Receiver
 * Хранит исполнения команд
 */
public class App {
    private Collection collection;
    private List<String> history = new ArrayList<>();

    /**
     * Constructor App
     * @param collection Класс, управляющий коллекцией
     */
    public App(Collection collection) {
        this.collection = collection;
    }

    /**
     * Выводит справку по доступным командам
     */
    public void help() {
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "history : вывести последние 5 команд (без их аргументов)\n" +
                "max_by_genre : вывести любой объект из коллекции, значение поля genre которого является максимальным\n" +
                "filter_less_than_number_of_participants numberOfParticipants : вывести элементы, значение поля numberOfParticipants которых меньше заданного\n" +
                "print_descending : вывести элементы коллекции в порядке убывания");
        history.add("help");
    }

    /**
     * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     */
    public void info() {
        System.out.println("Тип: " + collection.getCollection().getClass() + "\nДата инициализации: " + collection.getInitDate() + "\nКоличество элементов: " + collection.getCollection().size());
        history.add("info");
    }

    /**
     * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
     */
    public void show() {
        for (MusicBand musicBand: collection.getCollection()){
            System.out.println(musicBand.toString());
        }
        history.add("show");
    }

    /**
     * Добавляет новый элемент в коллекцию
     * @param musicBand добавляемый элемент
     */
    public void add(MusicBand musicBand) {
        collection.add(musicBand);
        history.add("add");
    }

    /**
     * Обновляет значение элемента коллекции, id которого равен заданному
     * @param ip id элемента
     */
    public void updateId(Integer ip) {
        boolean flag = true;
        for (MusicBand musicBand : collection.getCollection()) {
            if (musicBand.getId() == ip) {
                collection.update(ip, Reader.readCollectionObject(new Scanner(System.in)));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Неправильно введен ip, повторите команду:");
        }
        history.add("update");
    }

    /**
     * Удаляет элемент из коллекции по его id
     * @param id id, удаляемого элемента
     */
    public void removeById(Integer id) {
        collection.remove(id);
        history.add("remove_by_id");
    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        collection.clear();
        System.out.println("Коллекция очищена");
        history.add("clear");
    }

    /**
     * Сохраняет коллекцию в файл
     */
    public void save() {
        FileManager.saveFile(collection.getCollection());
        history.add("save");
    }

    /**
     * Считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
     */
    public void executeScript() {
        BufferedInputStream in1 = null;
        try {
            in1 = new BufferedInputStream(new FileInputStream("C:\\lesson\\prog\\prog5\\src\\main\\java\\ru\\ifmo\\se\\script"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(in1);
    }

    /**
     * Удаляет из коллекции все элементы, меньшие, чем заданный
     */
    public void removeGreater() {
        collection.removeGreater(Reader.readCollectionObject(new Scanner(System.in)));
        history.add("remove_greater");
    }

    /**
     * Удаляет из коллекции все элементы, меньшие, чем заданный
     */
    public void removeLower() {
        collection.removeLower(Reader.readCollectionObject(new Scanner(System.in)));
        history.add("remove_lower");
    }

    /**
     * Выводит последние 5 команд (без их аргументов)
     */
    public void history() {
        if (history.size() < 5) {
            for (String command : history) {
                System.out.println(command);
            }
        } else {
            for (int i = history.size() - 5; i < history.size(); i++) {
                System.out.println(history.get(i));
            }
        }
        history.add("history");
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

        if (collection.getCollection().size() > 0) {
            for (MusicBand musicBand : collection.getCollection()) {
                if (musicBand.getGenre().compareTo(musicGenre) > 0) {
                    musicGenre = musicBand.getGenre();
                    mb = musicBand;
                }
            }
        }
        System.out.println(mb);
        history.add("max_by_genre");
    }

    /**
     * Выводит элементы, значение поля numberOfParticipants которых меньше заданного
     * @param nop numberOfParticipants
     */
    public void filterLessThanNumberOfParticipants(int nop) {
        for (MusicBand musicBand : collection.getCollection()) {
            if (musicBand.getNumberOfParticipants() < nop) {
                System.out.println(musicBand.toString());
            }
        }
        history.add("filter_less_than_number_of_participants");
    }

    /**
     * Выводит элементы коллекции в порядке убывания
     */
    public void printDescending() {
        MusicBand mb = null;
        ArrayList<MusicBand> musicBands = new ArrayList<>();

        if (collection.getCollection().size() > 0){
            for (int i = 0; i < collection.getCollection().size(); i++) {
                for (MusicBand musicBand : collection.getCollection()) {
                    if (musicBand.compareTo(mb) >= 0 && !musicBands.contains(musicBand)) {
                        mb = musicBand;
                    }
                }
                musicBands.add(mb);
                System.out.println(mb.toString());
            }
        }
        else {
            System.out.println("В коллекции нет элементов");
        }
        history.add("print_descending");
    }

    /**
     * Завершает программу (без сохранения в файл)
     */
    public void exit() {
    }
}
