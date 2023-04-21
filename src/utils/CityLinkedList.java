package utils;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import models.City;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import static common.AppClient.cities;

public class CityLinkedList extends LinkedList<City> implements Jsonable {
    public static Long idRepeat = 0L;
    public static boolean isSave = true;
    private final LocalDateTime creationCollectionDate;
    public CityLinkedList () {
        super();
        creationCollectionDate = LocalDateTime.now();
    }
    public String getCreationCollectionDate() {
        String date = creationCollectionDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        return date;
    }
    @Override
    public String toJson() {
        final StringWriter writable = new StringWriter();
        try {
            this.toJson(writable);
        } catch (final IOException e) {
            System.out.printf("Warning: %s\n", e.getMessage());
        }
        return writable.toString();
    }
    @Override
    public String toString(){
        return String.format("Type: %s\nCreation date: %s\nCount of elements: %d\n", cities.getClass(), cities.getCreationCollectionDate().toString(), cities.size());
    }

    @Override
    public void toJson(Writer writer) throws IOException {
        final JsonObject json = new JsonObject();
        json.put("creation_collection_date", this.getCreationCollectionDate());
        json.put("cities", this.toArray());
        json.toJson(writer);
    }
}
