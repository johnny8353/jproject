package com.johnny.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @RestController和@RequestMapping注解 Example类上使用的第一个注解是 @RestController ，这被称为构造型
 *                                   （stereotype）注解。它为阅读代码的人提供暗示（这是一个支持REST的控制
 *                                   器），对于Spring，该类扮演了一个特殊角色。在本示例中，我们的类是一个web
 * @Controller ，所以当web请求进来时，Spring会考虑是否使用它来处理。
 * @RequestMapping 注解提供路由信息，它告诉Spring任何来自"/"路径的HTTP请 求都应该被映射到 home
 *                 方法。 @RestController 注解告诉Spring以字符串的形 式渲染结果，并直接返回给调用者。
 *                 注： @RestController 和 @RequestMapping 是Spring MVC中的注解（它们不
 *                 是Spring Boot的特定部分），
 * 
 * @EnableAutoConfiguration注解 第二个类级别的注解是 @EnableAutoConfiguration ，这个注解告诉Spring
 *                            Boot 根据添加的jar依赖猜测你想如何配置Spring。由于
 *                            spring-boot-starter-web 添 加了Tomcat和Spring
 *                            MVC，所以auto-configuration将假定你正在开发一个web应
 *                            用，并对Spring进行相应地设置。
 *                            Starters和Auto-Configuration：Auto-configuration设计成可以跟"Starters"一起很
 *                            好的使用，但这两个概念没有直接的联系。你可以自由地挑选starters以外的jar依
 *                            赖，Spring Boot仍会尽最大努力去自动配置你的应用。
 *
 * 
 */
@RestController
@EnableWebMvc
@EnableAutoConfiguration
public class Example implements EmbeddedServletContainerCustomizer {
	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUser() {
		// ...
		return "Hello World22!";
	}

	public static void main(String[] args) throws Exception {
		/**
		 * 应用程序的最后部分是main方法，这是一个标准的方法，它遵循Java对于一个应用 程序入口点的约定。我们的main方法通过调用 run
		 * ，将业务委托给了Spring Boot
		 * 的SpringApplication类。SpringApplication将引导我们的应用，启动Spring，相应
		 * 地启动被自动配置的Tomcat web服务器。我们需要将 Example.class 作为参数传 递给 run
		 * 方法，以此告诉SpringApplication谁是主要的Spring组件，并传递args数 组以暴露所有的命令行参数。
		 */
		SpringApplication.run(Example.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8090);
		container.setContextPath("/spring");
	}
}