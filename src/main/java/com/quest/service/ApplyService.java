package com.quest.service;

import com.quest.entity.Apply;
import com.quest.entity.ApplyQuery;
import com.quest.entity.Pageble;
import com.quest.exception.MobileExistException;

public interface ApplyService {
	/**
	 * 提交申请
	 * @param apply
	 */
	void apply(Apply apply) throws MobileExistException;
	
	/**
	 * 分页查询申请列表
	 * @param applyQuery
	 * @return
	 */
	Pageble<Apply> queryApplyList(ApplyQuery applyQuery);
}
