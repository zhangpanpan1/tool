package org.cnepay.mobilepay.tool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cnepay.mobilepay.tool.dao.mapper.AccountMapper;
import org.cnepay.mobilepay.tool.dao.table.AccountDao;
import org.cnepay.mobilepay.tool.views.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountManageService extends AbstractService{

	@Autowired
	private AccountMapper accountMapper;

	public List<AccountEntity> loadAccountNo(String accountNo){
		List<AccountEntity> accounts = new ArrayList<AccountEntity>();
		List<Map<String,Object>> accountDaos = accountMapper.loadAccount(accountNo);
		if(accountDaos != null && accountDaos.size() > 0){
			for(Map<String,Object> item:accountDaos){
				AccountEntity entity = new AccountEntity();
				renameForKey(entity.getClass(), item);
				copyValueToBean(entity,item);
				accounts.add(entity);
			}
		}
		return accounts;
	}
	
	public int unbundAccountCount(String accountNo){
		return accountMapper.unbundAccountCount(accountNo);
	}
	
	public boolean existBankCard(String accountNo){
		int result = accountMapper.existBankCard(accountNo, String.valueOf(accountNo.length()));
		return (result==1)?true:false;
	}

	@Transactional
	public boolean unbundAccountNo(String accountNo){
		accountMapper.deleteMerchantBankAccountByAccountNo(accountNo);
		accountMapper.deleteBankAccountByAccountNo(accountNo);
		return true;
	}

}
