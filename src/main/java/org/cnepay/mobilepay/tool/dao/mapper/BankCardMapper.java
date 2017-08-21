package org.cnepay.mobilepay.tool.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */
public interface BankCardMapper {

    public List<Map<String,Object>> findBankCardInfo(@Param("cardno")String cardno, @Param("cardNoLen")String cardNoLen);

}
