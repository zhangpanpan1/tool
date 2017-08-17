package org.cnepay.mobilepay.tool.dao.table;

import java.util.List;
import java.util.Map;

import org.cnepay.mobilepay.tool.dao.AbstractDao;
import org.springframework.stereotype.Component;

@Component
public class CustMobileCodeDao extends AbstractDao {

	public List<Map<String,Object>> loadMessageValidateCode(String rownum){
		
		return getJdbcTemplate().queryForList("select * "
				+ "from (select mcmic.merchant_no merchantNo,"
				+ "mcmic.customer_name customerName,"
				+ "mcmic.id_number idNumber,"
				+ " mcmic.mobile mobile ,"
				+ "mcmic.id_code idCode,"
				+ "mcmic.bank_no bankNo,"
				+ "mcmic.validate_count validateCount"
				+ "  from mp_cust_mobile_identify_code mcmic"
				+ "  order by mcmic.date_created desc)"
				+ "where rownum <=" + rownum);
	}
	
	
	public List<Map<String,Object>> getSerialCode(String rownum){
		
		return getJdbcTemplate().queryForList("select msn.code code"
				+ "   from mcr_serial_number msn"
				+ "   where msn.is_used = 0"
				+ "   and msn.is_cancell = 0"
				+ "   and msn.agency_id = '503'"
				+ "   and rownum <=" + rownum);
	}

}
