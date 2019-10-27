package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCar = Integer.parseInt(reader.readLine());
        while (countCar-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            new Car(model,
                    engineSpeed,
                    enginePower,
                    cargoWeight,
                    cargoType,
                    tire1Pressure,
                    tire1Age,
                    tire2Pressure,
                    tire2Age,
                    tire3Pressure,
                    tire3Age,
                    tire4Pressure,
                    tire4Age);

        }
        if (reader.readLine().equals("fragile")) {
            Car.carList.stream().filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(e -> e.getTire().minPressure()<1)
                    .forEach(Car::printModel);
        } else {
            Car.carList.stream().filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(power -> power.getEngine().getEnginePower() > 250)
                    .forEach(Car::printModel);

        }
    }
}
