package com.github.shanks.provider;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:remote-provider.xml" })
public class BootApplication {

	@Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new SpringApplicationBuilder(BootApplication.class).web(false).run(args);
        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
	}
}
