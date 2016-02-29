package com.eagle.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.community.health_profile.entity.HealthProfile;
import com.eagle.community.health_profile.service.HealthProfileService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestHealthProfileService {

	@Resource
	private HealthProfileService healthProfileService;

	
	//@Test
	public void testAddProfile() {
//		User user = new User();
//		
//		user.setId("199405162992");
		HealthProfile profile = new HealthProfile();
//		profile.setUserId(user.getId());
		profile.setBloodType("B");
//		profile.setUser(user);
//		user.setHealthProfile(profile);
		System.out.println(healthProfileService.addHealthProfile("199405162992",profile));

	}

	@Test
	public void testGetProfile(){
		HealthProfile profile=healthProfileService.getHealthProfile("199405162992");
		System.out.println(profile);
		System.err.println(profile.getUser().toString());
	}
	
	//@Test
	public void testUpdateProfile(){
		HealthProfile profile=healthProfileService.getHealthProfile("199405162992");
		profile.setDisability("一级伤残");
		profile.setFhog("尚无遗传病");
		profile.setExerciseHabits("一周三次");
		System.out.println(healthProfileService.updateHealthProfile( profile));
	}
	 
	public HealthProfileService getHealthProfileService() {
		return healthProfileService;
	}

	public void setHealthProfileService(HealthProfileService healthProfileService) {
		this.healthProfileService = healthProfileService;
	}

	
	
}
