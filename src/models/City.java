package models;

import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class City implements Jsonable, Comparable<City> {
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private double area; //Значение поля должно быть больше 0
    private Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private int metersAboveSeaLevel;
    private Climate climate; //Поле не может быть null
    private Government government; //Поле может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле может быть null
    public City (String name, Coordinates coordinates, Long population, double area, int metersAboveSeaLevel,
                 Climate climate, Government government, StandardOfLiving standardOfLiving, Human governor){
        Date date = new Date();
        id = date.getTime();
        creationDate = LocalDateTime.now();
        this.name = name;
        this.coordinates = coordinates;
        this.population = population;
        this.area = area;
        this.climate = climate;
        this.standardOfLiving = standardOfLiving;
        this.government = government;
        this.governor = governor;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public City (JsonObject jsonObject){

        final JsonKey nameKey = Jsoner.mintJsonKey("name", "");
        final JsonKey populationKey = Jsoner.mintJsonKey("population", "");
        final JsonKey areaKey = Jsoner.mintJsonKey("area", "");
        final JsonKey xKey = Jsoner.mintJsonKey("x", "");
        final JsonKey yKey = Jsoner.mintJsonKey("y", "");
        final JsonKey standardOfLivingKey = Jsoner.mintJsonKey("standard_of_living", "");
        final JsonKey governmentKey = Jsoner.mintJsonKey("government", "");
        final JsonKey climateKey = Jsoner.mintJsonKey("climate", "");
        final JsonKey ageKey = Jsoner.mintJsonKey("age", "");
        final JsonKey birthdayKey = Jsoner.mintJsonKey("birthday", "");
        final JsonKey idKey = Jsoner.mintJsonKey("id", "");
        final JsonKey creationDateKey = Jsoner.mintJsonKey("creationDate", "");
        setId(jsonObject.getLong(idKey));
        /*String creationDateString = jsonObject.getString(creationDateKey);
        DateFormat dfc = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        Date creationDate;
        try {
            creationDate = dfc.parse(creationDateString);
        } catch (ParseException e) {
            creationDate = null;*/
        setName(jsonObject.getString(nameKey));
        JsonObject joCoordinates  = (JsonObject)jsonObject.get ("coordinates");
        this.coordinates = new Coordinates(joCoordinates.getDouble(xKey),joCoordinates.getFloat(yKey));
        setPopulation(jsonObject.getLong(populationKey));
        setArea(jsonObject.getDouble(areaKey));
        if (jsonObject.getString(standardOfLivingKey)==null)
            this.standardOfLiving = null;
        else
            this.standardOfLiving =StandardOfLiving.valueOf(jsonObject.getString(standardOfLivingKey));
        if (jsonObject.getString(governmentKey)==null)
            this.government = null;
        else
            this.government =Government.valueOf(jsonObject.getString(governmentKey));
        this.climate =Climate.valueOf(jsonObject.getString(climateKey));
        JsonObject joGovernor  = (JsonObject)jsonObject.get ("governor");
        if (joGovernor.getString(ageKey)==null || joGovernor.getString(birthdayKey)==null)
            this.governor = null;
        else {
            String birthdayString=joGovernor.getString(birthdayKey);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date birthday;
            try {
                birthday = df.parse(birthdayString);
            } catch (ParseException i) {
                birthday = null;
            }
            this.governor = new Human(joGovernor.getLong(ageKey), birthday);
        }
    }

    public void setCreationDate(LocalDateTime creationDate){
        if (creationDate == null) {
            throw new NullPointerException("Field creationDate can not be null");

        }
        this.creationDate=creationDate;
    }

    public String getCreationDate (){
        String date = creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss"));
        return date;
    }

    public void setId (Long id){
        if (id == null) {
            throw new NullPointerException("Field id can not be null");

        }

        this.id = id;
    }

    public long getId (){
        return id;
    }

    public void setCoordinates (Coordinates coordinates){
        if (coordinates == null) {
            throw new NullPointerException("Field coordinates can not be null");

        }

        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setPopulation (Long population){
        if (population == null ) {
            throw new NullPointerException("Field population can not be null or less than 0");

        }
        if (population <= 0){
            throw new IllegalArgumentException("Field population can not be less or equals than 0");
        }
        this.population=population;
    }

    public Long getPopulation (){
        return population;
    }

    public void setArea (double area){
        if (area <= 0) {
            throw new IllegalArgumentException("Field area can not be less or equals than 0");
        }
        this.area = area;
    }

    public double getArea (){
        return area;
    }
    public String getStringArea(){
        return String.format("%.2f\n", area);
    }

    public void setMetersAboveSeaLevel (int metersAboveSeaLevel){
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public Integer getMetersAboveSeaLevel (){
        return metersAboveSeaLevel;
    }

    public void setClimate (Climate climate){
        if (climate == null) {
            throw new NullPointerException("Field climate can not be null");

        }

        this.climate = climate;
    }

    public Climate getClimate (){
        return climate;
    }

    public void setGovernment (Government government){
        if (government == null) {
            throw new NullPointerException("Field government can not be null");

        }
        this.government = government;
    }

    public Government getGovernment (){
        return government;
    }

    public void setStandardOfLiving (StandardOfLiving standardOfLiving){
        if (standardOfLiving == null) {
            throw new NullPointerException("Field standardOfLiving can not be null");

        }

        this.standardOfLiving = standardOfLiving;
    }

    public StandardOfLiving getStandardOfLiving (){
        return standardOfLiving;
    }

    public void setGovernor (Human governor){
        if (governor == null) {
            throw new NullPointerException("Field governor can not be null");

        }

        this.governor = governor;
    }

    public Human getGovernor (){
        return governor;
    }

    public void setName (String name){
        if (name == null) {
            throw new NullPointerException("Field name can not be null");

        }

        this.name = name;
    }

    public String getName (){
        return name;
    }
    @Override
    public String toString(){

        return String.format("Name: %s\nID: %d\nCoordinates: %sStandard of living: %s\nGovernment: %s\nClimate: %s\nStandard of living: %s\nGovernment: %s\nArea: %sPopulation: %d\n", name, getId(), getCoordinates(), getStandardOfLiving(), getGovernment(), getClimate(), getStandardOfLiving(), getGovernment(), getStringArea(), getPopulation());
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
        json.put("id", this.getId());
        json.put("creation_date", this.getCreationDate());
        json.put("coordinates", this.getCoordinates());
        json.put("population", this.getPopulation());
        json.put("area", this.getArea());
        json.put("meters_above_sea_level", this.getMetersAboveSeaLevel());
        json.put("climate", this.getClimate().name());
        if (this.getGovernment()==null)
            json.put("government", null);
        else
            json.put("government", this.getGovernment().name());
        if (this.getStandardOfLiving()==null)
            json.put("standard_of_living", null);
        else
            json.put("standard_of_living", this.getStandardOfLiving().name());
        if (this.getGovernor()==null)
            json.put("governor", null);
        else
            json.put("governor", this.getGovernor());
        json.toJson(writer);
    }

    @Override
    public int compareTo(City o) {
        if (o!=null)
            return  -name.compareToIgnoreCase(o.name);
        else
            return 1;
    }
}