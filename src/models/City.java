package models;

import java.time.LocalDateTime;
import java.util.Date;

public class City {
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
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
    }
    public void setCreationDate (java.time.LocalDateTime creationDate){
        if (creationDate == null) {
            throw new NullPointerException("Field creationDate can not be null");

        }
        this.creationDate=creationDate;
    }

    public java.time.LocalDateTime getCreationDate (){
        return creationDate;
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

    public Coordinates getcoordinates (){
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
        return String.format("Name: %s", name);
    }
}