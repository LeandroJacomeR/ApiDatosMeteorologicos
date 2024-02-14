package com.lj.api.datos.dto.cities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ApiResponseCity{
    private String name;
    @JsonIgnore
    private LocalNames localNames;
    private double lat;
    private double lon;
    private String country;
    private String state;
}