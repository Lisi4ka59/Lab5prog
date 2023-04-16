package commands;

import com.github.cliftonlabs.json_simple.Jsoner;
import models.*;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class SaveCommand implements Command{
    private final List<City> collection;
    public SaveCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("cities.json"));
            String json = Jsoner.serialize(collection);
            json = Jsoner.prettyPrint(json);
            writer.write(json);
            writer.close();
            System.out.println("Collection saved successfully");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
