package com.dber.demo.api;

import com.dber.demo.api.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserApi {

  @RequestMapping("/get")
  User get();
}
