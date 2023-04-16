package commands;

import java.util.Objects;

import static utils.Checker.inputString;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        if (Objects.equals(inputString("Maybe there are unsaved changes. Exit anyway?\nPrint \"Y\" for exit something other for continue work: "), "Y")) {
            System.out.println("Exit from the program");
            System.exit(0);
        }
    }
}