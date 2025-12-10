package com.devtechie.monolithic.erp_three_tier_service.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devtechie.monolithic.erp_three_tier_service.model.BankMaster;
import com.devtechie.monolithic.erp_three_tier_service.service.BankMasterServiceImpl;
import com.devtechie.monolithic.erp_three_tier_service.util.BankMasterQueries;

@Repository
public class BankMasterRepositoryImpl implements BankMasterRepository
{

	private static Logger log = LoggerFactory.getLogger(BankMasterRepositoryImpl.class);
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public BankMasterRepositoryImpl(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	class BankGstMstMapper implements RowMapper<BankMaster> {
		@Override
		public BankMaster mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			BankMaster bankGstMst = new BankMaster();
			bankGstMst.setBankMasterId(rs.getString("bank_master_id"));
			bankGstMst.setBankCode(rs.getString("bank_code"));
			bankGstMst.setBankName(rs.getString("bank_name"));
			bankGstMst.setIfscCode(rs.getString("ifsc_code"));
			bankGstMst.setBankAddress(rs.getString("bank_address"));
			
			return bankGstMst;
		}
	}
	
	public MapSqlParameterSource getBankGstMstParamsMap(BankMaster bankMaster) 
	{
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	
		String uuid = UUID.randomUUID().toString();
	    bankMaster.setBankMasterId(uuid); 
		
		paramSource.addValue("bankMasterId", bankMaster.getBankMasterId());
		paramSource.addValue("bankCode", bankMaster.getBankCode());
		paramSource.addValue("bankName", bankMaster.getBankName());
		paramSource.addValue("ifscCode", bankMaster.getIfscCode());
		paramSource.addValue("bankAddress", bankMaster.getBankAddress());

		

		return paramSource;
	}
	
	@Override
	public boolean addBankMasterDetails(BankMaster bankMaster) 
	{
		log.info("Calling method addBankMasterDetails inside DAO with bank details: {} ", bankMaster);
		try {
			String sql = BankMasterQueries.ADD_BANK_MASTER_DETAILS;

			if (namedParameterJdbcTemplate.update(sql, getBankGstMstParamsMap(bankMaster)) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<BankMaster> fetchAllBankDetails() 
	{
		log.info("Calling method fetchAllBankDetails inside DAO");
		List<BankMaster> list = new ArrayList();
		try {
			String sql = BankMasterQueries.FETCH_BANK_MASTER_DETAILS;
			list = (List<BankMaster>) namedParameterJdbcTemplate.query(sql, new BankGstMstMapper());
			System.out.println(list);
			return list;
		} catch (Exception e) {
			return new ArrayList<BankMaster>();
		}
	}
	
}
