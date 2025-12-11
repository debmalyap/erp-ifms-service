-- Create schema
CREATE SCHEMA IF NOT EXISTS spring_boot_tech;

-- Create table
CREATE TABLE IF NOT EXISTS spring_boot_tech.erp_st_bank_master (
    bank_master_id VARCHAR(250) PRIMARY KEY,
    bank_code VARCHAR(100) NOT NULL,
    bank_name VARCHAR(200),
    ifsc_code VARCHAR(50),
    bank_address VARCHAR(250)
);