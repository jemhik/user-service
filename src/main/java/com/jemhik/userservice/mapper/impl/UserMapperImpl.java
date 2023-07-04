package com.jemhik.userservice.mapper.impl;

import com.jemhik.userservice.entity.UserEntity;
import com.jemhik.userservice.mapper.UserMapper;
import com.jemhik.userservice.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

  @Override
  public UserDto mapUserToUserDto(UserEntity user) {
    return user == null ? null : UserDto.builder()
            .name(user.getName())
            .email(user.getEmail())
            .password(user.getPassword())
            .build();
  }

  @Override
  public UserEntity mapUserDtoToUser(UserDto userDto) {
    return userDto == null ? null : UserEntity.builder()
            .name(userDto.getName())
            .email(userDto.getEmail())
            .password(userDto.getPassword())
            .build();
  }
}
