package com.test.model.domain.user;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User implements Serializable{

  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name ="id")
  private Long id;

  @NotEmpty
  @Column(name ="name")
  private String name;

  @Email
  @NotEmpty
  @Column(name ="email")
  private String email;

  @NotEmpty
  @Column(name ="phone")
  private String phone;

  @NotEmpty
  @Column(name ="sex")
  private String sex;

}
