package com.eagle.community.health_tip.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import com.eagle.community.news.entity.CommunityNews;

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
		ModelAndView view = new ModelAndView("main/tipspart/tipcontent");
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

	// 请求分页的健康知识
	@RequestMapping(value = "/listtips/{currentPage}/{pageSize}")
	public ModelAndView getOnePageTips(
			@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize) {
		ModelAndView view = new ModelAndView("main/tipspart/listtips");
		Pagination pagination = healthTipService.getTips(currentPage, pageSize,
				true);
		view.addObject("healthTip_pageInfo", pagination);
		return view;

	}

	// 请求健康动态栏的信息
	@RequestMapping(value = "/HealthTip/{id}", method = RequestMethod.GET)
	public ModelAndView getConmunityService(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("main/tipspart/healthtips");
		List<HealthTip> list = healthTipService.getTips(id);
		model.addObject("healthtip", list);
		return model;

	}

	/* 一下定义的操作请求都是管理员权限才能执行的操作 */

	// 跳转到增添的页面
	@RequiresRoles("admin")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String startAddNews() {
		return "admin/health_tip/addTip";
	}

	// 增加一个健康小贴士
	@RequiresRoles("admin")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody HealthTip createTip(@RequestBody HealthTip tip) {
		logger.info("createTip is invoked !'");
		tip.setReleaseTime(new Date(System.currentTimeMillis()));

		// 权限控制(待实现)

		return healthTipService.addTip(tip);
	}

	// 更新一个健康小贴士
	@RequiresRoles("admin")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody HealthTip updateTip(@RequestBody HealthTip tip) {
		logger.info("updateTip is invoked !");
		return healthTipService.updateTip(tip);
	}

	// 删除一条已经存在的健康小贴士信息
	@RequiresRoles("admin")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean deleteTip(@PathVariable("id") long id) {
		logger.info("deleteTip is invoked !");
		// 待定的权限控制

		HealthTip tip = healthTipService.getTip(id);
		healthTipService.deleteTip(tip);
		return true;
	}

	public HealthTipService getHealthTipService() {
		return healthTipService;
	}

	public void setHealthTipService(HealthTipService healthTipService) {
		this.healthTipService = healthTipService;
	}

	// 提交成功跳转到的成功界面
	@RequiresRoles("admin")
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String getSuccess() {
		return "admin/common/success";
	}

	// 查看的链接
	@RequiresRoles("admin")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String queryNews() {
		return "admin/health_tip/queryalltips";
	}

	// 查看链接的分页请求
	@RequiresRoles("admin")
	@RequestMapping(value = "/query/{currentPage}/{pageSize}", method = RequestMethod.GET)
	public ModelAndView queryTips(@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize) {
		ModelAndView view = new ModelAndView("admin/health_tip/alisttips");
		Pagination pagination = healthTipService.getTips(currentPage, pageSize,
				true);
		view.addObject("admin_healthTip_pageInfo", pagination);
		return view;
	}

	// 具体查看某一条健康知识信息
	@RequiresRoles("admin")
	@RequestMapping(value = "/querytips/{id}", method = RequestMethod.GET)
	public ModelAndView queryNews(@PathVariable("id") int id) {
		ModelAndView view = new ModelAndView("admin/health_tip/tipquery");
		HealthTip tip = healthTipService.getTip(id);
		view.addObject("querytipcontent", tip);
		return view;
	}

	// 编辑一条健康知识
	@RequiresRoles("admin")
	@RequestMapping(value = "/edittips/{id}", method = RequestMethod.GET)
	public ModelAndView editNews(@PathVariable("id") int id) {
		ModelAndView view = new ModelAndView("admin/health_tip/tipedit");
		HealthTip tip = healthTipService.getTip(id);
		view.addObject("edittipcontent", tip);
		return view;
	}

	// 删除成功跳转到的界面
	@RequiresRoles("admin")
	@RequestMapping(value = "/delsuccess", method = RequestMethod.GET)
	public String getDelSuccess() {
		return "admin/common/delsuccess";
	}

}
