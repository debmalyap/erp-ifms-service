package com.devtechie.monolithic.erp_three_tier_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.devtechie.monolithic.erp_three_tier_service.model.BankMaster;
import com.devtechie.monolithic.erp_three_tier_service.service.BankMasterService;



@Controller
public class BankGstMstFeController 
{
	
	private static Logger log = LoggerFactory.getLogger(BankGstMstFeController.class);
	
	@Autowired
	BankMasterService bankMasterService;
	
	@GetMapping("/add-bank-details")
	public String addBankGstMst1(Model model) 
	{
		log.info("Calling method addBankGstMst1 in FE controller");
		model.addAttribute("bankMaster", new BankMaster());
		return "views/bankMaster/addBankMaster";

	}
	
	@GetMapping("/fetch-all-bank-details")
	public String listBanks(Model model) {
		log.info("Calling method fetch all bank details in FE controller");
		model.addAttribute("bankMaster", bankMasterService.fetchAllBankDetails());
		return "views/bankMaster/bankDetails";
	}
	
	
//	@GetMapping("/students/edit/{id}")
//	public String editBankMasterDetails(@PathVariable Long id, Model model) {
//		model.addAttribute("student", studentService.getStudentById(id));
//		return "edit_student";
//	}
	
	@PostMapping("/save-bankDetails")
	public String addBankDetails(@ModelAttribute("bankMaster") BankMaster bankMaster) 
	{
		log.info("Calling method add bank details in FE controller, with bank master details: {}", bankMaster);
		bankMasterService.addBankMasterDetails(bankMaster);
		return "redirect:/fetch-all-bank-details";
	}
}
