package com.lj.api.datos.repository;

import com.lj.api.datos.entity.response.Wind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindRepository extends JpaRepository<Wind, Long> {
}
