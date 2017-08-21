/**
 * Project Name:webtool
 * File Name:UserValidateService.java
 * Package Name:org.cnepay.mobilepay.tool.service
 * Date:2015年7月2日下午7:15:19
 * Copyright (c) 2015, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.cnepay.mobilepay.tool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.cnepay.mobilepay.tool.dao.mapper.AccountMapper;
import org.cnepay.mobilepay.tool.dao.mapper.MerchantMapper;
import org.cnepay.mobilepay.tool.dao.mapper.PersonalMapper;
import org.cnepay.mobilepay.tool.dao.table.AccountDao;
import org.cnepay.mobilepay.tool.dao.table.MerchantDao;
import org.cnepay.mobilepay.tool.dao.table.PersonalDao;
import org.cnepay.mobilepay.tool.views.ValidateMerchantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserValidateService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年7月2日 下午7:15:19 <br/>
 * @author   wkm
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class UserValidateService extends AbstractService {

	@Autowired
	private PersonalMapper personalMapper;
	
	@Autowired
	private MerchantMapper merchantMapper;
	
	@Autowired
	private AccountMapper accountMapper;

	public List<ValidateMerchantEntity> findMerchantInfo(String mobile) {
		List<Map<String,Object>> persons = personalMapper.findPersonalByMobile(mobile);
		logger.info("find:" + JSONArray.fromObject(persons).toString(4));
		List<ValidateMerchantEntity> results = new ArrayList<ValidateMerchantEntity>();
		
		for(Map<String,Object> map:persons){
			ValidateMerchantEntity temp = new ValidateMerchantEntity();
			temp.setMobile(map.get("MOBILE_NO").toString());
			temp.setIdCard(map.get("IS_CERTIFICATION").toString());
			temp.setSignature(map.get("IS_SIGNATURE").toString());
			List<Map<String,Object>> merchants = merchantMapper.findMerchantById(map.get("ID").toString());
			if(merchants.size() > 0){
				temp.setMerchant(merchants.get(0).get("REVIEW_STATUS").toString());
			}
			List<Map<String,Object>> accounts = accountMapper.findAccountByMerchant(merchants.get(0).get("ID").toString());
			if(accounts.size() > 0){
				temp.setAccount(accounts.get(0).get("ISVERIFIED").toString());
			}
			results.add(temp);
		}
		logger.info("return:" + JSONArray.fromObject(results).toString(4));
		return results;
	}
	
	public boolean passAll(String mobile) {
		List<Map<String,Object>> persons = personalMapper.findPersonalByMobile(mobile);
		logger.info("find:" + JSONArray.fromObject(persons).toString(4));
		for(Map<String,Object> map:persons){
			personalMapper.validatePersonal(map.get("ID").toString());
			merchantMapper.validateMerchant(map.get("ID").toString());
			List<Map<String,Object>> accounts = accountMapper.findAccountByMerchant(map.get("ID").toString());
			if(accounts.size() > 0) {
				accountMapper.validateMerchant(accounts.get(0).get("ID").toString());
			}
		}
		return true;
	}

	public boolean unpassAll(String mobile){
		
		List<Map<String,Object>> persons = personalMapper.findPersonalByMobile(mobile);
		logger.info("find:" + JSONArray.fromObject(persons).toString(4));
		for(Map<String,Object> map:persons){
			personalMapper.unvalidatePersonal(map.get("ID").toString());
			merchantMapper.unvalidateMerchant(map.get("ID").toString());
			List<Map<String,Object>> accounts = accountMapper.findAccountByMerchant(map.get("ID").toString());
			if(accounts.size() > 0) {
				accountMapper.unvalidateMerchant(accounts.get(0).get("ID").toString());
			}
		}
		return true;
	}
}

