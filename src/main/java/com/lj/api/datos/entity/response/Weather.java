package com.lj.api.datos.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    @JsonIgnore
    private Long weatherId;
    private int id;
    private String main;
    private String description;
    private String icon;
}
