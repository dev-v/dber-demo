package com.dber.demo;


import com.dber.demo.api.DemoApiConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApiConfig.class})
public class DemoApiApplicationTests {

  private static final Log log = LogFactory.getLog(DemoApiApplicationTests.class);

  @Test
  public void contextLoads() {
    log.info("*********************************************************************************************************************");
    log.info("*********************************************************************************************************************");

  }
}
