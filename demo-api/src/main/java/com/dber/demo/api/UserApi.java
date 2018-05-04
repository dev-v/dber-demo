package com.dber.demo.api;

import com.dber.demo.entity.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserApi {

  @RequestMapping("get")
  User get();

  @PostMapping("update")
  int update(User user);
}
