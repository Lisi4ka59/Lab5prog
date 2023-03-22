import commands.Command;
import commands.HelpCommand;

import java.util.HashMap;

public class Invoker {

    HashMap<String, Command> commands = new HashMap<>();
    public Invoker () {
        commands.put("help", new HelpCommand());

    }

    public void run(String commandText)
    {
        if (commands.containsKey(commandText))
        {
            Command cmd = commands.get(commandText);
            cmd.execute();
        }
        else
        {
            System.out.println("Unknown command. For help print 'help'");
        }
    }


}
