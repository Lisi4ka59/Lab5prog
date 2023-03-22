package models;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -25, Поле не может быть null
    private Float y; //Поле не может быть null
    public Coordinates (double x, Float y){
        this.x = x;
        this.y = y;
    }
}