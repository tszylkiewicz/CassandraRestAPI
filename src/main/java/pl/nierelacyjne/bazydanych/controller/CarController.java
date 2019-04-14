package pl.nierelacyjne.bazydanych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import pl.nierelacyjne.bazydanych.model.Car;
import pl.nierelacyjne.bazydanych.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController implements ErrorController {
    private static final String PATH = "/error";
    @Autowired
    private CarRepository carRepository;

    public CarController() {
        System.out.println("CarController()");
    }

    @GetMapping(value = "/")
    public String showMainWindow() {
        return "Nierelacyjne bazy danych";
    }

    @PostMapping(value = "/car")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping(value = "/car/{id}", produces = "application/json; charset=utf-8")
    public String deleteCar(@PathVariable("id") String id) {
        boolean result = carRepository.existsById(id);
        carRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") + "} ";
    }

    @GetMapping(value="/cars")
    public List<Car> findAllCars() {
        List<Car> carList = new ArrayList<>();
        carRepository.findAll().forEach(carList::add);
        return carList;
    }

    @GetMapping(value = "/car/{id}")
    public Optional<Car> findCarById(@PathVariable("id") String id) {
        return carRepository.findById(id);
    }

    @PutMapping(value = "/car")
    public Optional<Car> updateCar(@RequestBody Car newCar) {
        Optional<Car> optionalCar = carRepository.findById(newCar.getId());
        if (optionalCar.isPresent()){
            Car car = optionalCar.get();
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

    @Override
    public String getErrorPath() {
        return PATH;
    }
    @RequestMapping(value = PATH, produces = "application/json; charset=utf-8")
    public String errorHandler(){
        return "{ \"result\" : \"Data not found\" } ";
    }
}
