package com.lj.api.datos.dto.api.response;

import lombok.Data;

@Data
public class ApiResponseDto {
    private CoordDto coord;
    private WeatherDto[] weather;
    private String base;
    private MainDto main;
    private int visibility;
    private double pop;
    private WindDto wind;
    private CloudsDto clouds;
    private int dt;
    private SysDto sys;
    private String dt_txt;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}
