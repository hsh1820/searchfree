package com.kh.searchfree.admin.model.vo;

import java.sql.Date;

public class ReportAll {

	private int reportCode;
	private String memberId;
	private Date reportCreateDT;
	private char reportStatus;
	

	public ReportAll() {
		super();
	}
	
	
	public ReportAll(int reportCode, String memberId, Date reportCreateDT, char reportStatus) {
		super();
		this.reportCode = reportCode;
		this.memberId = memberId;
		this.reportCreateDT = reportCreateDT;
		this.reportStatus = reportStatus;
	}


	public char getReportStatus() {
		return reportStatus;
	}
	
	public void setReportStatus(char reportStatus) {
		this.reportStatus = reportStatus;
	}
	public int getReportCode() {
		return reportCode;
	}

	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getReportCreateDT() {
		return reportCreateDT;
	}

	public void setReportCreateDT(Date reportCreateDT) {
		this.reportCreateDT = reportCreateDT;
	}


	@Override
	public String toString() {
		return "ReportAll [reportCode=" + reportCode + ", memberId=" + memberId + ", reportCreateDT=" + reportCreateDT
				+ ", reportStatus=" + reportStatus + "]";
	}

	
	
	
	
}
