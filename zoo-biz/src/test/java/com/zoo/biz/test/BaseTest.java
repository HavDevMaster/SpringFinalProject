package com.zoo.biz.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {
@LocalServerPort
private int serverport;

@Autowired
@Getter
protected TestRestTemplate restTemplate;

protected String getBaseUri() {
  return String.format("http://localhost:%d/zoo", serverport);
}
}
