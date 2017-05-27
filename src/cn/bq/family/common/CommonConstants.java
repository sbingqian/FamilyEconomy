package cn.bq.family.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CommonConstants {

	public static String APP_ID = "wx14df213a8fcced93";

	public static String APP_SCERET = "150b3fa17ba48cede8445d941b14f93b";

	public static String ACCESS_TOKEN;

	private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ APP_ID + "&secret=" + APP_SCERET;

	private static String MENU_CREATE_URL = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=$token$";

	/**
	 * 获取微信接口Url
	 * 
	 * @param urlName
	 *            token：获取accessToken
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static String getWeChatMethodURL(WeChatURLEnum urlName)
			throws JsonParseException, JsonMappingException, IOException {

		if (WeChatURLEnum.TOKEN == urlName) {
			return ACCESS_TOKEN_URL;
		}

		if (WeChatURLEnum.MENU_CREATE == urlName) {
			return MENU_CREATE_URL.replace("$token$", ACCESS_TOKEN);
		}

		return "";
	}

}
