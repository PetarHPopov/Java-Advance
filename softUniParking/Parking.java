package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car) {
        if (this.cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        } else if (this.cars.size() == this.capacity) {
            return "Parking is full!";
        }
        this.cars.putIfAbsent(car.getRegistrationNumber(), car);
        return String.format("Successfully added new car %s %s",
                car.getMake(), car.getRegistrationNumber());
    }

    public String removeCar(String registrationNomber) {
        if (this.cars.containsKey(registrationNomber)){
            this.cars.remove(registrationNomber);
            return  "Successfully removed " + registrationNomber;
        }else {
            return "Car with that registration number, doesn't exists!";
        }
    }
    public Car getCar(String registrationNumber){

        return this.cars.get(registrationNumber);
    }
    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String registrationNumber : registrationNumbers) {
            this.removeCar(registrationNumber);
        }
    }
    public int getCount(){
        return this.cars.size();
    }
}
