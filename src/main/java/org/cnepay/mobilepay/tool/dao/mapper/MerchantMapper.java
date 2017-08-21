package org.cnepay.mobilepay.tool.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */
public interface MerchantMapper {

    public List<Map<String,Object>> findMerchantById(@Param("id")String id);

    public int validateMerchant(@Param("id")String id);

    public int unvalidateMerchant(@Param("id")String id);

}

