package commands;

import models.City;
import java.util.List;
import static utils.Checker.inputLong;
import static utils.CityReader.*;

public class UpdateIdCommand implements Command{
    private final List<City> collection;
    public UpdateIdCommand(List<City> collection){

        this.collection = collection;
    }
    private void update(long id){
        boolean update = false;
        for (City city:collection) {
            if (city.getId()==id){
                city.setName(inputName());
                city.setCoordinates(inputCoordinates());
                city.setArea(inputArea());
                city.setPopulation(inputPopulation());
                city.setMetersAboveSeaLevel(inputMetersAboveSeaLevel());
                city.setClimate(inputClimate());
                city.setGovernment(inputGovernment());
                city.setStandardOfLiving(inputStandardOfLiving());
                city.setGovernor(inputGovernor());
                update = true;
                break;
            }
        }
        if (update)
            System.out.printf("City %d updated\n", id);
        else
            System.out.printf("City %d doesn't exist\n", id);
    }
    @Override
    public void execute() {
        long id = inputLong("Enter id: ");
        update(id);
    }
    @Override
    public void execute(String stringId){
        long id;
        try {
            id = Long.parseLong(stringId);
        } catch (NumberFormatException e) {
            System.out.println("Entered value can not be city id!");
            id = inputLong("Enter correct city id: ");
        }
        update(id);
    }
}
