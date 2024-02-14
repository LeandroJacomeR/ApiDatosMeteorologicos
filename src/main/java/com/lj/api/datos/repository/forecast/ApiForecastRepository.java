package com.lj.api.datos.repository.forecast;

import com.lj.api.datos.entity.forecast.ApiForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiForecastRepository extends JpaRepository<ApiForecast, Long> {
}
