package dao;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.CassandraTemplate;

import java.util.List;

/**
 * DAOImpl class for Employee to perform CRUD operation.
 * @author Ranga Reddy
 * @version 1.0
 */
@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @Override
    public Car createCar(Car car) {
        return cassandraTemplate.create(car);
    }

    @Override
    public Car getCar(String id) {
        return cassandraTemplate.findById(id, Car.class);
    }

    @Override
    public Car updateCar(Car car) {
        return cassandraTemplate.update(car, Car.class);
    }

    @Override
    public void deleteCar(String id) {
        cassandraTemplate.deleteById(id, Car.class);
    }

    @Override
    public List<Car> getAllCars() {
        return cassandraTemplate.findAll(Car.class);
    }
}
