package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.*;

import java.io.*;
import java.util.*;

/**
 * Receiver
 * Хранит исполнения команд
 */
public class App {
    Reader reader;
    private Collection collection;
    private FileManager fileManager;

    /**
     * Constructor App
     * @param collection Класс, управляющий коллекцией
     */
    public App(Reader reader, Collection collection, FileManager fileManager) {
        this.reader = reader;
        this.fileManager = fileManager;
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
    }

    public void saveFile(){
        fileManager.saveFile(collection);
    }

    /**
     * Обновляет значение элемента коллекции, id которого равен заданному
     * @param ip id элемента
     */
    public void updateId(Integer ip) {
        boolean flag = true;
        for (MusicBand musicBand : collection.getCollection()) {
            if (musicBand.getId() == ip) {
                collection.update(ip, reader.readCollectionObject(new Scanner(System.in, "UTF-8")));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Неправильно введен ip, повторите команду:");
        }
        System.out.println("Объект обновлен");
    }

    /**
     * Считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
     */
    public void executeScript() {}

    /**
     * Удаляет из коллекции все элементы, меньшие, чем заданный
     */
    public void removeLower() {
        collection.removeLower(reader.readCollectionObject(new Scanner(System.in, "UTF-8")));
        System.out.println("Объекты удалены");
    }

    /**
     * Выводит последние 5 команд (без их аргументов)
     */
    public void history(ArrayList<Command> history) {
        if (history.size() < 5) {
            for (Command command : history) {
                System.out.println(command.toString());
            }
        } else {
            for (int i = history.size() - 5; i < history.size(); i++) {
                System.out.println(history.get(i).toString());
            }
        }
    }

    /**
     * Завершает программу (без сохранения в файл)
     */
    public void exit() {
    }
}
