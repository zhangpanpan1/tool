package org.cnepay.mobilepay.tool.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/17.
 */
public interface AccountMapper {

    public List<Map<String,Object>> loadAccount(@Param("accountNo")String accountNo);

    public List<Map<String,Object>> findAccountByMerchant(@Param("merchantId")String merchantId);

    public int validateMerchant(@Param("id")String id);

    public int unvalidateMerchant(@Param("id")String id);

    public int existBankCard(@Param("backId")String accountNo, @Param("backIdLen")String accountNoLen);

    public int unbundAccountCount(@Param("accountNo")String accountNo);

    public int deleteMerchantBankAccountByAccountNo(@Param("accountNo")String accountNo);

    public int deleteBankAccountByAccountNo(@Param("accountNo")String accountNo);


}
