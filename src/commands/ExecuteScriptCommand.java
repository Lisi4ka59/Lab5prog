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
    static ArrayList<String> exeRecursion = new ArrayList<>();
    private final List collection;
    public ExecuteScriptCommand(List collection){

        this.collection = collection;
    }
    private void exe(String fileName){
        System.out.printf("Start of executing script from file \"%s\"\n", fileName);
        if (exeRecursion.contains(fileName)) {
            System.out.printf("Can not execute script from file %s, because it can be very dangerous as it can cause recursion!\n", fileName);
            return;
        }

        exeRecursion.add(fileName);
        Invoker invoker = new Invoker(collection);
        ArrayList<String> lines = ReadFile(fileName);
        for (int i = 0; i < lines.size();) {
            String line = lines.get(i);
            System.out.println("Running ..." + line);
            if ("add".equals(line)){
                int j=i+12;
                String add = line+" ";
                i++;
                for (; i < j; i++)
                    add = add + lines.get(i) + (i!=j-1 ? ",":"");
                line = add;
            }
            else
                i++;
           invoker.run(line);
        }
        exeRecursion.remove(fileName);
        System.out.printf("End of executing script from file \"%s\"\n", fileName);
    }
    @Override
    public void execute() {
        execute("commands.txt");
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
