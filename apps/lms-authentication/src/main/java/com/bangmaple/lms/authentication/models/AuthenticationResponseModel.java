package com.bangmaple.lms.authentication.models;

import com.bangmaple.lms.authentication.entites.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponseModel {
  private Long id;
  private String username;
  private String fullname;
  private String email;
  private boolean isActivated;

  public AuthenticationResponseModel(UsersEntity user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.fullname = user.getFullname();
    this.email = user.getEmail();
    this.isActivated = user.isActivated();
  }
}
