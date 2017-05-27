package cn.bq.family.test.service;

import org.springframework.stereotype.Service;

import cn.bq.family.test.domain.TestDemo;

@Service
public class TestService {
	
	public TestDemo getDemo(){
		TestDemo td = new TestDemo();
		td.setName("Name");
		td.setSex("Sex");
		return td;
	}
	
}
