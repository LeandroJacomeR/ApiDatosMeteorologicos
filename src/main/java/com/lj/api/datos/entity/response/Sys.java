package com.lj.api.datos.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Sys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    @JsonIgnore
    private Long sysId;
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
}
