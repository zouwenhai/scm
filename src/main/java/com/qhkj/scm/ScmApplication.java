package com.qhkj.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.qhkj.scm.mapper")
public class ScmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScmApplication.class, args);
	}

}
