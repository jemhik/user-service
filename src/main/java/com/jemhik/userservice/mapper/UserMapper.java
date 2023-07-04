package com.jemhik.userservice.mapper;

import com.jemhik.userservice.entity.UserEntity;
import com.jemhik.userservice.model.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
  UserDto mapUserToUserDto(UserEntity user);

  UserEntity mapUserDtoToUser(UserDto userDto);
}
