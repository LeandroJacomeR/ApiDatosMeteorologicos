package com.lj.api.datos.repository.response;

import com.lj.api.datos.entity.response.Clouds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudsRepository extends JpaRepository<Clouds, Long> {
}
