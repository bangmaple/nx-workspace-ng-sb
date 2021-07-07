package com.bangmaple.lms.authentication.repositories;

import com.bangmaple.lms.authentication.entites.UsersEntity;
import com.bangmaple.lms.authentication.repositories.query.UsersRepositoryQuery;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UsersRepository extends R2dbcRepository<UsersEntity, Long> {

  @Query(UsersRepositoryQuery.SIGN_IN)
  Mono<UsersEntity> checkAuthentication(String username);

  @Query(UsersRepositoryQuery.SIGN_UP)
  Mono<Void> register(@Param("username") String username, @Param("password") String password,
                      @Param("fullname") String fullname, @Param("email") String email);

  Mono<Boolean> existsByUsername(String username);

  Mono<Boolean> existsByEmail(String email);
}
