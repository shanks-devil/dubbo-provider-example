package com.github.shanks.provider.demo;

import java.util.UUID;

import org.joda.time.DateTime;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.shanks.api.ExampleService;
import com.github.shanks.domain.Demo;

@Service(version="1.0.0")
public class ExampleServiceImpl implements ExampleService {

	public Demo getOne() {
		Demo demo = new Demo();
		demo.setTime(DateTime.now().toDate());
		demo.setTitle(UUID.randomUUID().toString());
		return demo;
	}

}
