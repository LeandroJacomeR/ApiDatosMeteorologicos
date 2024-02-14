package com.lj.api.datos.repository.response;

import com.lj.api.datos.entity.response.Wind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindRepository extends JpaRepository<Wind, Long> {
}
