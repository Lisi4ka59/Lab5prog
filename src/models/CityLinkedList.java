package models;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class CityLinkedList extends LinkedList<City> implements Jsonable {
    private LocalDateTime creationDate;
    public CityLinkedList () {
        super();
        creationDate = LocalDateTime.now();
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
