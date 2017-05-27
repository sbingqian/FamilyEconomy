package cn.bq.family.test;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cn.bq.family.util.WeChatUtil;

public class MainTestClass {
	
	
	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException{
		
		String s = WeChatUtil.getAccessToken();
		
		System.out.println(s);
	}
	
	
}
