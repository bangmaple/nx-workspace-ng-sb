package com.bangmaple.lms.authentication.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolesEntity {

  @Id
  @Column("id")
  private Integer id;

  @Column("user_id")
  private Integer userId;

  @Column("role_id")
  private Integer roleId;
}
