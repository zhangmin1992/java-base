package com.my.test.listtomap;

public class SaasOrderReportCommissionResponse2 {

	private String payTime;
	
	private Long vioCommissionFee = 0L;

	public String getPayTime() {
		return payTime;
	}

	public Long getVioCommissionFee() {
		return vioCommissionFee;
	}

	public void setVioCommissionFee(Long vioCommissionFee) {
		this.vioCommissionFee = vioCommissionFee;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public SaasOrderReportCommissionResponse2(String payTime, Long vioCommissionFee) {
		super();
		this.payTime = payTime;
		this.vioCommissionFee = vioCommissionFee;
	}
}
