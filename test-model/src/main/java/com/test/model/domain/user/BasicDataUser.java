package com.test.model.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BasicDataUser {

  private Long id;

  private String name;

  private String email;

  private String phone;

  private String sex;

}
