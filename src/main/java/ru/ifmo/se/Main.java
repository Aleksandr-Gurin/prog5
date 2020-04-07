package ru.ifmo.se;
import ru.ifmo.se.pult.*;
import ru.ifmo.se.pult.commands.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Main class
 * @author Gurin Minu
 * @version 0
 * @since 0
 */
public class Main {
    public static void main(String[] args) throws Exception{
        try {
            if (args.length == 1) {
                Reader reader = new Reader();
                FileManager fileManager = new FileManager();
                Collection collection = new Collection(fileManager.readFile(Reader.readFile(args[0])), reader);
                App app = new App(reader, collection, fileManager);
                Controller controller = new Controller(reader, new HelpCommand(app), new InfoCommand(collection), new ShowCommand(collection), new AddCommand(collection), new UpdateIdCommand(app), new RemoveByIdCommand(collection), new ClearCommand(collection), new SaveCommand(app), new ExecuteScriptCommand(app), new ExitCommand(app), new RemoveGreaterCommand(collection), new RemoveLowerCommand(collection), new HistoryCommand(app), new MaxByGenreCommand(collection), new FilterLessThanNumberOfParticipantsCommand(collection), new PrintDescendingCommand(collection));
                controller.start(System.in);
            }
            else {
                System.out.println("Неправильный путь");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("Программа заверещена");
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
