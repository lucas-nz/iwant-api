package com.noobz.iwant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author zhousz
 * @date 2019/12/25  12:26
 */
@SpringBootApplication
@MapperScan("com.noobz.iwant.mapper")
public class IwantApplication {

  public static void main(String[] args) {
    SpringApplication.run(IwantApplication.class, args);
  }

}
