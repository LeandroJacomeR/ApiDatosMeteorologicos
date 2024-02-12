package com.lj.api.datos.dto.api.response;

import lombok.Data;

@Data
public class WeatherDto {
    private int id;
    private String main;
    private String description;
    private String icon;
}
