package pl.nierelacyjne.bazydanych.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

@Table("GPS")
@AllArgsConstructor
@Setter
@Getter
public class GPS {
    @PrimaryKey
    private @NonNull String id;
    private String lat;
    private String lng;
}
