package commands;

import common.Invoker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ExecuteScriptCommand implements Command{
    @Override
    public void execute() {
        execute("commands.txt");
    }

    @Override
    public void execute(String filename) {

        Invoker invoker = new Invoker();
        for (String line: ReadFile(filename)){
            System.out.println("Running ..." + line);
            invoker.run(line);
        }
    }

    private ArrayList<String> ReadFile(String filename){
        ArrayList<String> lines = new ArrayList<>();
        try{

            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("Ошибка");
        }

        return lines;
    }
}
