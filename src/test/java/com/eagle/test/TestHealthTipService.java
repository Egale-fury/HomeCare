package com.eagle.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.health_tip.entity.HealthTip;
import com.eagle.community.health_tip.entity.Pagination;
import com.eagle.community.health_tip.service.HealthTipService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestHealthTipService {

	@Resource(name = "healthTipService")
	private HealthTipService healthTipService;

	// @Test
	public void testAddTip() {
		HealthTip tip = new HealthTip();
		tip.setTitle("春季吃什么养生 ");
		tip.setReleaseTime(new Date(System.currentTimeMillis()));
		tip.setContent("养生?春天来临，万物竞发，一切都处于生机勃勃的状态。而由于春季气温还是处于多变当中，所以还是要做好保健工作，别让自己在美丽的春天中，都处于娇弱的状态。食疗就是一个不错的保健方法，只有进食适当的食物，就能提高自己的");
		tip.setSource("网上");
		tip.setCount(0);
		System.out.println(healthTipService.addTip(tip));
	}

	// @Test
	public void testGetTip() {
		System.out.println(healthTipService.getTip(1));
	}

	// @Test
	public void testUpdate() {
		HealthTip tip = new HealthTip();
		tip.setId(1);
		tip.setTitle("春季吃什么养生 ");
		tip.setReleaseTime(new Date(System.currentTimeMillis()));
		tip.setContent("养生?春天来临，万物竞发，一切都处于生机勃勃的状态。而由于春季气温还是处于多变当中，所以还是要做好保健工作，别让自己在美丽的春天中，都处于娇弱的状态。食疗就是一个不错的保健方法，只有进食适当的食物，就能提高自己的");
		tip.setSource("网上");
		tip.setCount(10);
		System.out.println(healthTipService.updateTip(tip));
	}

	// @Test
	public void testDelete() {
		HealthTip tip = healthTipService.getTip(1);
		if (healthTipService.deleteTip(tip)) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	// @Test
	public void testGetTotaoCount() {
		System.out.println(healthTipService.getTotalCount());
	}

	// @Test
	public void testGetAll() {
		List<HealthTip> list = healthTipService.getAllTips();
		Iterator<HealthTip> it = list.iterator();
		while (it.hasNext()) {
			HealthTip temp = it.next();
			System.out.println(temp.getId() + ";title:" + temp.getTitle());
		}
	}

	//@Test
	public void testGetPage() {
		Pagination pagination = healthTipService.getTips(0, 4, true);
		System.out.println("一共" + pagination.getTotalCount() + "条");
		System.out.println("当前" + pagination.getCurrentPage() + 1 + "页");
		System.out.println("一共" + pagination.getTotalPages() + "页");
		Iterator<HealthTip> it = pagination.getTips().iterator();
		while (it.hasNext()) {
			HealthTip temp = it.next();
			System.out.println(temp.getId() + ";title:" + temp.getTitle());
		}
	}
	
	@Test
	public void getCurrentTime(){
		System.out.println(System.currentTimeMillis());
	}

	public HealthTipService getHealthTipService() {
		return healthTipService;
	}

	public void setHealthTipService(HealthTipService healthTipService) {
		this.healthTipService = healthTipService;
	}

}
