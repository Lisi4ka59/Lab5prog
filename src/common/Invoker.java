package common;

import commands.*;
import java.util.HashMap;

public class Invoker {

    HashMap<String, Command> commands = new HashMap<>();
    public Invoker () {
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("add", new AddCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("clear", new ClearCommand());
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("remove_head", new RemoveHeadCommand());
        commands.put("save", new SaveCommand());
        commands.put("load", new LoadCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("update_id", new UpdateIdCommand());
        commands.put("print_descending", new PrintDescendingCommand());

    }

    public void run(String commandText)
    {
        if (commands.containsKey(commandText))
        {
            Command cmd = commands.get(commandText);
            cmd.execute();
        }
        else {
            if (!commandText.trim().isEmpty()) {
                System.out.println("Unknown command. Type \"help\" to see list of commands");
            }
        }
    }
}
