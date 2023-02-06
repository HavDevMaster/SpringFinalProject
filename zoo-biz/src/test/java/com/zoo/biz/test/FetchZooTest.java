/*package com.zoo.biz.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import lombok.Getter;

  @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
  @ActiveProfiles("test")
  @Sql(scripts = {
      "classpath:
      "classpath:
      config = @SqlConfig(encoding = "utf-8"))
  
  class FetchZooTest extends FetchZooTestSupport {

    @Autowired
    @Getter
    private TestRestTemplate restTemplate;
    
    @LocalServerPort
    private int serverPort;
  
  @Test
  void test() {
    fail("Not yet implemented");
    
    
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

  }

}
*/