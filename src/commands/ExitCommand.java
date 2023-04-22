package commands;

import common.Invoker;

import java.util.List;
import java.util.Objects;

import static utils.Checker.inputString;
import static utils.CityLinkedList.isSave;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        if (!isSave) {
            if (Objects.equals(inputString("Maybe there are unsaved changes. Exit anyway?\nPrint \"Y\" for exit, something other for continue work: "), "Y")){
                System.out.println("Exit from the program");
                System.exit(0);
            }
        }
        else {
            System.out.println("Exit from the program");
            System.exit(0);
        }
    }
}