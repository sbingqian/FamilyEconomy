package cn.bq.family.util.weChatMenu.util;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.bq.family.common.CommonConstants;
import cn.bq.family.common.WeChatURLEnum;
import cn.bq.family.util.HttpUtil;
import cn.bq.family.util.WeChatUtil;
import cn.bq.family.util.weChatMenu.domain.WeChatMenu;
import cn.bq.family.util.weChatMenu.domain.WeChatMenuButton;;

public class WeChatMenuGenerateUtil {

	public static void createMenu() throws IOException {

		WeChatMenuButton firstLevelBtn1 = new WeChatMenuButton();

		firstLevelBtn1.setName("记账");
		firstLevelBtn1.setType("view");
		firstLevelBtn1.setUrl("");

		WeChatMenuButton firstLevelBtn2 = new WeChatMenuButton();
		firstLevelBtn2.setName("我们的账单");
		firstLevelBtn2.setType("view");
		firstLevelBtn2.setUrl("");

		WeChatMenu wcm = new WeChatMenu();
		wcm.getButton().add(firstLevelBtn1);
		wcm.getButton().add(firstLevelBtn2);

		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(Include.NON_NULL);

		String menuStr = mapper.writeValueAsString(wcm);

		System.out.println(menuStr);

		String rst = HttpUtil.httpClient(CommonConstants.getWeChatMethodURL(WeChatURLEnum.MENU_CREATE),
				RequestMethod.POST, menuStr);

		System.out.println(rst);

	}

	public static void main(String args[]) throws IOException {
		
		WeChatUtil.getAccessToken();

		WeChatMenuGenerateUtil.createMenu();
	}

}
