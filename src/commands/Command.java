package commands;

public interface Command {
    public void execute();

    default void execute(String args)
    {
        execute();
    }
}
