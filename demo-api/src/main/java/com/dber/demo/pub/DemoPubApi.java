package com.dber.demo.pub;

import com.dber.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 以路径/pub/**开头的都是不需要权限校验的开放的公共api
 */
@RequestMapping("/pub/")
public interface DemoPubApi {

  @RequestMapping("getUser")
  User getUser();
}
