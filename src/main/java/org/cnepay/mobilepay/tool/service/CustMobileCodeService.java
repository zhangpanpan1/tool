package org.cnepay.mobilepay.tool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cnepay.mobilepay.tool.dao.table.CustMobileCodeDao;
import org.cnepay.mobilepay.tool.views.CustMobileCodeEntity;
import org.springframework.stereotype.Service;

@Service
public class CustMobileCodeService extends AbstractService{
	
	
	private CustMobileCodeDao custMobileCodeDao = null;
	
	public CustMobileCodeDao getCustMobileCodeDao() {
		return custMobileCodeDao;
	}

	@Resource
	public void setCustMobileCodeDao(CustMobileCodeDao custMobileCodeDao) {
		this.custMobileCodeDao = custMobileCodeDao;
	}

	public List<CustMobileCodeEntity> loadMessageValidateCode(String rownum){
		List<CustMobileCodeEntity> messageValidates = new ArrayList<CustMobileCodeEntity>();
		
		List<Map<String,Object>> messages = this.custMobileCodeDao.loadMessageValidateCode(rownum);
		if(messages != null && messages.size() > 0){
			for(Map<String,Object> item:messages){
				CustMobileCodeEntity entity = new CustMobileCodeEntity();
				renameForKey(entity.getClass(), item);
				copyValueToBean(entity,item);
				messageValidates.add(entity);
			}
		}
		return messageValidates;
	}
	
	
	public List<String> getSerialCode(String rownum){
	    List<String> list =new ArrayList<String>();
		List<Map<String,Object>> messages = this.custMobileCodeDao.getSerialCode(rownum);
		if(messages != null && messages.size() > 0){
			for(Map<String,Object> item:messages){
			 list.add((String) item.get("CODE"));
			}
		}
		return list;
	}
	
	/*public List<MessageValidateInfoEntity> loadFactMessageValidateCode(String rownum){
		List<MessageValidateInfoEntity> messageValidates = new ArrayList<MessageValidateInfoEntity>();
		if(!NumberUtils.isNumber(rownum)){
			return messageValidates;
		}
		int row = NumberUtils.toInt(rownum,100);
		int pages = row % 15 == 0 ? row/15:row/15 + 1;
		for(int p = 1;p < pages + 1;p++){
			JSONArray array = getFactMessageValidateCodes(String.valueOf(p),String.valueOf(15));
			if(array != null && !array.isEmpty()){
				for(int index = 0;index < array.size();index++){
					JSONObject temp = array.getJSONObject(index);
					MessageValidateInfoEntity entity = new MessageValidateInfoEntity();
					entity.setKsnNo(temp.getString("ksn"));
					entity.setMobileNo(temp.getString("mobile"));
					entity.setValidateCode(temp.getString("code"));
					entity.setUpdateTime(new Timestamp(CalendarUtil.parse(temp.getString("date"))));
					entity.setStatus(temp.getString("status"));
					entity.setValidateStatus(temp.getString("registerStatus"));
					entity.setGetCount(String.valueOf(Integer.MIN_VALUE));
					entity.setValidateCount(String.valueOf(Integer.MIN_VALUE));
					messageValidates.add(entity);
				}
			}
		}
		return messageValidates;
	}
	
	private JSONArray getFactMessageValidateCodes(String page,String count){

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod("http://zftopen.vcpos.cn/wahaha");
		method.addParameters(new NameValuePair[]{new NameValuePair("p",page),new NameValuePair("max",count)});
		try {
			int status = client.executeMethod(method);
			logger.info("返回交易状态：" + status);
			String body = method.getResponseBodyAsString();
			if(status == 200){
				logger.info("接收到的返回数据：" + body);
				JSONObject jsonObject = JSONObject.fromObject(body);
				if(jsonObject.getBoolean("isSuccess")){
					JSONArray jsonArray = jsonObject.getJSONArray("data");
					return jsonArray;
				} else {
					logger.error("服务器返回错误信息：" + jsonObject.toString());
				}
			} else {
				logger.error("错误的返回数据：" + body);
			}
			method.releaseConnection();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			logger.error("HttpException请求：" + e.getMessage(),e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("url请求IOException：" + e.getMessage(),e);
		}
		return null;
	}*/
}
