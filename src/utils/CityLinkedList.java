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

public class CityLinkedList extends LinkedList<City> implements Jsonable {
    private LocalDateTime creationCollectionDate;
    public CityLinkedList () {
        super();
        creationCollectionDate = LocalDateTime.now();
    }
    public boolean addIfMin (City city){
        City minCity = stream().min(new CityComparator()).get();
        if (new CityComparator().compare(minCity, city)<0){
            add(city);
            return true;
        }
        else return false;
    }
    public String getCreationCollectionDate() {
        String date = creationCollectionDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss"));
        return date;
    }
    @Override
    public String toJson() {
        final StringWriter writable = new StringWriter();
        try {
            this.toJson(writable);
        } catch (final IOException e) {
        }
        return writable.toString();
    }

    @Override
    public void toJson(Writer writer) throws IOException {
        final JsonObject json = new JsonObject();
        json.put("creationCollectionDate", this.getCreationCollectionDate());
        json.put("cities", this.toArray());
        json.toJson(writer);
    }
}
