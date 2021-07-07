package com.bangmaple.lms.authentication.controllers;

import com.bangmaple.lms.authentication.models.AuthenticationRequestModel;
import com.bangmaple.lms.authentication.models.AuthenticationResponseModel;
import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.services.AuthenticationService;
import com.bangmaple.lms.authentication.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("signin")
  public Mono<ResponseEntity<Object>> signin(@RequestBody @Validated AuthenticationRequestModel auth) {
    return authenticationService.authenticate(auth)
      .flatMap(authSuccess -> Mono.just(ResponseEntity.status(HttpStatus.OK)
        .header(HttpHeaders.AUTHORIZATION, String.valueOf(authSuccess.get(SecurityUtil.TOKEN_RESPONSE)))
        .body(authSuccess.get(SecurityUtil.USER_RESPONSE))))
      .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
  }

  @PostMapping("signup")
  public Mono<ResponseEntity<?>> signup(@RequestBody @Validated Mono<RegistrationRequestModel> registrationRequest) {
    return Mono.just(ResponseEntity.ok(authenticationService.register(registrationRequest)));
  }

  @PostMapping("forgotpwd")
  public Mono<ResponseEntity<?>> forgotpwd() {
    return null;
  }
}
