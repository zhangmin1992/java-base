package com.my.test.listtomap;

public class SaasOrderReportCommissionResponse {

	private String payTime;
	
	private Long biCommission = 0L;
	
	private Long ciCommission = 0L;

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public Long getBiCommission() {
		return biCommission;
	}

	public void setBiCommission(Long biCommission) {
		this.biCommission = biCommission;
	}

	public Long getCiCommission() {
		return ciCommission;
	}

	public void setCiCommission(Long ciCommission) {
		this.ciCommission = ciCommission;
	}

	public SaasOrderReportCommissionResponse(String payTime, Long biCommission, Long ciCommission) {
		super();
		this.payTime = payTime;
		this.biCommission = biCommission;
		this.ciCommission = ciCommission;
	}
}
