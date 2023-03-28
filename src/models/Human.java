package models;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Human implements Jsonable {
    public Human (long age, java.util.Date birthday){
        this.age = age;
        this.birthday = birthday;
    }
    private long age; //Значение поля должно быть больше 0
    private java.util.Date birthday;
    public long getAge(){
        return age;
    }
    public java.util.Date getBirthday(){
        return birthday;
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
        json.put("age", this.getAge());
        json.put("birthday", this.getBirthday());
        json.toJson(writer);
    }
}