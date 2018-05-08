package com.dber.demo.web.controller;

import com.dber.demo.api.ExampleApi;
import com.dber.demo.api.entity.User;
import com.dber.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController implements ExampleApi {

  @Autowired
  private UserService userService;

  @Override
  public User get() {
    return userService.get(1);
  }

  @Override
  public String path(String path) {
    return "例子：" + path;
  }
}
