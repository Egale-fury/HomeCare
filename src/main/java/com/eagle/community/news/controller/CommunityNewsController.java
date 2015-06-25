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

	// 创建一个CommunityNew并存到到数据库中的请求，成功返回创建的新对象
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

	// 处理查询某条社区动态的请求，并返回jsp视图
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getNews(@PathVariable("id") int id) {
		logger.info("/communityNews/getNews  is invoked ");
		ModelAndView view = new ModelAndView("user/newscontent");
		CommunityNews news = communityNewsService.getNewsById(id);
		view.addObject("newscontent", news);
		return view;
	}

	// 通过id查询某条社区动态，返回json
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	public @ResponseBody CommunityNews getNewsJSON(@PathVariable("id") int id) {
		return communityNewsService.getNewsById(id);

	}
	
	//一次性查询指定条数的社区动态并返回json
	@RequestMapping(value="/some/{num}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<CommunityNews> getSomeNewsJson(@PathVariable("num")int num){
		logger.info("getSomeNews is invoked !");
		return communityNewsService.getNews(num);
	}

	// 删除一条communityNews,返回204表示删除成功
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteNews(@PathVariable("id") int id) {
		logger.info("/communityNews/{id} delete is invoked ");
		CommunityNews news = communityNewsService.getNewsById(id);
		if (news != null) {
			if(communityNewsService.deleteNews(news))
				logger.info("delete communityNews success");
			else
				logger.info("delete communityNews failed");
		}
		

	}
	
	//更新一条社区动态消息
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody CommunityNews updateNews(@RequestBody CommunityNews newNews){
		CommunityNews news =communityNewsService.updateNews(newNews);
		return news;
	}
	
	//测试ajax
	@RequestMapping(value="/ajax",method=RequestMethod.POST)
	public  String app(){
		//System.out.println("到了控制层");
		return "addmessage";
	}
	
	
	// 获取首页
	//一次性查询指定条数的社区动态并返回json
	@RequestMapping(value="/index/{num}")
	@ResponseStatus(HttpStatus.OK)
	public  ModelAndView getIndexJson(@PathVariable("num")int num){
		ModelAndView view = new ModelAndView("user/index");
		List<CommunityNews> list = communityNewsService.getNews(num);
		view.addObject("IndexNews", list);
		return view;
	}
	
	//开始添加
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String startAddNews(){
		return "admin/addNews";
	}
	
	//返回具体新闻内容
	@RequestMapping(value="/newscontent",method=RequestMethod.GET)
	public  ModelAndView getContentNews(long id){
		ModelAndView model = new ModelAndView("user/newscontent");
		CommunityNews news  = communityNewsService.getNewsById(id);
		model.addObject("newscontent", news);
		return model;
	}
	

	//返回一页的新闻请求
	@RequestMapping(value="/communityNews/")
	public ModelAndView getOnPageNews(int currentPage,int pageSize){
		ModelAndView view =new ModelAndView("");
		Pagination pagination =communityNewsService.getNews(currentPage, pageSize, true);
		view.addObject("pageInfo",pagination);
		return view;
	}
	
	
	
}
