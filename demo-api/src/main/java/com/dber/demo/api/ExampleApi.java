package com.dber.demo.api;

import com.dber.demo.api.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(DemoApiConfig.PLACE_HOLD_SERVICE_NAME)
@RequestMapping("pub/example")
public interface ExampleApi {

  @RequestMapping("user")
  User get();

  @RequestMapping("{path}")
  String path(@PathVariable("path") String path);
}
