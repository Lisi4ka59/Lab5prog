package models;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Optional;

public class CityLinkedList extends LinkedList<City> implements Jsonable {
    private LocalDateTime creationDate;
    public CityLinkedList () {
        super();
        creationDate = LocalDateTime.now();
    }
    public boolean addIfMin (City city){
        City minCity = stream().min(new CityComparator()).get();
        if (new CityComparator().compare(minCity, city)<0){
            add(city);
            return true;
        }
        else return false;
    }
    public String getCreationDate() {
        String date = new SimpleDateFormat("dd/MM/yyyy").format(creationDate);
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
        json.put("creationDate", this.getCreationDate());
        json.put("cities", this.toArray());
        json.toJson(writer);
    }
}
