package CarSalesman;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static List<Car> cars = new ArrayList<>();
    private String model;
    private Engine engine;
    private Integer weight = null;
    private String color = null;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        cars.add(this);
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine);
        this.weight = weight;

    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, Integer weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    void print() {
        System.out.print(String.format("%s:%n", this.model));
        System.out.print(this.engine.toString());
        System.out.print(String.format("Weight: %s%nColor: %s%n",
                this.weight == null ? "n/a" : this.weight + "",
                this.color == null ? "n/a" : this.color)
        );
    }
}
