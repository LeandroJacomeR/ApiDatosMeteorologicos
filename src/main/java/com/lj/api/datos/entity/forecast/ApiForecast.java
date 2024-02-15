package com.lj.api.datos.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.ApiResponse;
import com.lj.api.datos.security.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class ApiForecast implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long id;
    private String cod;
    private int message;
    private int cnt;

    @OneToMany(mappedBy = "apiForecast")
    private List<ApiResponseForecast> list;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Usuario user;
}
