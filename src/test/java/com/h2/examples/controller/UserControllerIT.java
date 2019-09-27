package com.h2.examples.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.h2.examples.App;
import com.h2.examples.model.User;
import com.h2.examples.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerIT {

  protected MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @MockBean
  private UserService userService;

  private static final String ENDPOINT_URL = "/user/list";

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void whenGetUsersList_thenReturnList() throws Exception {
    List<User> users = new ArrayList<>();
    users.add(User.builder().id(1).lastName("lastname").firstName("firstname").build());
    when(userService.getUsersList()).thenReturn(users);
    mockMvc.perform(get(ENDPOINT_URL).
        contentType(MediaType.APPLICATION_JSON)).andDo(print()).andDo(print()).andExpect(jsonPath("$[0].lastName", Matchers.is("lastname")))
        .andExpect(jsonPath("$[0].id", Matchers.is(1))).andExpect(jsonPath("$[0].firstName", Matchers.is("firstname")));
  }


}
