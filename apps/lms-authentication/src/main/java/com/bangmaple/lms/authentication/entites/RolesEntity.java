package com.bangmaple.lms.authentication.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesEntity {

  @Id
  @Column("id")
  private Integer id;

  @Column("name")
  private String name;

  @Column("description")
  private String description;

}
