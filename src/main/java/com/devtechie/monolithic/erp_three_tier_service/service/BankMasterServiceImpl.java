package com.devtechie.monolithic.erp_three_tier_service.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtechie.monolithic.erp_three_tier_service.controller.BankGstMstFeController;
import com.devtechie.monolithic.erp_three_tier_service.model.BankMaster;
import com.devtechie.monolithic.erp_three_tier_service.repository.BankMasterRepository;



@Service
public class BankMasterServiceImpl implements BankMasterService
{

	private static Logger log = LoggerFactory.getLogger(BankMasterServiceImpl.class);
	@Autowired
	BankMasterRepository bankMasterRepository;
	
	@Override
	public boolean addBankMasterDetails(BankMaster bankMaster) 
	{
		log.info("Calling method addBankMasterDetails inside service impl: {} ", bankMaster);
		Boolean result = false;
		try {
			result = bankMasterRepository.addBankMasterDetails(bankMaster);
			return result;
		} catch (Exception e) {
			System.err.println("ERROR: Service addBankGstMstData():" +e.getMessage());

		}
		return result;
	}

	@Override
	public List<BankMaster> fetchAllBankDetails() 
	{
		log.info("Calling method fetchAllBankDetails inside service impl");
		// TODO Auto-generated method stub
		List<BankMaster> bankGstMstlist = new ArrayList<>();
		try {
			bankGstMstlist = bankMasterRepository.fetchAllBankDetails();
			
			return bankGstMstlist;
		} catch (Exception e) {
			
		}
		return bankGstMstlist;
		
	}

}
