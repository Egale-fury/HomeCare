package com.eagle.community.news.controller;

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

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.news.entity.CommunityNews;
import com.eagle.community.news.entity.Pagination;
import com.eagle.community.news.service.CommunityNewsService;

@Controller
@RequestMapping("/communityNews")
public class CommunityNewsController {

	@Resource
	private CommunityNewsService communityNewsService;

	private static final Logger logger = LogManager
			.getLogger(BaseDaoImpl.class);

	private static final int PAGE_SIZE = 10;// 默认每页显示的是十条

	// 创建一个CommunityNew并存到到数据库中的请求，成功返回创建的新对象
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody CommunityNews createNews(//尚未做权限控制
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

	// 一次性获得自定义的条数的社区动态消息，以json返回
	@RequestMapping(value = "/some/{num}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<CommunityNews> getSomeNews(
			@PathVariable("num") int num) {
		return communityNewsService.getNews(num);
	}

	// 获取某页的新闻,并在页面中显示
	@RequestMapping(value = "/{pageIndex}")
	public ModelAndView getOnePageNews(
			@PathVariable("pageIndex") int currentPage) {
		ModelAndView view = new ModelAndView("news_shower");// 暂定的试图名称
		Pagination pagination = communityNewsService.getNews(currentPage,
				PAGE_SIZE, true);
		view.addObject("pagination", pagination);
		return view;
	}

	// 处理查询某条社区动态的请求，并返回jsp视图
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getNews(@PathVariable("id") int id) {
		logger.info("/communityNews/getNews  is invoked ");
		ModelAndView view = new ModelAndView("show_news");
		CommunityNews news = communityNewsService.getNewsById(id);
		// 增加一次该条社区动态消息的点击率
		news.setCount(news.getCount() + 1);
		communityNewsService.updateNews(news);
		view.addObject("current_news", news);
		return view;
	}

	// 通过id查询某条社区动态，返回json
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	public @ResponseBody CommunityNews getNewsJSON(@PathVariable("id") int id) {
		// 增加一次该条社区动态消息的点击率
		CommunityNews news = communityNewsService.getNewsById(id);
		news.setCount(news.getCount() + 1);
		communityNewsService.updateNews(news);
		return news;

	}

	// 删除一条communityNews,返回204表示删除成功
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteNews(@PathVariable("id") int id) {
		logger.info("/communityNews/{id} delete is invoked ");
		CommunityNews news = communityNewsService.getNewsById(id);
		if (news != null) {
			if (communityNewsService.deleteNews(news))
				logger.info("delete communityNews success");
			else
				logger.info("delete communityNews failed");
		}

	}

	// 更新一条社区动态消息
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CommunityNews updateNews(
			@RequestBody CommunityNews newNews) {
		logger.info("controller updateNews method is invoked ");
		CommunityNews news = communityNewsService.updateNews(newNews);
		return news;
	}

}
