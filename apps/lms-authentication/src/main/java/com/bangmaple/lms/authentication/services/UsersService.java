package com.bangmaple.lms.authentication.services;

import com.bangmaple.lms.authentication.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {

  private final UsersRepository usersRepository;

  public Mono<Boolean> isUserExistedByUsername(String username) {
    return usersRepository.existsByUsername(username);
  }

  public Mono<Boolean> isUserExistedByEmail(String email) {
    return usersRepository.existsByEmail(email);
  }
}
