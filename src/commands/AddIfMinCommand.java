package commands;

import models.City;
import utils.CityComparator;

import java.util.List;

import static common.AppClient.cities;

public class AddIfMinCommand implements Command{
    private List<City> collection;
    public AddIfMinCommand(List<City> collection){

        this.collection = collection;
    }
    public boolean addIfMin (City city){
        City minCity = collection.stream().min(new CityComparator()).get();
        if (new CityComparator().compare(minCity, city)<0){
            collection.add(city);
            return true;
        }
        else return false;
    }
    @Override
    public void execute() {
        City city = AddCommand.getCity(); // получить город с консоли
        if (addIfMin(city)){
            System.out.println("City was successfully added to collection");
        }
        else{
            System.out.println("City is not added to collection");
        }
    }
}
