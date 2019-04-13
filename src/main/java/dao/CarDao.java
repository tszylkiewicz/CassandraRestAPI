package dao;

import model.Car;

import java.util.List;

/**
 * DAO interface for Employee to perform CRUD operation.
 *
 * @author Ranga Reddy
 * @version 1.0
 */
public interface CarDao {
    /**
     * Used to Create the Employee Information
     *
     * @param car
     * @return {@link Car}
     */
    public Car createCar(Car car);

    /**
     * Getting the Employee Information using Id
     *
     * @param id
     * @return {@link Car}
     */
    public Car getCar(String id);

    /**
     * Used to Update the Employee Information
     *
     * @param car
     * @return {@link Car}
     */

    public Car updateCar(Car car);

    /**
     * Deleting the Employee Information using Id
     *
     * @param id
     */
    public void deleteCar(String id);

    /**
     * Getting the All Employees information
     *
     * @return
     */
    public List<Car> getAllCars();
}
