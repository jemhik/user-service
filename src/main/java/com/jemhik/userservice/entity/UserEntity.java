package com.jemhik.userservice.entity;

import com.jemhik.userservice.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;


import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

  @Id
  @UuidGenerator
  private UUID id;

  private String name;

  private String email;

  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;
}
