package com.eagle.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.annoucement.entity.Annoucement;
import com.eagle.community.annoucement.entity.Pagination;
import com.eagle.community.annoucement.service.AnnoucementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestAnnoucementService {

	@Resource
	private AnnoucementService anService;

	/**
	 * 
	 */
	// @Test
	public void testAdd() {
		Annoucement an = new Annoucement();
		an.setSource("疾控中心");
		an.setTitle("春季疫苗接种通知");
		an.setReleaseTime(new Date(System.currentTimeMillis()));
		an.setContent("大家记得接种疫苗 EMRS");

		System.out.println(anService.addAnnoucement(an));
	}

	// @Test
	public void testGet() {
		System.out.println(anService.getAnnoucement(1));
	}

	// @Test
	public void testUpdate() {
		Annoucement an = new Annoucement();
		an.setId(1);
		an.setSource("疾控中心");
		an.setTitle("春季疫苗接种通知");
		an.setReleaseTime(new Date(System.currentTimeMillis()));
		an.setContent("大家记得接种疫苗 EMRS,跑的");

		System.out.println(anService.updateAnnoucement(an));
	}

	// @Test
	public void testDelete() {
		if (anService.deleteAnnoucement(1)) {
			System.out.println("delete success");
		} else {
			System.out.println("delete failure");
		}
	}

	// @Test
	public void testGetAll() {
		List<Annoucement> list = anService.getAll();
		Iterator<Annoucement> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// @Test
	public void testGetSome() {
		List<Annoucement> list = anService.getAnnoucements(2);
		Iterator<Annoucement> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// @Test
	public void testGetOnePage() {
		Pagination pagination = anService.getOnePageAC(0, 5, true);
		System.out.println(pagination.toString());
	}

	@Test
	public void util() {
		System.out.println(System.currentTimeMillis());
	}
}