package com.zoo.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class zooBiz extends SpringBootServletInitializer{

  public static void main(String[] args) {
   SpringApplication.run(zooBiz.class, args);
  }

}
