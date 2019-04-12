package model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("car")
public class Car {
    @PrimaryKey("id")
    private String id;
    private TirePreassure tirePreassure;
    private GPS gps;
    private float fuelConsumption;
    private float mileage;
    private float averageSpeed;
    private float fuel;
    private float loadWeight;
    private float cargoTemperature;
    private float lastBreak;

    public Car() {
        super();
    }

    public Car(String id, TirePreassure tirePreassure, GPS gps, float fuelConsumption, float mileage, float averageSpeed, float fuel, float loadWeight, float cargoTemperature, float lastBreak) {
        this.id = id;
        this.tirePreassure = tirePreassure;
        this.gps = gps;
        this.fuelConsumption = fuelConsumption;
        this.mileage = mileage;
        this.averageSpeed = averageSpeed;
        this.fuel = fuel;
        this.loadWeight = loadWeight;
        this.cargoTemperature = cargoTemperature;
        this.lastBreak = lastBreak;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TirePreassure getTirePreassure() {
        return tirePreassure;
    }

    public void setTirePreassure(TirePreassure tirePreassure) {
        this.tirePreassure = tirePreassure;
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public float getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(float averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public float getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(float loadWeight) {
        this.loadWeight = loadWeight;
    }

    public float getCargoTemperature() {
        return cargoTemperature;
    }

    public void setCargoTemperature(float cargoTemperature) {
        this.cargoTemperature = cargoTemperature;
    }

    public float getLastBreak() {
        return lastBreak;
    }

    public void setLastBreak(float lastBreak) {
        this.lastBreak = lastBreak;
    }
}
