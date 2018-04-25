package com.dber.demo.controller;

import com.dber.demo.api.UserApi;
import com.dber.demo.api.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserController implements UserApi {
  private static final Log log = LogFactory.getLog(UserController.class);

  private long id = new Random().nextLong();

  @Override
  public User get() {
    User user = new User();
    user.setAddress("测试用户");
    user.setId(id);
    return user;
  }
}
