package cn.bq.family.weChat.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bq.family.util.HttpUtil;

@Controller
@RequestMapping("/weChat")
public class WeChatBackgroundController {

	@RequestMapping(method=RequestMethod.GET,value="/index.do")
	public void weChatHandShake(HttpServletRequest req, HttpServletResponse resp){
		String echostr = req.getParameter("echostr");
		HttpUtil.write(resp, echostr);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/index.do")
	public void handleWeChatInfo(HttpServletRequest req, HttpServletResponse resp){
		
		String echostr = req.getParameter("post");
		HttpUtil.write(resp, echostr);
		

	}
	
	
	
}
