package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class WindForecast implements Serializable {
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
