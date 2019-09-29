package com.my.java.util.exportjar;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 对账记录DO
 * @author liuhuaxin
 * @date 2019-07-22 18:31
 */
@Data
public class RecordDO {
  
    /**
     * 对账任务ID
     */
	@Comment(value = "任务id", isNeedComment = false)
    private int taskId;
    
    /**
     * 对账时间
     */
	@Comment(value = "对账时间", dateStyle = constant.DAY_STRING)
    private Date matchTime;
	
	@Comment("任务名称")
    private String name;
	
	@Comment("longType")
    private Long longType = 29L;
	
	@Comment("doubleType")
    private Double doubleType = new Double("2.290");
	
	@Comment("bigDecimalType")
    private BigDecimal bigDecimalType = new BigDecimal("3.3");
	
	public RecordDO(int taskId, Date matchTime, String name) {
		super();
		this.taskId = taskId;
		this.matchTime = matchTime;
		this.name = name;
	}
   
   
}