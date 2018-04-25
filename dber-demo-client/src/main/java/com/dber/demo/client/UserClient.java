package com.dber.demo.client;

import com.dber.demo.api.UserApi;
import com.dber.demo.api.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "demo-service", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient extends UserApi {
}

@Component
class UserClientFallbackFactory implements FallbackFactory<UserClient> {
  @Override
  public UserClient create(Throwable cause) {
    return new UserClient() {
      @Override
      public User get() {
        User user = new User();
        user.setName("fallback");
        return user;
      }
    };
  }
}
