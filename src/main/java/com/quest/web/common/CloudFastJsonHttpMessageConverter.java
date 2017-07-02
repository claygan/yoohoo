/**
 * Project Name: zzh-cloud-admin
 * File Name: CloudFastJsonHttpMessageConverter.java
 * Package Name: com.zzh.cloud.web.admin.config
 * Date: 2015-8-19下午1:47:54 
 * Copyright (c) 2015, www.zhongzhihui.com All Rights Reserved. 
 */

package com.quest.web.common;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * ClassName: CloudFastJsonHttpMessageConverter Description: 重写覆盖fastjson的converter，使用自定义时间格式
 * 
 * @author jupiter@zhongzhihui.com
 * @date: 2015-8-19 下午1:47:54
 */
public class CloudFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		//
		OutputStream out = outputMessage.getBody();
		String text = JSON.toJSONStringWithDateFormat(obj, DATE_TIME_FORMAT, getFeatures());
		byte[] bytes = text.getBytes(getCharset());
		out.write(bytes);
	}
}
