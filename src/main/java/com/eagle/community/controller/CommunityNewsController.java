package com.eagle.community.controller;

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
import com.eagle.community.model.CommunityNews;
import com.eagle.community.service.CommunityNewsService;

@Controller
@RequestMapping("/communityNews")
public class CommunityNewsController {

	@Resource
	private CommunityNewsService communityNewsService;

	private static final Logger logger = LogManager
			.getLogger(BaseDaoImpl.class);

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody CommunityNews createNews(
			@RequestBody CommunityNews newNews) {
		Date currentTime = new Date(System.currentTimeMillis());
		newNews.setDate(currentTime);
		return communityNewsService.saveNews(newNews);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAllNews(){
		logger.info("/communityNews is invoked prepared to get all CommunityNews ");
		ModelAndView view=new ModelAndView("");
		List<CommunityNews> list =communityNewsService.getAllNews();
		view.addObject("allNews",list);
		return view;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getNews(@PathVariable("id") int id) {
		logger.info("/communityNews/getNews.htm is invoked ");
		ModelAndView view = new ModelAndView("show_news");
		CommunityNews news = communityNewsService.getNewsById(id);
		view.addObject("current_news", news);
		return view;
	}
	

	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	public @ResponseBody CommunityNews getNewsJSON(@PathVariable("id") int id) {
		return communityNewsService.getNewsById(id);
	}
}
