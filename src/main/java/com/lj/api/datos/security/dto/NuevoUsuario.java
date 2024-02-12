package com.lj.api.datos.security.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NuevoUsuario {

    @NotBlank
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
}
