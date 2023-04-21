package commands;

import com.github.cliftonlabs.json_simple.*;
import common.Invoker;
import models.City;
import org.apache.commons.lang.StringUtils;
import utils.CityComparator;

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
    private void load(String fileName){
        try {
            String path = System.getenv("CITIES_PATH");
            if (path!=null && StringUtils.equals(fileName, "cities.json"))
                fileName = path;
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            JsonArray jsonArray = (JsonArray)jsonObject.get("cities");
            Invoker invoker = new Invoker(collection);
            invoker.run("clear noOutput");
            for (Object obj: jsonArray) {
                JsonObject jo = (JsonObject) obj;
                City city = new City(jo);
                collection.add(city);
            }
            System.out.println("Collection uploaded");
        } catch (JsonException | IllegalArgumentException | NullPointerException e) {
            System.out.println("Can not upload collection, data in the file incorrect!");
        } catch (IOException e) {
            System.out.println("Can not upload collection, the file does not exist!");
        }
    }
    @Override
    public void execute() {
        load("cities.json");
        collection.sort(new CityComparator());
    }
    @Override
    public void execute(String fileName){
        load(fileName);
        collection.sort(new CityComparator());
    }
}
