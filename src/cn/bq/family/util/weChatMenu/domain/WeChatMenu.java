package cn.bq.family.util.weChatMenu.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

@Setter
public class WeChatMenu {
	
	public List<WeChatMenuButton> button;
	
	public List<WeChatMenuButton> getButton() {
		if(button == null){
			button = new ArrayList<WeChatMenuButton>();
		}
		return button;
	}
	
	
	
}
