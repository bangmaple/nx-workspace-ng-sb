package com.bangmaple.lms.authentication.repositories;

import com.bangmaple.lms.authentication.entites.UsersEntity;
import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.repositories.query.AuthenticationQuery;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UsersRepository extends R2dbcRepository<UsersEntity, Long> {

  @Query(AuthenticationQuery.SIGN_IN)
  Mono<UsersEntity> checkAuthentication(String username, String password);

  @Query("INSERT INTO users(username, password, fullname, email, is_activated) VALUES('mapl22e', '123', 'sfs', 'sadd', false)")
  Mono<Void> register(RegistrationRequestModel registration);

}
