package com.dber.demo.pub;

import com.dber.demo.DemoApiConfig;
import com.dber.demo.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 以路径/pub/**开头的都是不需要权限校验的开放的公共api
 */
@FeignClient(DemoApiConfig.PLACE_HOLD_SERVICE_NAME)
@RequestMapping("/pub/")
public interface DemoPubApi {

  @RequestMapping("getUser")
  User getUser();
}
