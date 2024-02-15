package com.lj.api.datos.entity.air;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lj.api.datos.entity.response.Coord;
import com.lj.api.datos.security.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class ApiAir implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    @JsonIgnore
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Coord coord;

    @OneToMany(mappedBy = "apiAir")
    private List<ApiAirList> list;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Usuario user;
}
