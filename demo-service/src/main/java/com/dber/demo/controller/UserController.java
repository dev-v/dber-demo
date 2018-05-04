package com.dber.demo.controller;

import com.dber.demo.api.UserApi;
import com.dber.demo.entity.User;
import com.dber.demo.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserController implements UserApi {
  private static final Log log = LogFactory.getLog(UserController.class);

  private long id = new Random().nextLong();

  @Autowired
  private UserService userService;

  @Override
  public User get() {
    return userService.get(1);
  }

  @Override
  public int update(@RequestBody User user) {
    return userService.update(user);
  }
}
