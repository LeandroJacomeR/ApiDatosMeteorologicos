package com.lj.api.datos.dto.api.forecast;

import com.lj.api.datos.dto.api.response.ApiResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class ApiForecastDto {
    private String cod;
    private int message;
    private int cnt;
    private List<ApiResponseDto> list;
}
