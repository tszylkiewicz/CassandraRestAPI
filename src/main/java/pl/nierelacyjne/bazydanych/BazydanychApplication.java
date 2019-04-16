package pl.nierelacyjne.bazydanych;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.nierelacyjne.bazydanych.model.Car;
import pl.nierelacyjne.bazydanych.repository.CarRepository;

@SpringBootApplication
public class BazydanychApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazydanychApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CarRepository carRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Car>> typeReference = new TypeReference<List<Car>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/carsData.json");
			try {
				List<Car> cars = mapper.readValue(inputStream, typeReference);
				carRepository.saveAll(cars);
				System.out.println("Cars Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save cars: " + e.getMessage());
			}
		};
	}

}
