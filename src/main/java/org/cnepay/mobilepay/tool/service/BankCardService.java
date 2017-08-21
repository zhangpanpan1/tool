/**
 * Project Name:webtool
 * File Name:BankCardService.java
 * Package Name:org.cnepay.mobilepay.tool.service
 * Date:2015年7月30日下午1:20:41
 * Copyright (c) 2015, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.cnepay.mobilepay.tool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cnepay.mobilepay.tool.dao.mapper.BankCardMapper;
import org.cnepay.mobilepay.tool.dao.table.BankCardDao;
import org.cnepay.mobilepay.tool.views.BandCardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

/**
 * ClassName:BankCardService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年7月30日 下午1:20:41 <br/>
 * @author   wkm
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class BankCardService extends AbstractService {


	@Autowired
	private BankCardMapper bankCardMapper;

	
	public List<BandCardEntity> findBankCardInfo(String cardno){
		List<Map<String,Object>> bankCards = bankCardMapper.findBankCardInfo(cardno, ""+cardno.length());
		
		List<BandCardEntity> bankCard = new ArrayList<BandCardEntity>();
		if(bankCards != null){
			for(Map<String,Object> map : bankCards){
				
				BandCardEntity entity = new BandCardEntity();
				entity.setCardNo(cardno);
				entity.setCardCode(map.get("CARDBIN_CODE").toString());
				entity.setCardCodeLength(map.get("CARDBIN_LENGTH").toString());
				entity.setCardIssuer(map.get("ISSUER_NAME").toString());
				entity.setCardLength(map.get("CARD_NO_LENGTH").toString());
				entity.setCardName(map.get("CARDBIN_NAME").toString());
				if("credit".equals(map.get("CARD_TYPE").toString())){
					entity.setCardType("信用卡/" + map.get("CARD_TYPE").toString());
				} else if("debit".equals(map.get("CARD_TYPE").toString())){
					entity.setCardType("借记卡/" + map.get("CARD_TYPE").toString());
				} else {
					entity.setCardType("其它类型卡/" + map.get("CARD_TYPE").toString());
				}
				
				bankCard.add(entity);
			}
		}
		
		return bankCard;
	}
	
}

