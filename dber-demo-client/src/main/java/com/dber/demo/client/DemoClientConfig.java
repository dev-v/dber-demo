package com.dber.demo.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan("com.dber.demo.client")
public class DemoClientConfig {
}
