import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            try {
                String commandText = scanner.nextLine();
                invoker.run(commandText);
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        }
    }
}