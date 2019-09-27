package com.h2.examples.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.h2.examples.model.User;
import com.h2.examples.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/list", produces = APPLICATION_JSON_VALUE)
  public List<User> getUsersList() {

    return userService.getUsersList();
  }

  @PostMapping(value = "/saveUser")
  public ResponseEntity saveUser(@RequestBody User user) {

    userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }


}
