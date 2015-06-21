package com.eagle.community.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "HBC_CHILD")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 20)
	private long id;

	@Column(name = "name", length = 20)
	@NotNull(message = "子女姓名不能为空")
	private String name;

	@Column(name = "relation_ship", length = 20)
	@NotNull(message = "该子女和老人的关系不能为空")
	private String relationShip;

	@Column(name = "age", length = 3)
	private int age;

	@Column(name = "sex", length = 2)
	@NotNull(message = "子女性别需要填写")
	private String sex;

	@Column(name = "work_unit", length = 70)
	private String workUnit;

	@Column(name = "address", length = 100)
	private String address;

	@Column(name = "phone_num", length = 14)
	@Pattern(regexp = "^13\\d{9}|14[57]\\d{8}|15[012356789]\\d{8}|18[01256789]\\d{8}|170\\d{8}$", message = "手机号码格式不对")
	private String phoneNum;

	public Child() {
		super();
	}

	public Child(long id, String name, int age, String sex, String workUnit,
			String address, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.workUnit = workUnit;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", name=" + name + ", relationShip="
				+ relationShip + ", age=" + age + ", sex=" + sex
				+ ", workUnit=" + workUnit + ", address=" + address
				+ ", phoneNum=" + phoneNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phoneNum == null) ? 0 : phoneNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		return true;
	}
	
	

}
