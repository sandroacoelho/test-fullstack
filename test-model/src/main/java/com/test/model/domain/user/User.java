package com.test.model.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User {

  @Id
  private Long id;

  @Email
  @NotEmpty
  private String name;

  @NotEmpty
  private String email;

  @NotEmpty
  private String phone;

  @NotEmpty
  private String sex;

}
