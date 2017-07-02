package com.quest.dao;

import java.util.List;

import com.quest.entity.Apply;
import com.quest.entity.ApplyQuery;

public interface ApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
    
    Apply selectByMobile(String mobile);
    
    List<Apply> queryApply(ApplyQuery applyQuery);
    
    int getQueryApplyCount(ApplyQuery applyQuery);
}