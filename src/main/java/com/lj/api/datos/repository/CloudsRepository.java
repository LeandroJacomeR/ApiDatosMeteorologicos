package com.lj.api.datos.repository;

import com.lj.api.datos.entity.response.Clouds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudsRepository extends JpaRepository<Clouds, Long> {
}
