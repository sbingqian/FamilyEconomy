package cn.bq.family.dailyConsume.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bq.family.common.domain.ConsumeLog;
import cn.bq.family.common.mapper.ConsumeLogMapper;
import lombok.Setter;

@Service("ConsumeService")
@Setter
public class ConsumeService {
	
	@Resource
	private ConsumeLogMapper consumeLogMapper;
	
	public List<ConsumeLog> queryLog(){
		
		ConsumeLog consumeLog = new ConsumeLog();
		
		return (List<ConsumeLog>) consumeLogMapper.queryConsumerLog(consumeLog);
	}
	
	
	
	public int insertLog(){
		
		ConsumeLog consumeLog = new ConsumeLog();
		
		consumeLog.setConsumeDate(new Date());
		
		consumeLog.setConsumer("fanfan");
		
		consumeLog.setMount("12");
		
		consumeLog.setType("1");
		
		consumeLog.setWay("1");
		
		return consumeLogMapper.insertConsumerLog(consumeLog);
	}

}
