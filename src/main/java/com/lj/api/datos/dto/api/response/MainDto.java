package com.lj.api.datos.dto.api.response;

import lombok.Data;

@Data
public class MainDto {
    private double temp;
    private double feelsLike;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;
    private double temp_kf;
}
