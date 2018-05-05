package com.dber.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.dber.demo")
@EnableDiscoveryClient
@EnableAutoConfiguration
@ConditionalOnExpression("#{!environment['spring.application.name'].endsWith('" + DemoApiConfig.SERVICE_NAME + "')}")
public class DemoApiConfig {
  public static final String SERVICE_NAME = "demo-service";
  public static final String PLACE_HOLD_SERVICE_NAME = "${dber.service." + SERVICE_NAME + ".name:" + SERVICE_NAME + "}";
}
