/**
 * Project Name:webtool
 * File Name:BandCardEntity.java
 * Package Name:org.cnepay.mobilepay.tool.views
 * Date:2015年7月30日下午1:25:23
 * Copyright (c) 2015, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.cnepay.mobilepay.tool.views;
/**
 * ClassName:BandCardEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年7月30日 下午1:25:23 <br/>
 * @author   wkm
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class CustMobileCodeEntity extends AbstractEntity{
	
	private String merchantNo;
	private String customerName;
	private String idNumber;
	private String mobile;
	private String idCode;
	private String bankNo;
	private String validateCount;
	
	
	

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getValidateCount() {
		return validateCount;
	}

	public void setValidateCount(String validateCount) {
		this.validateCount = validateCount;
	}

	@Override
	public String toString() {
		return "CustMobileCodeEntity [merchantNo=" + merchantNo
				+ ", customerName=" + customerName + ", idNumber=" + idNumber
				+ ", mobile=" + mobile + ", idCode=" + idCode + ", bankNo="
				+ bankNo + ", validateCount=" + validateCount + "]";
	}

	 
	
}

