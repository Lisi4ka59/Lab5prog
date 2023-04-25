package commands;

import com.github.cliftonlabs.json_simple.Jsoner;
import models.*;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static utils.CityLinkedList.isSave;

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
        } catch (SecurityException e) {
            System.out.printf("Do not have sufficient rights to write file %s\n", fileName);
        } catch (Exception ex) {
            System.out.printf("Error while saving file! %s\n", ex.getMessage());
        }
    }
    @Override
    public void execute() {
        save("cities.json");
        isSave = true;
    }
    @Override
    public void execute(String fileName){
        save(fileName);
        isSave = true;
    }
}
