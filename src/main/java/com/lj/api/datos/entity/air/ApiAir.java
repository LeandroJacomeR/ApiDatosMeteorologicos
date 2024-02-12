package com.lj.api.datos.entity.air;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.Coord;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ApiAir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Coord coord;

    @OneToMany(mappedBy = "apiAir", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ApiAirList> list;
}
