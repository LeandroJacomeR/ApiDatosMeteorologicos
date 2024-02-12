package com.lj.api.datos.dto.api.response;

import lombok.Data;

@Data
public class SysDto {
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
    private String pod;
}
