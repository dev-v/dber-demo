package com.dber.demo.client;

import com.alibaba.fastjson.JSON;
import com.dber.demo.api.UserApi;
import com.dber.demo.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoClientConfig.class})
public class DemoApiApplicationTests {

  private static final Log log = LogFactory.getLog(DemoApiApplicationTests.class);

  @Autowired
  private UserApi userApi;

  @Autowired
  private DemoPubClient demoPubClient;

  @Test
  public void contextLoads() {
  }

  @Test
  public void get() {
    log.info("*********************************************************************************************************************");
    log.info(JSON.toJSONString(userApi.get()));
    log.info("*********************************************************************************************************************");
  }

  @Test
  public void pubGet() {
    log.info("*********************************************************************************************************************");
    log.info(JSON.toJSONString(demoPubClient.getUser()));
    log.info("*********************************************************************************************************************");
  }

  @Test
  public void update() {
    User user = new User();
    user.setId(1l);
    user.setAddress("aaaa" + Math.random());
    log.info(userApi.update(user));
  }
}
