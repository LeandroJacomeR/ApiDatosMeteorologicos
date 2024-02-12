package com.lj.api.datos.repository;

import com.lj.api.datos.entity.response.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiResponseRepository extends JpaRepository<ApiResponse, Long> {
}
