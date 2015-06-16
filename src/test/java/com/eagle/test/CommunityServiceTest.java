package com.eagle.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.model.CommunityNews;
import com.eagle.community.service.CommunityNewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class CommunityServiceTest {

	@Resource
	private CommunityNewsService communityNewsService;

	//@Test
	public void testSave() {
		CommunityNews news = new CommunityNews();
		news.setTitle("测试service");
		news.setAuthorName("dpc");
		news.setDate(new Date(System.currentTimeMillis()));
		news.setAtricle(" 2015年6月14日凌晨6点，我市红花岗区延安路一房屋发生局部垮塌。得知这一消息后，我社区包居领导葛斌书记电话联系社区支部书记，要求社区立即对辖区内的危旧房进行排查。早上十点半，葛书记赶到社区，和社区居干汇合，分成两个组对辖区内的危旧房进行了逐一排查。晚上七点半，社区书记和主任参加了办事处由党工委书记刘美珊亲自主持的排查辖区住房的紧急会议。会上，刘书记传达了区会议精神，安排部署了这次排查辖区内住房的工作。会后，我社区又通知全体居干部赶到办公室，连夜召开了工作安排会。会上，社区王主任将办事处工作安排意见以及重点向社区居干作了传达，强调了此次排查工作的重要性和必要性。支部书记将排查工作作了详细分工，根据社区实际情况，将居干分成三人一个组，第一组负责下组排查登记所有住房、辖区单位、建筑工地和可能存在安全隐患的路段、区域，并落实联系安全员；第二组负责将登记的楼房分别制定一楼一房的方案，并将存在重大安全隐患的楼房和其他安全隐患路段、区域写成报告，上报办事处相关部门；第三组负责联系几个物管小区，督促排查是否存在安全隐患。通过既分工明确，又齐抓共管的工作原则，在辖区内展开地毯式的排查登记。周书记还强调，要求居干部在入户居民楼栋时，要向群众进行安全知识的相关宣传，提醒居民群众树立牢固的安全意识，从而能有效保障自身的生命财产安全。");
		int id= communityNewsService.saveNews(news);
		System.out.println("save success & id=="+id);
	}
	
	//@Test
	public void testGet(){
		System.out.println(communityNewsService.getNewsById(7));
	}
	
	//@Test
	public  void testUpdate(){
		CommunityNews news = new CommunityNews();
		news.setId(7);
		news.setAtricle("下大雨啦，暴雨警报");
		news.setDate(new Date(System.currentTimeMillis()));
		news.setTitle("test 03");
		news.setAuthorName("罗亮");
		
		communityNewsService.updateNews(news);
	}
	
	//@Test
	public void testGetAll(){
		List<CommunityNews> list =communityNewsService.getAllNews();
		
		if(list.size()>0){
			System.out.println(list);
		}else{
			System.out.println("list 为空");
		}
	}
	
	@Test
	public void testGetTotalCount(){
		System.out.println(communityNewsService.getTotalCount());
	}
	
	
	
	
}
