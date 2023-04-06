package commands;

import com.github.cliftonlabs.json_simple.*;
import common.Main;
import models.City;
import models.CityLinkedList;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static common.Main.cities;

public class LoadCommand implements Command{
    @Override
    public void execute() {


        // read JSON from a file
        try {

            Reader reader = Files.newBufferedReader(Paths.get("cities.json"));

            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);

            JsonArray jsonArray = (JsonArray)jsonObject.get("cities");

            cities=new CityLinkedList();

            for (Object obj: jsonArray) {
                JsonObject jo = (JsonObject) obj;

                City city = new City(jo);
                cities.add(city);
            }


            System.out.println("Collection uploaded");
        } catch (JsonException e) {
            throw new RuntimeException(e);

        }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
