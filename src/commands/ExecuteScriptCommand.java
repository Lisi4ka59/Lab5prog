package commands;

import common.Invoker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static utils.Checker.fileNameCheck;
import static utils.Checker.inputFileName;

public class ExecuteScriptCommand implements Command{
    private final List collection;
    public ExecuteScriptCommand(List collection){

        this.collection = collection;
    }
    private void exe(String fileName){
        Invoker invoker = new Invoker(collection);
        for (String line: ReadFile(fileName)){
            System.out.println("Running ..." + line);
            invoker.run(line);
        }
    }
    @Override
    public void execute() {
        execute("commands.txt");
    }

    @Override
    public void execute(String fileName) {
        if (fileNameCheck(fileName, "txt")){
            exe(fileName);
        }
        else {
            fileName = inputFileName("Entered string can not be file name!\nRepeat input: ", "txt");
            exe(fileName);
        }
    }

    private ArrayList<String> ReadFile(String filename){
        ArrayList<String> lines = new ArrayList<>();
        try{

            FileInputStream fStream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("Warning");
        }
        return lines;
    }
}
