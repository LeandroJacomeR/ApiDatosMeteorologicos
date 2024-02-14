package com.lj.api.datos.repository.air;

import com.lj.api.datos.entity.air.ApiAirList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiAirListRepository extends JpaRepository<ApiAirList, Long> {
}
