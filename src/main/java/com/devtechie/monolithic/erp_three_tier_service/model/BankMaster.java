package com.devtechie.monolithic.erp_three_tier_service.model;

public class BankMaster 
{
	private String bankMasterId;
	private String bankCode;
	private String bankName;
	private String ifscCode;
	private String bankAddress;
	
	public String getBankMasterId() {
		return bankMasterId;
	}
	public void setBankMasterId(String bankMasterId) {
		this.bankMasterId = bankMasterId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	@Override
	public String toString() {
		return "BankMaster [bankMasterId=" + bankMasterId + ", bankCode=" + bankCode + ", bankName=" + bankName
				+ ", ifscCode=" + ifscCode + ", bankAddress=" + bankAddress + "]";
	}
	
	
}
