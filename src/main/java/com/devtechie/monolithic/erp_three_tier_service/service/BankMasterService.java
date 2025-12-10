package com.devtechie.monolithic.erp_three_tier_service.service;

import java.util.List;

import com.devtechie.monolithic.erp_three_tier_service.model.BankMaster;



public interface BankMasterService 
{
	public boolean addBankMasterDetails(BankMaster bankMaster);

	public List<BankMaster> fetchAllBankDetails();
}
