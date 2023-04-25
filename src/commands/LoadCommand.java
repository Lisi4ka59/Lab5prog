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

import static utils.CityLinkedList.idRepeat;
import static utils.CityLinkedList.isSave;


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
            collection.sort(new CityComparator());
            if (idRepeat == 0){
                isSave = true;
            }
            System.out.println("Collection uploaded");
        } catch (JsonException | IllegalArgumentException | NullPointerException e) {
            System.out.printf("Can not upload collection, data in the file incorrect! %s\n", e.getMessage());
        } catch (SecurityException e) {
            System.out.printf("Do not have sufficient rights to read file %s\n", fileName);
        } catch (IOException e) {
            System.out.printf("Can not upload collection, the file %s does not exist!\n", fileName);
        }
    }
    @Override
    public void execute() {
        load("cities.json");
    }
    @Override
    public void execute(String fileName){
        load(fileName);
    }
}
