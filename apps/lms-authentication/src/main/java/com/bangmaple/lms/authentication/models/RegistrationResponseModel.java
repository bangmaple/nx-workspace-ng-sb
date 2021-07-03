package com.bangmaple.lms.authentication.models;

import com.bangmaple.lms.authentication.entites.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponseModel {
  private String username;
  private String fullname;

  public RegistrationResponseModel(UsersEntity user) {
    this.username = user.getUsername();
    this.fullname = user.getFullname();
  }
}
