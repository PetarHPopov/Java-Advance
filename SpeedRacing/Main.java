package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCar = Integer.parseInt(reader.readLine());

        LinkedHashMap<String,Car> cars = new LinkedHashMap<>();

        while (countCar-- > 0){
            String [] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostFor1km = Double.parseDouble(tokens[2]);

            Car car = new Car(model,fuelAmount,fuelCostFor1km);

           cars.put(model,car);
        }

        String line;
        while (!"End".equalsIgnoreCase(line = reader.readLine())){
            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            if (!cars.get(model).drive(distance)){
                System.out.println("Insufficient fuel for the drive");
            }
        }
        for (String model : cars.keySet()) {
            System.out.println(cars.get(model).toString());
        }


    }
}
