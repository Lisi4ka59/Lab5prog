package commands;

import java.util.List;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("shutdown");
        System.exit(0);
    }
}
