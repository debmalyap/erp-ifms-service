package com.devtechie.monolithic.erp_three_tier_service.repository;

import java.util.List;

import com.devtechie.monolithic.erp_three_tier_service.model.BankMaster;

public interface BankMasterRepository 
{
	public boolean addBankMasterDetails(BankMaster bankMaster);

	public List<BankMaster> fetchAllBankDetails();
}
