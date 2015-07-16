package com.eagle.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.cultural_recreation.entity.Pagination;
import com.eagle.community.cultural_recreation.entity.RecreationInfo;
import com.eagle.community.cultural_recreation.service.RecreationInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestRecreationInfoServivce {
	
	@Resource(name="recreationInfoService")
	private RecreationInfoService recreationInfoService;
	
	//@Test
	public void testAdd(){
		RecreationInfo info =new RecreationInfo();
		info.setKeyWords("插花 文化");
		info.setReleaseTime(new Date(System.currentTimeMillis()));
		info.setSource("99wang");
		info.setContent("ceshi");
		info.setTitle("学习插花");
		System.out.println(recreationInfoService.addRecreationInfo(info));
	}
	
	//@Test
	public void testUpdate(){
		RecreationInfo info =new RecreationInfo();
		info.setId(2);
		info.setKeyWords("插花 文化 ");
		info.setReleaseTime(new Date(System.currentTimeMillis()));
		info.setSource("shequ");
		info.setContent("ceshi");
		info.setTitle("学习插花");
		
		System.out.println(recreationInfoService.updateInfo(info));
	}
	
	//@Test
	public void testDelete(){
		recreationInfoService.deleteInfo(1);
	}
	
	//@Test 
	public void testGetAll(){
		List<RecreationInfo> list= recreationInfoService.getAll();
		Iterator<RecreationInfo> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	//@Test
	public void testGetSome(){
		List<RecreationInfo> list= recreationInfoService.getSome(3);
		Iterator<RecreationInfo> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	//@Test
	public void testGetOnePage(){
		Pagination pagination= recreationInfoService.getOnPageInfo(0, 2, true);
		Iterator<RecreationInfo> it=pagination.getInfo().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println(pagination);
	}

	@Test
	public void testSearch(){
		List<RecreationInfo> list =recreationInfoService.search("下棋");
		Iterator<RecreationInfo> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public RecreationInfoService getRecreationInfoService() {
		return recreationInfoService;
	}

	public void setRecreationInfoService(RecreationInfoService recreationInfoService) {
		this.recreationInfoService = recreationInfoService;
	}
	
	
	
}
