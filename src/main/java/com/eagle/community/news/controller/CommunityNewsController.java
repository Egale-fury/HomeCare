package com.eagle.community.news.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
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

import com.eagle.community.news.entity.CommunityNews;
import com.eagle.community.news.entity.Pagination;
import com.eagle.community.news.service.CommunityNewsService;

@Controller
@RequestMapping("/communityNews")
public class CommunityNewsController {

	@Resource
	private CommunityNewsService communityNewsService;

	private static final Logger logger = LogManager
			.getLogger(CommunityNewsController.class);

	// 创建一个CommunityNew并存到到数据库中的请求，成功返回创建的新对象

	@RequiresRoles(value = "admin")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody CommunityNews createNews(
			@RequestBody CommunityNews newNews) {
		Date currentTime = new Date(System.currentTimeMillis());
		newNews.setDate(currentTime);
		return communityNewsService.saveNews(newNews);
	}

	// 获取所有新闻,并返回视图
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllNews() {
		logger.info("/communityNews is invoked prepared to get all CommunityNews ");
		ModelAndView view = new ModelAndView("");// 添加用来显示的jsp的名称
		List<CommunityNews> list = communityNewsService.getAllNews();
		view.addObject("allCommunityNews", list);
		return view;
	}

	// 获取所有新闻并返回json
	@RequestMapping(value = "/all.json", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<CommunityNews> getAllNewsJson() {
		logger.info("/communityNews/all.json is invoked prepared to return json ");
		return communityNewsService.getAllNews();
	}

	// 通过id查询某条社区动态，返回json
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	public @ResponseBody CommunityNews getNewsJSON(@PathVariable("id") int id) {
		return communityNewsService.getNewsById(id);

	}

	// 一次性查询指定条数的社区动态并返回json
	@RequestMapping(value = "/some/{num}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<CommunityNews> getSomeNewsJson(
			@PathVariable("num") int num) {
		logger.info("getSomeNews is invoked !");
		return communityNewsService.getNews(num);
	}

	// 更新一条社区动态消息
	@RequiresRoles("admin")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CommunityNews updateNews(
			@RequestBody CommunityNews newNews) {
		CommunityNews news = communityNewsService.updateNews(newNews);
		return news;
	}

	// 测试ajax
	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	public String app() {
		// System.out.println("到了控制层");
		return "addmessage";
	}

	// 获取首页
	// 一次性查询指定条数的社区动态并返回json
	@RequestMapping(value = "/index/{num}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<CommunityNews> getIndexJson(
			@PathVariable("num") int num) {
		List<CommunityNews> list = communityNewsService.getNews(num);
		return list;
	}

	// 请求社区动态栏的信息
	@RequestMapping(value = "/ConmunityService/{id}", method = RequestMethod.GET)
	public ModelAndView getConmunityService(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("main/newspart/communityservice");
		List<CommunityNews> list = communityNewsService.getNews(id);
		model.addObject("CSnews", list);
		return model;

	}

	// 返回一页的新闻请求
	@RequestMapping(value = "/listNews/{currentPage}/{pageSize}")
	public ModelAndView getOnPageNews(
			@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize) {
		ModelAndView view = new ModelAndView("main/newspart/listnews");
		Pagination pagination = communityNewsService.getNews(currentPage,
				pageSize, true);
		view.addObject("communityNews_pageInfo", pagination);
		return view;
	}

	// 处理查询某条社区动态的请求，并返回jsp视图(具体新闻)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getNews(@PathVariable("id") int id) {
		logger.info("/communityNews/getNews  is invoked ");
		ModelAndView view = new ModelAndView("main/newspart/newscontent");
		CommunityNews news = communityNewsService.getNewsById(id);
		view.addObject("newscontent", news);
		return view;
	}

	/* 以下是后台数据相关跳转 */

	// 新建动态的链接
	@RequiresRoles("admin")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String startAddNews() {
		return "admin/news/addInfo";
	}

	// 后台数据提交跳转到的成功界面
	@RequiresRoles("admin")
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String getSuccess() {
		return "admin/common/success";
	}

	// 查看的链接
	@RequiresRoles("admin")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String queryNews() {
		return "admin/news/queryallnews";
	}

	// 查看链接的分页部分
	@RequiresRoles("admin")
	@RequestMapping(value = "/query/{currentPage}/{pageSize}", method = RequestMethod.GET)
	public ModelAndView queryNews(@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize) {
		ModelAndView view = new ModelAndView("admin/news/alistnews");
		Pagination pagination = communityNewsService.getNews(currentPage,
				pageSize, true);
		view.addObject("admin_communityNews_pageInfo", pagination);
		return view;
	}

	// 具体查看某一条新闻

	@RequestMapping(value = "/querynews/{id}", method = RequestMethod.GET)
	public ModelAndView queryNews(@PathVariable("id") int id) {
		ModelAndView view = new ModelAndView("admin/news/newsquery");
		CommunityNews news = communityNewsService.getNewsById(id);
		view.addObject("querynewscontent", news);
		return view;
	}

	// 编辑一条新闻
	@RequiresRoles("admin")
	@RequestMapping(value = "/editnews/{id}", method = RequestMethod.GET)
	public ModelAndView editNews(@PathVariable("id") int id) {
		ModelAndView view = new ModelAndView("admin/news/newsedit");
		CommunityNews news = communityNewsService.getNewsById(id);
		view.addObject("editnewscontent", news);
		return view;
	}

	// 删除一条communityNews,返回204表示删除成功
	@RequiresRoles(value = "admin")
	@RequestMapping(value = "/deletenews/{id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String deleteNews(@PathVariable("id") int id) {
		CommunityNews news = communityNewsService.getNewsById(id);
		if (news != null) {
			if (communityNewsService.deleteNews(news)) {
				logger.info("delete communityNews success");
				return "delsuccess";
			}
			else {
				logger.info("delete communityNews failed");
				return "delfailure";
			}
		}

		return "delfailure";
	}

	// 后台数据提交跳转到的成功界面
	@RequiresRoles("admin")
	@RequestMapping(value = "/delsuccess", method = RequestMethod.GET)
	public String getDelSuccess() {
		return "admin/common/delsuccess";
	}
}
