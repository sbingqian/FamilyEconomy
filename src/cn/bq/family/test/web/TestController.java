package cn.bq.family.test.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bq.family.test.domain.TestDemo;
import cn.bq.family.test.service.TestService;
import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping("/")
@Getter
@Setter
public class TestController {
	
	@Resource
	private TestService testService;
	
	@RequestMapping("/helloWorld.do")
	@ResponseBody
    public TestDemo helloWorld() {
		
		TestDemo td = testService.getDemo();
		
		return td;
		
    }
}
