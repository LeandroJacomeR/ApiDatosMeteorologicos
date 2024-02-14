package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ApiResponseForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long apiId;

    private int dt;
    @OneToOne(cascade = CascadeType.ALL)
    private MainForecast main;
    @OneToMany(mappedBy = "apiResponseForecast")
    private List<WeatherForecast> weather;
    //    @OneToOne(cascade = CascadeType.ALL)
//    private Clouds clouds;
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
