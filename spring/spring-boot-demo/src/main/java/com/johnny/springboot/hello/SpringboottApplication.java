package com.johnny.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/**
 * 有可能会因为8080端口被第一个应用占用而导致第二个应用无法启动，这时就需要修改其中一个工程的启动端口。
可以通过实现EmbeddedServletContainerCustomizer接口来实现：
 */


@SpringBootApplication
public class SpringboottApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringboottApplication.class, args);
	}
	
	

}
