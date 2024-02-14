package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.ApiResponse;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WeatherForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    @JsonIgnore
    private Long weatherId;
    private int id;
    private String main;
    private String description;
    private String icon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private ApiResponseForecast apiResponseForecast;
}
