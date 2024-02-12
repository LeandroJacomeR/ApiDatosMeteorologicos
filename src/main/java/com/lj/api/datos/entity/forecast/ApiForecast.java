package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.ApiResponse;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ApiForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long id;
    private String cod;
    private int message;
    private int cnt;

    @OneToMany(mappedBy = "apiForecast", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ApiResponse> list;
}
