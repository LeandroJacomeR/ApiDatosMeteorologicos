package com.lj.api.datos.dto.api.air;

import com.lj.api.datos.entity.response.Coord;
import lombok.Data;

import java.util.List;

@Data
public class ApiAirDto {
    private Coord coord;
    private List<ApiAirListDto> list;
}
