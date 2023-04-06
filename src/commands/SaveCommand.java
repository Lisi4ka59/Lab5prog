package commands;

import com.github.cliftonlabs.json_simple.Jsoner;
import models.*;


import java.io.BufferedWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static common.Main.cities;


public class SaveCommand implements Command{
    @Override
    public void execute() {
        /*Coordinates coordinates = new Coordinates(34, 23f);
        Long age = 34L;
        Date birthday = new Date(1976, 6, 11);
        Human governor = new Human(age, birthday);
        City city = new City("p", coordinates, 34l, 3, 555, Climate.OCEANIC, Government.ANARCHY, StandardOfLiving.HIGH, governor);
        cities.add(city);*/
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("cities.json"));
            String json = Jsoner.serialize(cities);
            json = Jsoner.prettyPrint(json);
            writer.write(json);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
