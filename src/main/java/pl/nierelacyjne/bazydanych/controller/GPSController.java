package pl.nierelacyjne.bazydanych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.nierelacyjne.bazydanych.model.GPS;
import pl.nierelacyjne.bazydanych.repository.GPSRepository;

import java.util.Optional;

@RestController
public class GPSController {
    @Autowired
    GPSRepository gpsRepository;

    public GPSController() {
        System.out.println("GPSController()");
    }

    @GetMapping(value = "/gps/{id}")
    public Optional<GPS> findGPSById(@PathVariable("id") String id) {
        return gpsRepository.findById(id);
    }
//
//    @PostMapping(value = "/car/{id}/gps")
//    public GPS createGPSForCar(@RequestBody GPS gps) {
//        return gpsRepository.save(gps);
//    }
}
