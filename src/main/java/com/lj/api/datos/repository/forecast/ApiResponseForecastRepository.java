package com.lj.api.datos.repository.forecast;

import com.lj.api.datos.entity.forecast.ApiResponseForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiResponseForecastRepository extends JpaRepository<ApiResponseForecast, Long> {
}
