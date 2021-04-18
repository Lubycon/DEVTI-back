package com.lubycon.devti.domain.user.api;


import com.lubycon.devti.domain.user.dto.UserGetDto;
import com.lubycon.devti.domain.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value = "User")
public class UserController {

  private final UserService userService;

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "User 정보 조회")
  public ResponseEntity<UserGetDto> get(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

}
