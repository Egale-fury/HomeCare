package com.eagle.community.health_tip.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.eagle.community.health_tip.entity.HealthTip;
import com.eagle.community.health_tip.entity.Pagination;
import com.eagle.community.health_tip.service.HealthTipService;

@Controller
@RequestMapping(value = "/healthTip")
public class HealthTipController {

	private static final Logger logger = LogManager
			.getLogger(HealthTipController.class);

	@Resource
	private HealthTipService healthTipService;

	// 请求一个具体的健康小贴士，并在试图中显示
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getTip(@PathVariable("id") long id) {
		logger.info("getTip is invoked !");
		ModelAndView view = new ModelAndView("");// 返回试图名产待定
		HealthTip tip = healthTipService.getTip(id);
		tip.setCount(tip.getCount() + 1);
		tip = healthTipService.updateTip(tip);
		view.addObject("current_tip", tip);
		return view;
	}

	// 返回一个健康贴士的json格式数据
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody HealthTip getTipJson(@PathVariable("id") long id) {
		logger.info("getTipJson is invoked !");
		HealthTip tip = healthTipService.getTip(id);
		tip.setCount(tip.getCount() + 1);
		return healthTipService.updateTip(tip);
	}

	@RequestMapping(value = "/some/{num}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<HealthTip> getSomeTips(
			@PathVariable("num") int num) {
		logger.info("getSomeTips is invoked !");

		return healthTipService.getTips(num);
	}

	@RequestMapping(value = "/{currentPage}/{pageSize}")
	public ModelAndView getOnePageTips(
			@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize) {
		ModelAndView view = new ModelAndView("");// 试图名称待定
		Pagination pagination = healthTipService.getTips(currentPage, pageSize,
				true);
		view.addObject("healthTip_pageInfo", pagination);
		return view;

	}
	
	/*一下定义的操作请求都是管理员权限才能执行的操作*/
	
	//增加一个健康小贴士
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody HealthTip createTip(@RequestBody HealthTip tip){
		logger.info("createTip is invoked !'");
		tip.setReleaseTime(new Date(System.currentTimeMillis()));
		
		//权限控制(待实现)
		
		return healthTipService.addTip(tip);
	}
	
	//更新一个健康小贴士
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody HealthTip updateTip(@RequestBody HealthTip tip){
		logger.info("updateTip is invoked !");
		return healthTipService.updateTip(tip);
	}
	
	//删除一条已经存在的健康小贴士信息
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean deleteTip(@PathVariable("id") long id ){
		logger.info("deleteTip is invoked !");
		//待定的权限控制
		
		HealthTip tip=healthTipService.getTip(id);
		healthTipService.deleteTip(tip);
		return true;
	}

	public HealthTipService getHealthTipService() {
		return healthTipService;
	}

	public void setHealthTipService(HealthTipService healthTipService) {
		this.healthTipService = healthTipService;
	}

}
