package com.eagle.community.health_profile.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.eagle.community.user.entity.User;

/*
 * 健康档案的实体类
 * 与User具有一一对应的关系
 * */

@Entity
@Table(name="HBC_HEALTH_PROFILE")
public class HealthProfile implements Serializable{

	@Id  
    @Column(name="user_id")  
    @GeneratedValue(generator="gen")  
    @GenericGenerator(name="gen", strategy="foreign",   
    parameters=@Parameter(name="property", value="user"))
	private String userId;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@PrimaryKeyJoinColumn(name="user_id")
	private User user;
	
	private String bloodType;
	
	private float height;
	
	private float weight;
	
	private String exerciseHabits;
	
	private  String fhog;//家庭遗传病史
	
	private String disability;//残疾情况
	
	private String selfCareAbility;//自理能力
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getExerciseHabits() {
		return exerciseHabits;
	}

	public void setExerciseHabits(String exerciseHabits) {
		this.exerciseHabits = exerciseHabits;
	}

	public String getFhog() {
		return fhog;
	}

	public void setFhog(String fhog) {
		this.fhog = fhog;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getSelfCareAbility() {
		return selfCareAbility;
	}

	public void setSelfCareAbility(String selfCareAbility) {
		this.selfCareAbility = selfCareAbility;
	}


	public HealthProfile() {
		super();
	}
	
	//体检情况
	
	/*慢性病情况
	 * (老年痴呆、高血压、冠心病、脑中、糖尿病、脂肪肝 etc)
	 * */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
