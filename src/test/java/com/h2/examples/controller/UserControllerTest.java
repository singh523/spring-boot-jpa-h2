package com.h2.examples.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.h2.examples.model.User;
import com.h2.examples.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserControllerTest {

  private UserController userController;

  @Mock
  private UserService userService;

  @Before
  public void setUp() throws Exception {
    userController = new UserController(userService);
  }

  @Test
  public void getUsersList() {
    List<User> list = new ArrayList<>();
    list.add(User.builder().id(1).firstName("user").lastName("last").build());
    when(userService.getUsersList()).thenReturn(list);
    List<User> users = userController.getUsersList();
    assertEquals(1, users.get(0).getId());
  }

  @Test
  public void saveUser() {
    doNothing().when(userService).saveUser(any());
    userController.saveUser(any(User.class));
    verify(userService).saveUser(any());
  }
}
