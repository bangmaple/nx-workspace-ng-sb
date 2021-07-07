package com.bangmaple.lms.authentication.entites;

import com.bangmaple.lms.authentication.constants.UsersEntityConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(UsersEntityConstant.TABLE_NAME)
public class UsersEntity {
  @Id
  @Column(UsersEntityConstant.ID)
  private Long id;

  @Column(UsersEntityConstant.USERNAME)
  private String username;

  @Column(UsersEntityConstant.PASSWORD)
  private String password;

  @Column(UsersEntityConstant.FULLNAME)
  private String fullname;

  @Column(UsersEntityConstant.EMAIL)
  private String email;

  @Column(UsersEntityConstant.IS_ACTIVATED)
  private boolean isActivated;

  @Column(UsersEntityConstant.IS_LOCKED)
  private boolean isLocked;

  @Column(UsersEntityConstant.ROLE)
  private String role;

}
