package pl.nierelacyjne.bazydanych.repository;

import org.springframework.data.repository.CrudRepository;
import pl.nierelacyjne.bazydanych.model.Car;

public interface CarRepository extends CrudRepository<Car, String> {

}
