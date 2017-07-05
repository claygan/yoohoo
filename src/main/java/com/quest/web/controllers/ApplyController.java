package com.quest.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quest.entity.Apply;
import com.quest.entity.ApplyQuery;
import com.quest.entity.Pageble;
import com.quest.exception.MobileExistException;
import com.quest.exception.MobileFormatException;
import com.quest.service.ApplyService;
import com.quest.web.common.ApiResult;
import com.quest.web.common.GlobalDefine;

@Controller
@RequestMapping("apply")
public class ApplyController {
	
	@Resource(name="applyService")
	private ApplyService applyService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("submit")
	@ResponseBody
	public ApiResult applySubmit(HttpServletRequest request, HttpServletResponse response,Apply apply){
		ApiResult result = new ApiResult(); 
		try {
			applyService.apply(apply);
			result.setError(GlobalDefine.resultCode.SUCCESS);
			result.setMsg("提交成功");
		} catch (MobileExistException e) {
			result.setError(GlobalDefine.resultCode.INTERNAL_ERROR);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		} catch (MobileFormatException e) {
			result.setError(GlobalDefine.resultCode.INTERNAL_ERROR);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		} catch (Exception e){
			result.setError(GlobalDefine.resultCode.INTERNAL_ERROR);
			result.setMsg("系统异常");
			e.printStackTrace();
		}
		
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("queryApply")
	public ApiResult queryApplyPage(HttpServletRequest request, HttpServletResponse response,ApplyQuery applyQuery){
		ApiResult result = new ApiResult(); 
		Pageble<Apply> pageble = applyService.queryApplyList(applyQuery);
		result.setData(pageble);
		return result;
	}
}
