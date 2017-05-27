package cn.bq.family.util;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.bq.family.common.CommonConstants;
import cn.bq.family.common.WeChatURLEnum;

public class WeChatUtil {
	
	/**
	 * 获取微信Token
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static String getAccessToken() throws JsonParseException, JsonMappingException, IOException{
		
		
		if (StringUtils.isEmpty(CommonConstants.ACCESS_TOKEN)){
			
			String url = CommonConstants.getWeChatMethodURL(WeChatURLEnum.TOKEN);
			
			String rst = HttpUtil.httpClient(url, RequestMethod.GET, "");
			
			ObjectMapper mapper = new ObjectMapper(); 
			
			Map<?,?> rsstMap = mapper.readValue(rst, Map.class);
			
			if (rsstMap.get("access_token") != null){
				CommonConstants.ACCESS_TOKEN = String.valueOf(rsstMap.get("access_token"));
			}
		}
				
		return CommonConstants.ACCESS_TOKEN;
	}
	
	
}
