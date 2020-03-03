package ru.ifmo.se.pult;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Invoker
 * @author Gurin Minu
 * @version 0
 * @since 0
 */
public class Controller {
    private final HashMap<Pattern, Command> commandMap = new HashMap<>();
    Reader reader;
    private Command help;
    private Command info;
    private Command show;
    private Command add;
    private Command update;
    private Command removeById;
    private Command clear;
    private Command save;
    private Command executeScript;
    private Command exit;
    private Command removeGreater;
    private Command removeLower;
    private Command history;
    private Command maxByGenre;
    private Command filterLessThan;
    private Command printDescending;

    /**
     * Constructor Controller, который принимает команды
     */
    public Controller(Reader reader, Command help, Command info, Command show, Command add, Command updateId, Command removeById, Command clear, Command save, Command executeScript, Command exit, Command removeGreater, Command removeLower, Command history, Command maxByGenre, Command filterLessThan, Command printDescending) {
        this.reader =reader;
        this.help = help;
        this.info = info;
        this.show = show;
        this.add = add;
        this.update = updateId;
        this.removeById = removeById;
        this.clear = clear;
        this.save = save;
        this.executeScript = executeScript;
        this.exit = exit;
        this.removeGreater = removeGreater;
        this.removeLower = removeLower;
        this.history = history;
        this.maxByGenre = maxByGenre;
        this.filterLessThan = filterLessThan;
        this.printDescending = printDescending;
    }

    /**
     * Начинает принимать команды пользователя
     * @param inputStream Прием данных
     */
    public void start(InputStream inputStream) {
        boolean exitFlag = true;
        Scanner in = new Scanner(inputStream, "UTF-8");

        while (exitFlag && in.hasNextLine()) {

            CommandName command = reader.readCommand(in);

            switch (command) {
                case HELP:
                    help.execute("");
                    break;
                case INFO:
                    info.execute("");
                    break;
                case UPDATE:
                    update.execute(reader.readArgument());
                    break;
                case REMOVE_BY_ID:
                    removeById.execute(reader.readArgument());
                    break;
                case FILTER_LESS_THEN_NUMBER_OF_PARTICIPANTS:
                    filterLessThan.execute(reader.readArgument());
                    break;
                case ADD:
                    add.execute(reader.readCollectionObject(in));
                    break;
                case REMOVE_LOWER:
                    removeLower.execute("");
                    break;
                case REMOVE_GREATER:
                    removeGreater.execute("");
                    break;
                case EXECUTE_SCRIPT:
                    try {
                        InputStream fileInputStream = new FileInputStream(reader.readScriptName());
                        this.start(fileInputStream);
                        fileInputStream.close();
                    } catch (NoSuchElementException ex) {
                        System.out.println("Конец скрипта");
                    } catch (FileNotFoundException ex) {
                        System.out.println("Файл не найден");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case SHOW:
                    show.execute("");
                    break;
                case CLEAR:
                    clear.execute("");
                    break;
                case SAVE:
                    save.execute("");
                    break;
                case EXIT:
                    exit.execute("");
                    exitFlag = false;
                    break;
                case HISTORY:
                    history.execute("");
                    break;
                case MAX_BY_GENRE:
                    maxByGenre.execute("");
                    break;
                case PRINT_DESCENDING:
                    printDescending.execute("");
                    break;
                case ERROR:
                    System.out.println("Неправильный ввод");
                    break;

            }
        }
    }
}
