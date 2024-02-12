package com.lj.api.datos.repository;

import com.lj.api.datos.entity.response.Coord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordRepository extends JpaRepository<Coord, Long> {
}
