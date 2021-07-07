package com.bangmaple.lms.authentication.services;

import com.bangmaple.lms.authentication.models.AuthenticationRequestModel;
import com.bangmaple.lms.authentication.models.AuthenticationResponseModel;
import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.repositories.UsersRepository;
import com.bangmaple.lms.authentication.security.JWTUtil;
import com.bangmaple.lms.authentication.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

  private final UsersRepository usersRepository;
  private final JWTUtil jwtUtil;
  private final SecurityUtil securityUtil;

  public Mono<Map<String, Object>> authenticate(AuthenticationRequestModel authentication) {
      return usersRepository.checkAuthentication(authentication.getUsername())
          .mapNotNull(authenticatedUser -> securityUtil.comparePassword(authentication, authenticatedUser))
          .switchIfEmpty(Mono.empty())
        .flatMap(authenticatedUser -> Mono.just(Map
          .of(SecurityUtil.TOKEN_RESPONSE, jwtUtil.generateToken(authenticatedUser),
              SecurityUtil.USER_RESPONSE, new AuthenticationResponseModel(authenticatedUser))));
  }

  public Mono<Void> register(Mono<RegistrationRequestModel> registrationRequest) {
    return registrationRequest.flatMap(u -> usersRepository.register(u.getUsername(), u.getPassword(),
      u.getFullname(), u.getEmail()));
  }
}
