package org.cnepay.mobilepay.tool.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */
public interface CustMobileCodeMapper {

    public List<Map<String,Object>> loadMessageValidateCode(@Param("rownum")String rownum);

    public List<Map<String,Object>> getSerialCode(@Param("rownum")String rownum);
}
