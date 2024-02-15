package com.lj.api.datos.entity.response;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lj.api.datos.entity.forecast.ApiForecast;
import com.lj.api.datos.security.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class ApiResponse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long apiId;

    @OneToOne(cascade = CascadeType.ALL)
    private Coord coord;
    @OneToMany(mappedBy = "apiResponse")
    private List<Weather> weather;
    private String base;
    @OneToOne(cascade = CascadeType.ALL)
    private Main main;
    private int visibility;
    @OneToOne(cascade = CascadeType.ALL)
    private Wind wind;
//    @OneToOne(cascade = CascadeType.ALL)
//    private Clouds clouds;
    private int dt;
    @OneToOne(cascade = CascadeType.ALL)
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Usuario user;

}
