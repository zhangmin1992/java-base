package com.my.test.listtomap;

public class SaasOrderReportCommissionResponse {

	private String payTime;
	
	private String biCommission;
	
	private String ciCommission;

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getBiCommission() {
		return biCommission;
	}

	public void setBiCommission(String biCommission) {
		this.biCommission = biCommission;
	}

	public String getCiCommission() {
		return ciCommission;
	}

	public void setCiCommission(String ciCommission) {
		this.ciCommission = ciCommission;
	}

	public SaasOrderReportCommissionResponse(String payTime, String biCommission, String ciCommission) {
		super();
		this.payTime = payTime;
		this.biCommission = biCommission;
		this.ciCommission = ciCommission;
	}
	
}
