package com.lj.api.datos.dto.api.response;

import lombok.Data;

@Data
public class WindDto {
    private double speed;
    private int deg;
    private double gust;
}
