package com.bangmaple.lms.authentication.repositories;

import com.bangmaple.lms.authentication.entites.RolesEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RolesRepository extends R2dbcRepository<RolesEntity, Integer> {
  Mono<RolesEntity> findByName(String name);
}
