package com.bangmaple.lms.authentication.controllers;

import com.bangmaple.lms.authentication.models.AuthenticationRequestModel;
import com.bangmaple.lms.authentication.models.AuthenticationResponseModel;
import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("signin")
  public Mono<ResponseEntity<Mono<AuthenticationResponseModel>>> signin(
    @RequestBody Mono<AuthenticationRequestModel> authenticationRequest) {
      return Mono.just(ResponseEntity.ok(authenticationService.authenticate(authenticationRequest)));
  }

  @PostMapping("signup")
  public Mono<ResponseEntity<?>> signup(@RequestBody @Validated Mono<RegistrationRequestModel> registrationRequest) {
    return Mono.just(ResponseEntity.ok(authenticationService.register(registrationRequest)));
  }
}
