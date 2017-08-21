package org.cnepay.mobilepay.tool.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */
public interface PersonalMapper {

    public List<Map<String,Object>> findPersonalByMobile(@Param("mobile")String mobile);
    public int validatePersonal(@Param("id")String id);
    public int unvalidatePersonal(@Param("id")String id);

}
