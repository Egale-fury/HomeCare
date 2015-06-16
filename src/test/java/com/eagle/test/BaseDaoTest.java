package com.eagle.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.dao.CommunityNewsDao;
import com.eagle.community.model.CommunityNews;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BaseDaoTest {

	@Resource(name = "communityNewsDao")
	private CommunityNewsDao communityNewsDao;

	// @Test
	public void testFind() {
		// System.out.println(sessionFactory);
		// 逗比，。
		// communityNewDao = newdg CommunityNewsDaoImpl();

		System.out.println(communityNewsDao.find(1));
	}

	// @Test
	public void testSave() {
		CommunityNews news = new CommunityNews();
		news.setArticle("复仇者联盟免费小区公映");
		news.setDate(new Date(System.currentTimeMillis()));
		news.setTitle("test 02");
		news.setAuthorName("罗亮");
		communityNewsDao.save(news);
	}

	// @Test
	public void testUpdate() {
		CommunityNews news = communityNewsDao.find(1);
		news.setTitle("lairena ");
		communityNewsDao.update(news);
	}

	// @Test
	public void testGetAll() {
		List<CommunityNews> list = communityNewsDao.getAll();
		if (list.size() > 0)
			System.out.println(list);
		else {
			System.out.println("查询的结果为空");
		}
	}

	// @Test
	public void testGetTotalCount() {
		System.out.println("数据集的总条数::" + communityNewsDao.getTotalCount());
	}

	@Test
	public void testDelete() {
		CommunityNews news = communityNewsDao.find(6);
		communityNewsDao.delete(news);
	}

}
