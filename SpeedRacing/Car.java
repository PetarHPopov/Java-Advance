package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance;

    public Car(String model,double fuelAmount,double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;

    }
    public boolean drive(int distance){
        double neededFuel = distance * this.fuelCost;
        if (this.fuelAmount >= neededFuel){
            this.fuelAmount -= neededFuel;
            this.distance += distance;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distance);
    }
}
