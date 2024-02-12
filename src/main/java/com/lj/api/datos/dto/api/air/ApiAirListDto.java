package com.lj.api.datos.dto.api.air;

import lombok.Data;

@Data
public class ApiAirListDto {
    private MainAirDto main;
    private ComponentsDto components;
    private int dt;
}
