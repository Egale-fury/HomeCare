package com.eagle.test;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.news.entity.CommunityNews;
import com.eagle.community.news.entity.Pagination;
import com.eagle.community.news.service.CommunityNewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "/applicationContext.xml" })
public class TestCommunityNewsService {

	@Resource(name="communityNewsService")
	private CommunityNewsService communityNewsService;
	
	
	//@Test
	public void testGetNewsWithSize(){
		List<CommunityNews> list =communityNewsService.getNews(6);
		Iterator<CommunityNews> it =list.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
//		System.out.println(list);
		
	}
	
	@Test
	public void testGetNewsWithPage(){
		Pagination pagination =communityNewsService.getNews(0, 4, true);
		System.out.println(pagination.getTotalCount());
		System.out.println(pagination.getCurrentPage()+1);
		System.out.println(pagination.getTotalPages());
		Iterator<CommunityNews> it =pagination.getNews().iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
		
	}

	public CommunityNewsService getCommunityNewsService() {
		return communityNewsService;
	}

	public void setCommunityNewsService(CommunityNewsService communityNewsService) {
		this.communityNewsService = communityNewsService;
	}
	
	
	
	
}
