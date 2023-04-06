package models;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Optional;

public class CityLinkedList extends LinkedList<City> implements Jsonable {
    private LocalDateTime creationDate;
    public CityLinkedList () {
        super();
        creationDate = LocalDateTime.now();
    }
    public void addIfMin (City city){
        City minCity = stream().min(new CityComparator()).get();

        if (new CityComparator().compare(minCity, city)<0)
            add(city);

    }
    public LocalDateTime getCreationDate() {
        return creationDate;
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
        json.put("creationDate", this.getCreationDate().toString());
        json.put("cities", this.toArray());
        json.toJson(writer);
    }
}
