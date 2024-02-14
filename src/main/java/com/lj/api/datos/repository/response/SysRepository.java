package com.lj.api.datos.repository.response;

import com.lj.api.datos.entity.response.Sys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRepository extends JpaRepository<Sys, Long> {
}
