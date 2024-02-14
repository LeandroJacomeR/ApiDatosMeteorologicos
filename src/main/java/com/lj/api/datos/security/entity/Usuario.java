package com.lj.api.datos.security.entity;

import com.lj.api.datos.entity.air.ApiAir;
import com.lj.api.datos.entity.forecast.ApiForecast;
import com.lj.api.datos.entity.response.ApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<ApiResponse> apiResponse;

    @OneToMany(mappedBy = "user")
    private List<ApiForecast> apiForecast;

    @OneToMany(mappedBy = "user")
    private List<ApiAir> apiAir;

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
}
