package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.*;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class ApiResponseForecast implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long apiId;

    private int dt;
    @OneToOne(cascade = CascadeType.ALL)
    private MainForecast main;
    @OneToMany(mappedBy = "apiResponseForecast")
    @JsonIgnore
    private List<WeatherForecast> weather;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private WindForecast wind;
    private int visibility;
    private int pop;
    @OneToOne(cascade = CascadeType.ALL)
    private SysForecast sys;
    private String dt_txt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private ApiForecast apiForecast;
}
