package com.qhkj.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.qhkj.scm.mapper")
@ComponentScan(value = {"com.qhkj.scm.controller.user", "com.qhkj.scm.service", "com.qhkj.scm.common.aop", "com.qhkj.scm.swager"})
public class ScmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScmApplication.class, args);
    }

}
