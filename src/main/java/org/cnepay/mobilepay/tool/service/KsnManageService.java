package org.cnepay.mobilepay.tool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cnepay.mobilepay.tool.dao.mapper.McrKsnMapper;
import org.cnepay.mobilepay.tool.dao.table.McrKsnDao;
import org.cnepay.mobilepay.tool.views.KsnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KsnManageService extends AbstractService{

	@Autowired
	private McrKsnMapper mcrKsnMapper;

	public List<KsnEntity> loadKsnByKsnNo(String ksnNo){
		List<KsnEntity> ksns = new ArrayList<KsnEntity>();
		List<Map<String,Object>> ksnDaos = mcrKsnMapper.findByKsn(ksnNo);
		if(ksnDaos != null && ksnDaos.size() > 0){
			for(Map<String,Object> item:ksnDaos){
				KsnEntity entity = new KsnEntity();
				renameForKey(entity.getClass(), item);
				copyValueToBean(entity,item);
				ksns.add(entity);
			}
		}
		return ksns;
	}
	
	public int getMobileNoCount(String mobileNo){
		return mcrKsnMapper.findMobileCount(mobileNo);
	}
	
	public int deleteMobileMessage(String mobileNo){
		return mcrKsnMapper.deleteMobileMessage(mobileNo);
	}

	@Transactional
	public Boolean unbundKsn(String ksnNo){
		mcrKsnMapper.updateMcrKsnByKsnNo(ksnNo);
		mcrKsnMapper.updateMcrSerialNoByKsnNo(ksnNo);
		return true;
	}
	
	public int resetKsnTmk(String ksnNo){
		mcrKsnMapper.findByKsnNo(ksnNo);
		mcrKsnMapper.updateByKsnNo(ksnNo);
		return 1;
	}
	
	public int clearKsnMessage(String ksnNo){
		return this.mcrKsnMapper.deleteKsnMessage(ksnNo);
	}
	
	public int sendIcKey(String ksnNo){
		return this.mcrKsnMapper.updateICKeyForDownload(ksnNo);
	}

	@Transactional
	public Boolean unbundMobileNo(String mobileNo){
		mcrKsnMapper.deleteIdentifyCodeByMobileNo(mobileNo);
		mcrKsnMapper.deletePersonalByMobileNo(mobileNo);
		mcrKsnMapper.deleteMerchantByMobileNo(mobileNo);
		return true;
	}
}
