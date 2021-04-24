package com.lubycon.devti.domain.user.service;

import com.lubycon.devti.domain.user.dao.UserRepository;
import com.lubycon.devti.domain.user.dto.UserGetDto;
import com.lubycon.devti.domain.user.dto.UserPostDto.UserPostReqDto;
import com.lubycon.devti.domain.user.entity.User;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Transactional(readOnly = true)
  public UserGetDto getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id.toString()));

    UserGetDto userGetDto = user.toDto();
    return userGetDto;
  }

  @Transactional(readOnly = true)
  public UserGetDto getUserByEmail(String email) {
    User user = userRepository.findByEmail(email);

    if (user != null) {
      UserGetDto userGetDto = user.toDto();
      return userGetDto;
    }
    return null;
  }

  public UserGetDto create(UserPostReqDto userPostReqDto) {
    User user = User.builder()
        .name(userPostReqDto.getName())
        .phone(userPostReqDto.getPhone())
        .email(userPostReqDto.getEmail())
        .build();
    User savedUser = userRepository.save(user);
    return modelMapper.map(savedUser, UserGetDto.class);
  }

}
