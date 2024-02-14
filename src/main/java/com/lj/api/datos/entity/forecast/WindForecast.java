package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WindForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private double speed;
    private int deg;
    private double gust;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private ApiResponseForecast apiResponseForecast;
}
