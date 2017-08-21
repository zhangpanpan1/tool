package org.cnepay.mobilepay.tool.service;

import org.apache.ibatis.annotations.Param;
import org.cnepay.mobilepay.tool.dao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/17.
 */

@Service
public class TestService {

    @Autowired
    private AccountMapper accountMapper;

    public List<Map<String,Object>> loadAccount(String accountNo) {
        List<Map<String,Object>> results = accountMapper.loadAccount(accountNo);
        return results;
    }

    public List<Map<String,Object>> findAccountByMerchant(String merchantId) {
        List<Map<String,Object>> results = accountMapper.findAccountByMerchant(merchantId);
        return results;
    }

    public int validateMerchant(String id) {
        int result = accountMapper.validateMerchant(id);
        return result;
    }

    public int unvalidateMerchant(String id) {
        int result = accountMapper.unvalidateMerchant(id);
        return result;
    }

    public int existBankCard(String backId) {
        int result = accountMapper.existBankCard(backId, String.valueOf(backId.length()));
        return result;
    }

    public void unbundAccountCount(String accountNo) {
        int result = accountMapper.unbundAccountCount(accountNo);
        System.out.println(result);
    }

    @Transactional
    public void unbundAccount(String accountNo) {
        accountMapper.deleteMerchantBankAccountByAccountNo(accountNo);
        accountMapper.deleteBankAccountByAccountNo(accountNo);
    }


}
