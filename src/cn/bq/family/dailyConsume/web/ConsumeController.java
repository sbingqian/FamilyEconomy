package cn.bq.family.dailyConsume.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.bq.family.dailyConsume.service.ConsumeService;

@Controller
@RequestMapping("/")
public class ConsumeController {
	
	@Resource
	private ConsumeService consumeService;
	
	@RequestMapping("/handler.do")
	@ResponseBody
	public Object handlWithCommond(HttpServletRequest req, HttpServletResponse resp){
		
		int serviceCode = 0;
		
		try {
			
			serviceCode = Integer.parseInt(req.getParameter("serviceCode"));
			
		} catch(Exception e){
			
			return "错误的业务代码";
			
		}
		
		
		switch (serviceCode) {
		
		case 1001: 
			
			return consumeService.queryLog();
		
		
		case 1002: 
			
			return consumeService.insertLog();
			
			
		default :
			
			return serviceCode;
		
		}
		
	}
	
	
	
	
	
	@RequestMapping("/index.do")
	public ModelAndView index(HttpServletRequest req, HttpServletResponse resp){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/homePage.do")
	public ModelAndView homePage(HttpServletRequest req, HttpServletResponse resp){
		return new ModelAndView("homePage");
	}
	
	
}
