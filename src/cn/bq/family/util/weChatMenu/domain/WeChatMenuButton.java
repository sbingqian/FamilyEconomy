package cn.bq.family.util.weChatMenu.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeChatMenuButton {
	
	public String type;
	
	public String name;
	
	public String key;
	
	public String url;
	
	public String media_id;
	
	public List<WeChatMenuButton> sub_button;
	
	
}
