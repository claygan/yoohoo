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
import com.zzh.platform.base.entity.activity.ActivityBaoming;
import com.zzh.platform.base.entity.activity.ThemedActivity;
import com.zzh.platform.base.service.ThemedActivityBaomingService;
import com.zzh.platform.base.service.ThemedActivityService;

/**
 * ClassName: siteService Description: TODO(用一句话描述这个类)
 * 
 * @author wangzhen@zhongzhihui.com
 * @date: 2015-12-16 上午11:54:35
 */
@ContextConfiguration("classpath:base.xml")
public class activityServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private ThemedActivityService themedActivityService;
	
	@Resource
	private ThemedActivityBaomingService themedActivityBaomingService;
	
	@Resource
	private ThemedActivityRemoteService themedActivityRemoteService;
	@Test
	public void test() {
//		ThemedActivity themedActivity = themedActivityService.queryOne(100001l, null);
//		System.out.println(themedActivity.getName());
		
//		ThemedActivity themedActivity = new ThemedActivity();
//		themedActivity.setName("圣诞节");
//		themedActivity.setOutline("今天是圣诞节");
//		themedActivity.setAddress("六合路");
//		themedActivity.setHost("熊绪超");
//		themedActivity.setDetail("O2O就是砸钱");
//		themedActivity.setBaomingUrl("sadasdas");
//		themedActivity.setCoverImage(1l);
//		themedActivity.setQiandaoUrl("1231313");
//		themedActivity.setPrice(100d);
//		themedActivity.setScale("100人");
//		themedActivity.setCreateCompany(100l);
//		themedActivity.setCreateUser(123l);
//		themedActivity.setEndTime(new Date());
//		themedActivity.setMobileBanner(2l);
//		themedActivity.setPcBanner(3l);
//		themedActivity.setStartTime(new Date());
//		themedActivity.setUpdateUser(123l);
//		
//		themedActivityService.saveThemedActivity(themedActivity, null, null);
		
	/*	ActivityBaoming activityBaoming = new ActivityBaoming();
		
		activityBaoming.setActivityId(100022l);
		activityBaoming.setUserId(115938l);
		
		themedActivityBaomingService.qiandao(activityBaoming);*/
		
		
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
