package pl.nierelacyjne.bazydanych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import pl.nierelacyjne.bazydanych.model.Car;
import pl.nierelacyjne.bazydanych.repository.CarRepository;

import java.util.*;

@RestController
public class CarController implements ErrorController {
    private static final String PATH = "/error";
    private static final String SERVICE = "/cars";

    @Autowired
    private CarRepository carRepository;

    public CarController() {
        System.out.println("CarController()");
    }

    @GetMapping(value = "/")
    public String showMainWindow() {
        return "Nierelacyjne bazy danych";
    }

    @PostMapping(value = SERVICE + "/CreateCar")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping(value = SERVICE + "/DeleteCar/{id}", produces = "application/json; charset=utf-8")
    public String deleteCar(@PathVariable("id") String id) {
        boolean result = carRepository.existsById(id);
        carRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") + "} ";
    }

    @GetMapping(value= SERVICE + "/GetAllCars")
    public List<Car> findAllCars() {
        List<Car> carList = new ArrayList<>();
        carRepository.findAll().forEach(carList::add);
        return carList;
    }

    @GetMapping(value = SERVICE + "/GetCar/{id}")
    public Optional<Car> findCarById(@PathVariable("id") String id) {
        return carRepository.findById(id);
    }

    @PutMapping(value = SERVICE + "/UpdateCar")
    public Optional<Car> updateCar(@RequestBody Car newCar) {
        Optional<Car> optionalCar = carRepository.findById(newCar.getId());
        if (optionalCar.isPresent()){
            Car car = optionalCar.get();
            car.setTirePressure(newCar.getTirePressure());
            car.setGps(newCar.getGps());
            car.setFuelConsumption(newCar.getFuelConsumption());
            car.setMileage(newCar.getMileage());
            car.setAverageSpeed(newCar.getAverageSpeed());
            car.setFuel(newCar.getFuel());
            car.setLoadWeight(newCar.getLoadWeight());
            car.setCargoTemperature(newCar.getCargoTemperature());
            car.setLastBreak(newCar.getLastBreak());
            carRepository.save(car);
        }
        return optionalCar;
    }

    @GetMapping(value = SERVICE + "/GetCar/{id}/GetCarGPS", produces = "application/json; charset=utf-8")
    public String findGPSForCarId(@PathVariable("id") String id) {
        if (carRepository.findById(id).isPresent()) {
            return carRepository.findById(id).get().getGps().toString();
        }
        return "{ \"result\" : \"Data not found\" } ";
    }

    @GetMapping(value = SERVICE + "/GetCar/{id}/GetCarTirePressure", produces = "application/json; charset=utf-8")
    public String findTirePressureForCarId(@PathVariable("id") String id) {
        if (carRepository.findById(id).isPresent()) {
            return carRepository.findById(id).get().getTirePressure().toString();
        }
        return "{ \"result\" : \"Data not found\" } ";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH, produces = "application/json; charset=utf-8")
    public String errorHandler(){
        return "{ \"result\" : \"Data not found\" } ";
    }
}
