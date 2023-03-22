package models;

import java.time.LocalDateTime;
import java.util.Date;

public class City {
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public City (String name, Coordinates coordinates, /* double */ Long population, int metersAboveSeaLevel,
                 Climate climate, Government government, StandardOfLiving standardOfLiving, Human governor){
        Date date = new Date();
        id = date.getTime();
        creationDate = LocalDateTime.now();
    }

    public void setName (String name){
        this.name=name;
    }

    public String getName (){
        return name;
    }

    public void setPopulation (Long population){
        this.population=population;
    }

    public Long getPopulation (){
        return population;
    }


    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null

    private double area; //Значение поля должно быть больше 0
    private Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private int metersAboveSeaLevel;
    private Climate climate; //Поле не может быть null
    private Government government; //Поле может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле может быть null
}