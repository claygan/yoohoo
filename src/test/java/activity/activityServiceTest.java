/**
 * Project Name: zzh-base-service
 * File Name: siteService.java
 * Package Name: site
 * Date: 2015-12-16上午11:54:35 
 * Copyright (c) 2015, www.zhongzhihui.com All Rights Reserved. 
 */

package activity;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zzh.base.api.ThemedActivityRemoteService;
import com.zzh.base.api.entity.activity.ActivityApplyItem;

/**
 * ClassName: siteService Description: TODO(用一句话描述这个类)
 * 
 * @author wangzhen@zhongzhihui.com
 * @date: 2015-12-16 上午11:54:35
 */
@ContextConfiguration("classpath:base.xml")
public class activityServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private ThemedActivityRemoteService themedActivityRemoteService;
	@Test
	public void test() {
		
		ActivityApplyItem activityApplyItem = new ActivityApplyItem();
		activityApplyItem.setUserId(123);
		activityApplyItem.setActivityId(222);
		activityApplyItem.setCompanyName("中智汇集团");
		activityApplyItem.setEmail("aixiangy@163.com");
		activityApplyItem.setJobpost("java开发");
		activityApplyItem.setMobile("18658860611");
		activityApplyItem.setRealname("艾翔宇");
		themedActivityRemoteService.insertActivityApplyItem(activityApplyItem);
	}
}
