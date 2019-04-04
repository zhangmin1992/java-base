package com.my.test.listtomap;

public class SaasOrderReportCommissionResponse2 {

	private String payTime;
	
	private String violationCommission;

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getViolationCommission() {
		return violationCommission;
	}

	public void setViolationCommission(String violationCommission) {
		this.violationCommission = violationCommission;
	}

	public SaasOrderReportCommissionResponse2(String payTime, String violationCommission) {
		super();
		this.payTime = payTime;
		this.violationCommission = violationCommission;
	}
	
}
