import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print(">");
            String commandText = scanner.nextLine();

            invoker.run(commandText);

        } while (true);

    }
}