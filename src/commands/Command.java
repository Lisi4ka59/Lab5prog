package commands;

public interface Command {
    void execute();

    default void execute(String args)
    {
        execute(args);
    }
}
