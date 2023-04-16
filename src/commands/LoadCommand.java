package commands;

import com.github.cliftonlabs.json_simple.*;
import models.City;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadCommand implements Command{
    private final List collection;
    public LoadCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        try {
            String fileName = "cities.json";
            String path = System.getenv("CITIES_PATH");
            if (path!=null)
                fileName = path;
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            JsonArray jsonArray = (JsonArray)jsonObject.get("cities");
            for (Object obj: jsonArray) {
                JsonObject jo = (JsonObject) obj;
                City city = new City(jo);
                collection.add(city);
            }
            System.out.println("Collection uploaded");
        } catch (JsonException e) {
            System.out.println("Can not upload collection, data in the file incorrect!");
        } catch (IOException e) {
                System.out.println("Can not upload collection, the file does not exist!");
            }
    }
}
