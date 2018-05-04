package com.dber.demo.client;

import com.dber.demo.api.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "demo-service")
public interface UserClient extends UserApi {
}
