package commands;

import common.Invoker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static utils.CityLinkedList.isSave;


public class ExecuteScriptCommand implements Command{
    private final List collection;
    public ExecuteScriptCommand(List collection){

        this.collection = collection;
    }
    private void exe(String fileName){
        Invoker invoker = new Invoker(collection);
        for (String line: ReadFile(fileName)){
            System.out.println("Running ..." + line);
            if (line!=null && !line.startsWith("execute_script"))
                invoker.run(line);
            else
                System.out.println("Executing the \"execute_script\" command can be very dangerous as it can cause recursion!");
        }
    }
    @Override
    public void execute() {
        execute("commands.txt");
        isSave = false;
    }

    @Override
    public void execute(String fileName) {
        exe(fileName);
        isSave = false;
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
            System.out.printf("File %s does not exist\n", filename);
        }
        return lines;
    }
}
