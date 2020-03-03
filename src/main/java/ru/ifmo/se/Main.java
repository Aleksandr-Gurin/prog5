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
            FileManager fileManager = new FileManager();
            Reader reader = new Reader();
            Collection collection = new Collection(fileManager.readFile(Reader.readFile(new Scanner(System.in, "UTF-8"))));
            App app = new App(reader, collection, fileManager);
            Controller controller = new Controller(reader, new HelpCommand(app), new InfoCommand(app), new ShowCommand(app), new AddCommand(app), new UpdateIdCommand(app), new RemoveByIdCommand(app), new ClearCommand(app), new SaveCommand(app), new ExecuteScriptCommand(app), new ExitCommand(app), new RemoveGreaterCommand(app), new RemoveLowerCommand(app), new HistoryCommand(app), new MaxByGenreCommand(app), new FilterLessThanNumberOfParticipantsCommand(app), new PrintDescendingCommand(app));
            controller.start(System.in);
        }
        catch (NoSuchElementException e){
            System.out.println("Программа заверещена");
        }
    }
}
