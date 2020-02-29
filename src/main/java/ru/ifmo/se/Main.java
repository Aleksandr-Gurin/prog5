package ru.ifmo.se;
import ru.ifmo.se.pult.*;
import ru.ifmo.se.pult.commands.*;


import java.util.Scanner;
/**
 * Main class
 * @author Gurin Minu
 * @version 0
 * @since 0
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Reader reader = new Reader(new Scanner(System.in));
        Collection collection = new Collection(FileManager.readFile(Reader.readFile(new Scanner(System.in))));
        App app = new App(collection);
        Controller controller = new Controller(new HelpCommand(app), new InfoCommand(app), new ShowCommand(app), new AddCommand(app), new UpdateIdCommand(app), new RemoveByIdCommand(app), new ClearCommand(app), new SaveCommand(app), new ExecuteScriptCommand(app), new ExitCommand(app), new RemoveGreaterCommand(app), new RemoveLowerCommand(app), new HistoryCommand(app), new MaxByGenreCommand(app), new FilterLessThanNumberOfParticipantsCommand(app),new PrintDescendingCommand(app));
        controller.start(System.in);
    }
}
