package models;

import com.github.cliftonlabs.json_simple.JsonObject;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -25, Поле не может быть null
    private Float y; //Поле не может быть null
    public Coordinates (double x, Float y){
        this.x = x;
        this.y = y;
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
        json.put("name", this.getName());
        json.put("coordinates", this.getcoordinates());
        json.put("population", this.getPopulation());
        json.put("area", this.getArea());
        json.toJson(writer);
    }
}