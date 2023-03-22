package models;

public class Human {
    public Human (long age, java.util.Date birthday){
        this.age = age;
        this.birthday = birthday;
    }
    private long age; //Значение поля должно быть больше 0
    private java.util.Date birthday;
}