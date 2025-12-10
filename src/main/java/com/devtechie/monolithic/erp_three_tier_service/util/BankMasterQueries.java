package com.devtechie.monolithic.erp_three_tier_service.util;
public class BankMasterQueries 
{
	public static final String ADD_BANK_MASTER_DETAILS = "INSERT INTO spring_boot_tech.erp_st_bank_master("
			+ "bank_master_id,"
			+ "bank_code,bank_name,ifsc_code,bank_address) "
			+ "VALUES "
			+ "(:bankMasterId,:bankCode,:bankName,:ifscCode,:bankAddress)";
	
	public static final String FETCH_BANK_MASTER_DETAILS = "SELECT bank_master_id,bank_code,bank_name,ifsc_code,bank_address"
			+ " FROM spring_boot_tech.erp_st_bank_master ";
}