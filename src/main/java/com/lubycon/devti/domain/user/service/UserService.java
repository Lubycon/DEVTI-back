package com.lubycon.devti.domain.user.service;

import com.lubycon.devti.domain.user.dao.UserRepository;
import com.lubycon.devti.domain.user.dto.UserGetDto;
import com.lubycon.devti.domain.user.entity.User;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public UserGetDto getUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id.toString()));

    UserGetDto userGetDto = user.toDto();
    return userGetDto;
  }
}
