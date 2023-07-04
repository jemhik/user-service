package com.jemhik.userservice.service;

import com.jemhik.userservice.model.UserDto;

public interface UserService {

  public UserDto getUser(String email);

  public UserDto createUser(UserDto user);

  public boolean authenticateUser(UserDto user);

  public UserDto updateUser(UserDto user);
}
