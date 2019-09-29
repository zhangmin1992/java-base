package com.my.java.util.transfer;

import lombok.Data;

@Data
public class DiffDataModel {

	private String thirdPartyTradeNo;
	
	private String thirdPartyRefundNo;
	
	private Long totalFee;
	
	private Long refundFee;
	
	private String successTime;
	
	private int status;
}
