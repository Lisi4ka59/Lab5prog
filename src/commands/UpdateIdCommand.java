package commands;

import models.*;

import java.util.Date;
import java.util.List;

import static utils.Checker.checkDate;
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
    private void updateArgs(String[] args){
        boolean update = false;
        long id = Long.parseLong(args[0]);
        for (City city:collection) {
            if (city.getId()==id){
                city.setName(args[1]);
                double x = Double.valueOf(args[2]);
                float y = Float.valueOf(args[3]);
                city.setCoordinates(new Coordinates(x, y));
                city.setArea(Double.valueOf(args[4]));
                city.setPopulation(Long.valueOf(args[5]));
                city.setMetersAboveSeaLevel(Integer.valueOf(args[6]));
                city.setClimate(Climate.fromInt(Integer.valueOf(args[7])));
                city.setGovernment(Government.fromInt(Integer.valueOf(args[8])));
                city.setStandardOfLiving(StandardOfLiving.fromInt(Integer.valueOf(args[9])));
                long age = Long.valueOf(args[10]);
                Date birthday = checkDate(args[11]);
                city.setGovernor(new Human(age,birthday));
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
    public void execute(String args){
        String[] cityArgs = args.trim().split(",");
        if (cityArgs.length == 1){
            long id;
            try {
                id = Long.parseLong(args);
            } catch (NumberFormatException e) {
                System.out.println("Entered value can not be city id!");
                id = inputLong("Enter correct city id: ");
            }
            update(id);
        }
        else {
            updateArgs(cityArgs);
        }
    }
}
