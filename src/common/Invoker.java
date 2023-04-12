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
        commands.put("print_unique_standard_of_living", new PrintUniqueStandardOfLivingCommand());
        commands.put("print_field_ascending_standard_of_living", new PrintFieldAscendingStandardOfLivingCommand());
        commands.put("add_if_min", new AddIfMinCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
    }

    public void run(String commandText)
    {

        String[] command =  commandText.split("\s+");

        if (commands.containsKey(command[0]))
        {
            Command cmd = commands.get(command[0]);
            if (command.length==1)
                cmd.execute();
            else
                cmd.execute(command[1]);
        }
        else {
            if (!commandText.trim().isEmpty()) {
                System.out.println("Unknown command. Type \"help\" to see list of commands");
            }
        }
    }
}
