package com.lj.api.datos.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.forecast.ApiForecast;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ApiResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long apiId;

    @OneToOne(cascade = CascadeType.ALL)
    private Coord coord;
    @OneToOne(cascade = CascadeType.ALL)
    private Weather[] weather;
    private String base;
    @OneToOne(cascade = CascadeType.ALL)
    private Main main;
    private int visibility;
    @OneToOne(cascade = CascadeType.ALL)
    private Wind wind;
    @OneToOne(cascade = CascadeType.ALL)
    private Clouds clouds;
    private int dt;
    @OneToOne(cascade = CascadeType.ALL)
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private ApiForecast apiForecast;
}
