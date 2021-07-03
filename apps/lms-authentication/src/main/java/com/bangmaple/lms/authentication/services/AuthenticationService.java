package com.bangmaple.lms.authentication.services;

import com.bangmaple.lms.authentication.models.AuthenticationRequestModel;
import com.bangmaple.lms.authentication.models.AuthenticationResponseModel;
import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.models.RegistrationResponseModel;
import com.bangmaple.lms.authentication.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AuthenticationService {

  @Autowired
  private UsersRepository usersRepository;

  public Mono<AuthenticationResponseModel> authenticate(Mono<AuthenticationRequestModel> authentication) {
      return authentication.flatMap(auth -> usersRepository
        .checkAuthentication(auth.getUsername(), auth.getPassword())
        .map(AuthenticationResponseModel::new));
  }

  public Mono<Void> register(Mono<RegistrationRequestModel> registrationRequest) {
    return registrationRequest.flatMap(u -> usersRepository.register(u));
  }
}
