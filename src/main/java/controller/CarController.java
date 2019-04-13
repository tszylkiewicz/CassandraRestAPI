package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.util.List;

/**
 * @author Ranga Reddy
 * @version 1.0
 * @since Aug 20, 2015
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    public CarController() {
        System.out.println("CarController()");
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    Car create(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") String id) {
        carService.deleteCar(id);
    }

    @RequestMapping(value="/employee", method = RequestMethod.GET)
    List<Car> findAll() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    Car findById(@PathVariable("id") String id) {
        return carService.getCar(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Car update(@RequestBody Car car) {
        return carService.updateCar(car);
    }
}