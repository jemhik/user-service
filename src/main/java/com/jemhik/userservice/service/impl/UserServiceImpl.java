package com.jemhik.userservice.service.impl;

import com.jemhik.userservice.entity.UserEntity;

import com.jemhik.userservice.entity.enums.Role;
import com.jemhik.userservice.exeption.EntityNotFoundException;
import com.jemhik.userservice.exeption.UserAlreadyExistsException;
import com.jemhik.userservice.mapper.UserMapper;
import com.jemhik.userservice.model.UserDto;
import com.jemhik.userservice.repository.UserRepository;
import com.jemhik.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final BCryptPasswordEncoder passwordEncoder;


  @Override
  public UserDto getUser(String email) {
    log.info("UserService getUser with email {}", email);
    UserEntity user = userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    return userMapper.mapUserToUserDto(user);
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    log.info("UserService createUser with email {}", userDto.getEmail());
    if (userRepository.existsByEmail((userDto.getEmail()))) {
      throw new UserAlreadyExistsException();
    }

    UserEntity user = userMapper.mapUserDtoToUser(userDto);
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    user.setRole(Role.USER);
    user = userRepository.save(user);
    return userMapper.mapUserToUserDto(user);
  }

  @Override
  public boolean authenticateUser(UserDto userDto) {
    log.info("UserService authenticateUser with email {}", userDto.getEmail());
    UserEntity user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(EntityNotFoundException::new);
    return user.getPassword().equals(userDto.getPassword());
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    log.info("UserService updateUser with email {}", userDto.getEmail());

    UserEntity user = userMapper.mapUserDtoToUser(userDto);

    UserEntity oldUser = userRepository
            .findByEmail(userDto.getEmail())
            .orElseThrow(EntityNotFoundException::new);

    user.setPassword(oldUser.getPassword());
    user.setId(oldUser.getId());
    user.setRole(oldUser.getRole());

    user = userRepository.save(user);

    return userMapper.mapUserToUserDto(user);
  }


}
