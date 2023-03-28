package commands;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

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

            System.out.println();
        } catch (JsonException e) {
            throw new RuntimeException(e);

        }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
    }



}
