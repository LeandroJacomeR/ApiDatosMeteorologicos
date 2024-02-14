package com.lj.api.datos.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Weather {
    @Id
    private int id;
    private String main;
    private String description;
    private String icon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private ApiResponse apiResponse;
}
