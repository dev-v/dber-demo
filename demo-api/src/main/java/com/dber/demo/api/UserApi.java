package com.dber.demo.api;

import com.dber.demo.DemoApiConfig;
import com.dber.demo.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(DemoApiConfig.PLACE_HOLD_SERVICE_NAME)
@RequestMapping("/user")
public interface UserApi {

  @RequestMapping("get/{id}")
  User get(@PathVariable("id") long id);

  @PostMapping("update")
  int update(@RequestBody User user);
}
