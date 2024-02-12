package com.lj.api.datos.repository;

import com.lj.api.datos.entity.response.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
