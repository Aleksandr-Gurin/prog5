package ru.ifmo.se;
import ru.ifmo.se.pult.*;
import ru.ifmo.se.pult.commands.*;


import java.nio.channels.ShutdownChannelGroupException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Main class
 * @author Gurin Minu
 * @version 0
 * @since 0
 */
public class Main {
    public static void main(String[] args) throws Exception{
        try {
            Reader reader = new Reader();
            FileManager fileManager = new FileManager();
            Collection collection = new Collection(fileManager.readFile(Reader.readFile(new Scanner(System.in, "UTF-8"))), reader);
            App app = new App(reader, collection, fileManager);
            Controller controller = new Controller(reader, new HelpCommand(app), new InfoCommand(collection), new ShowCommand(collection), new AddCommand(collection), new UpdateIdCommand(app), new RemoveByIdCommand(collection), new ClearCommand(collection), new SaveCommand(app), new ExecuteScriptCommand(app), new ExitCommand(app), new RemoveGreaterCommand(collection), new RemoveLowerCommand(collection), new HistoryCommand(app), new MaxByGenreCommand(collection), new FilterLessThanNumberOfParticipantsCommand(collection), new PrintDescendingCommand(collection));
            controller.start(System.in);
        }
        catch (NoSuchElementException e){
            System.out.println("Программа заверещена");
        }
    }
}
