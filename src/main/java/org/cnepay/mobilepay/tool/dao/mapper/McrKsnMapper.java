package org.cnepay.mobilepay.tool.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */
public interface McrKsnMapper {

    public List<Map<String,Object>> loadKsn();

    public int findByKsnNo(@Param("ksnNo")String ksnNo);
    public int updateByKsnNo(@Param("ksnNo")String ksnNo);

    public int updateICKeyForDownload(@Param("ksnNo")String ksnNo);

    public List<Map<String,Object>> findByKsn(@Param("ksnNo")String ksnNo);

    public int updateMcrKsnByKsnNo(@Param("ksnNo")String ksnNo);
    public int updateMcrSerialNoByKsnNo(@Param("ksnNo")String ksnNo);

    public int findMobileCount(@Param("mobileNo")String mobileNo);

    public int deleteMobileMessage(@Param("mobileNo")String mobileNo);

    public int deleteKsnMessage(@Param("ksnNo")String ksnNo);


    public int deleteIdentifyCodeByMobileNo(@Param("mobileNo")String mobileNo);
    public int deletePersonalByMobileNo(@Param("mobileNo")String mobileNo);
    public int deleteMerchantByMobileNo(@Param("mobileNo")String mobileNo);

}
