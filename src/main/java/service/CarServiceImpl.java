package service;

import dao.CarDao;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Impl class for Employee to perform CRUD operation.
 * @author Ranga Reddy
 * @version 1.0
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    /**
     * Default Constructor
     */
    public CarServiceImpl() {
        super();
    }

    @Override
    public Car createCar(Car car) {
        return carDao.createCar(car);
    }

    @Override
    public Car getCar(String id) {
        return carDao.getCar(id);
    }

    @Override
    public Car updateCar(Car car) {
        return carDao.updateCar(car);
    }

    @Override
    public void deleteCar(String id) {
        carDao.deleteCar(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

}