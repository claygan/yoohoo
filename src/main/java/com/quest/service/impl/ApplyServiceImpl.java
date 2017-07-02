package com.quest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.quest.dao.ApplyMapper;
import com.quest.entity.Apply;
import com.quest.entity.ApplyQuery;
import com.quest.entity.Pageble;
import com.quest.exception.MobileExistException;
import com.quest.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

	@Resource
	private ApplyMapper applyMapper;
	
	@Override
	public void apply(Apply apply) throws MobileExistException{
		if(apply == null){
			throw new MobileExistException("请求对象为null");
		}
		Apply requestApply = applyMapper.selectByMobile(apply.getMobile());
		if(requestApply != null){
			throw new MobileExistException();
		}
		applyMapper.insert(apply);

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

}
