package com.lj.api.datos.entity.air;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class ApiAirList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private MainAir main;
    @OneToOne(cascade = CascadeType.ALL)
    private Components components;
    private int dt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private ApiAir apiAir;
}
