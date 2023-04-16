package commands;

import com.github.cliftonlabs.json_simple.Jsoner;
import models.*;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static utils.Checker.fileNameCheck;
import static utils.Checker.inputFileName;

public class SaveCommand implements Command{
    private final List<City> collection;
    public SaveCommand(List<City> collection){

        this.collection = collection;
    }
    private void save(String fileName){
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
            String json = Jsoner.serialize(collection);
            json = Jsoner.prettyPrint(json);
            writer.write(json);
            writer.close();
            System.out.println("Collection saved successfully");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    @Override
    public void execute() {
        save("cities.json");
    }
    @Override
    public void execute(String fileName){
        if (fileNameCheck(fileName, "json")){
            save(fileName);
        }
        else {
            fileName = inputFileName("Entered string can not be file name!\nRepeat input: ", "json");
            save(fileName);
        }
    }
}
