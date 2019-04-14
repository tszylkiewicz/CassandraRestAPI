package pl.nierelacyjne.bazydanych.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("cars")
@AllArgsConstructor
@Getter
@Setter
public class Car {
    @PrimaryKey
    private String id;
//    private TirePreasure tirePreasure;
//    @Autowired
//    private GPS gps;
    private String fuelConsumption;
    private String mileage;
    private float averageSpeed;
    private String fuel;
    private String loadWeight;
    private String cargoTemperature;
    private float lastBreak;
}
