package cn.bq.family.common.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("ConsumeLog")
public class ConsumeLog {
	
	private String id;
	
	private String consumer;
	
	private String mount;
	
	private String type;
	
	private String way;
	
	private Date consumeDate;
	
}
