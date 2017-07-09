package com.quest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.quest.dao.ApplyMapper;
import com.quest.entity.Apply;
import com.quest.entity.ApplyQuery;
import com.quest.entity.Pageble;
import com.quest.exception.MobileExistException;
import com.quest.exception.MobileFormatException;
import com.quest.service.ApplyService;
import com.quest.utils.ValidateUtils;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

	@Resource
	private ApplyMapper applyMapper;
	
	public void setApplyMapper(ApplyMapper applyMapper) {
		this.applyMapper = applyMapper;
	}

	@Override
	public void apply(Apply apply) throws MobileExistException,MobileFormatException{
		try {
			if(apply == null){
				throw new MobileExistException("请求对象为null");
			}
			//验证手机号格式
			if(!ValidateUtils.isMobileNO(apply.getMobile())){
				throw new MobileFormatException();
			}
			//验证手机号是否已经被注册
			Apply requestApply = applyMapper.selectByMobile(apply.getMobile());
			if(requestApply != null){
				throw new MobileExistException();
			}
			applyMapper.insert(apply);
		} catch (MobileExistException e) {
			throw e;
		} catch (MobileFormatException e) {
			throw e;
		}

	}

	@Override
	public Pageble<Apply> queryApplyList(ApplyQuery applyQuery) {
		Pageble<Apply> pageble = new Pageble<Apply>();
		pageble.setPage(applyQuery.getPage());
		pageble.setPageSize(applyQuery.getPageSize());
		int records = applyMapper.getQueryApplyCount(applyQuery);
		pageble.setRecords(records);
		int totalPage = 0;
		if (records % applyQuery.getPageSize() == 0) {
			totalPage = (int) records / applyQuery.getPageSize();
		} else {
			totalPage = (int) records / applyQuery.getPageSize() + 1;
		}
		pageble.setTotal(totalPage);
		List<Apply> applies = applyMapper.queryApply(applyQuery);
		pageble.setRows(applies);
		return pageble;
	}

	@Override
	public void updateContactStatus(long applyId, int contactStatus) {
		Apply record = new Apply();
		record.setId(applyId);
		record.setContacted(contactStatus);
		applyMapper.updateByPrimaryKeySelective(record);
	}

}
