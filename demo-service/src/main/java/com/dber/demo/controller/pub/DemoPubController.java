package com.dber.demo.controller.pub;

import com.dber.demo.entity.User;
import com.dber.demo.pub.DemoPubApi;
import com.dber.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoPubController implements DemoPubApi {

  @Autowired
  private UserService userService;

  @Override
  public User getUser() {
    User user = userService.get(1);
    user.setAddress("public..........");
    return user;
  }
}
