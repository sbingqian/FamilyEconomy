package cn.bq.family.common.mapper;

import java.util.List;


import cn.bq.family.common.domain.ConsumeLog;

public interface ConsumeLogMapper {
	
	public List<ConsumeLog> queryConsumerLog(ConsumeLog consumeLog);
	
	public int insertConsumerLog(ConsumeLog consumeLog);
	
}
