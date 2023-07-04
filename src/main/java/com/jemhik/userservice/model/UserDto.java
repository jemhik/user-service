package com.jemhik.userservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  @NotEmpty(message = "Name is required")
  private String name;

  @NotEmpty(message = "Email is required")
  @Email
  private String email;

  @NotEmpty
  private String password;
}
