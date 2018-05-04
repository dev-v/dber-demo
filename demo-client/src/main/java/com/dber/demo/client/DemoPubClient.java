package com.dber.demo.client;

import com.dber.demo.pub.DemoPubApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("demo-service")
public interface DemoPubClient extends DemoPubApi {
}
