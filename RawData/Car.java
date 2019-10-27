package RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;
    public static List<Car> carList = new ArrayList<>();

    public Car(String model, int engineSpeed, int enginePower,
               int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age,
               double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age,
               double tire4Pressure, int tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
        carList.add(this);
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Tire getTire() {
        return this.tire;
    }

    public void printModel(){
        System.out.println(this.model);
    }
}
