package com.eagle.community.user.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HBC_USERS")
public class User {

	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", unique = true, nullable = false, length = 20)
	private String id;

	@Column(name = "real_name", length = 20)
	private String realName;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "sex", length = 2)
	private String sex;

	@Column(name = "ethnicity", length = 20)
	private String ethnicity;// 名族

	@Column(name = "bir")
	private Date bitrhday;

	@Column(name = "native_place")
	private String nativePlace;// 籍贯

	@Column(name = "birth_place")
	private String birthPlace;// 出生地

	@Column(name = "marital_status")
	private String maritalStatus;// 婚姻状况

	@Column(name = "occupation")
	private String cooupation;//职业

	@Column(name = "educated_level")
	private String educatedLevel;//受教育水平

	@Column(name = "address")
	private String address;

	@Column(name = "phone_num", length = 14)
	private String phoneNum;
	
	@ManyToMany
	private Set<Child> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBitrhday() {
		return bitrhday;
	}

	public void setBitrhday(Date bitrhday) {
		this.bitrhday = bitrhday;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCooupation() {
		return cooupation;
	}

	public void setCooupation(String cooupation) {
		this.cooupation = cooupation;
	}

	public String getEducatedLevel() {
		return educatedLevel;
	}

	public void setEducatedLevel(String educatedLevel) {
		this.educatedLevel = educatedLevel;
	}

	
	
	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", realName=" + realName + ", password="
				+ password + ", sex=" + sex + ", ethnicity=" + ethnicity
				+ ", bitrhday=" + bitrhday + ", nativePlace=" + nativePlace
				+ ", birthPlace=" + birthPlace + ", maritalStatus="
				+ maritalStatus + ", cooupation=" + cooupation
				+ ", educatedLevel=" + educatedLevel + ", address=" + address
				+ ", phoneNum=" + phoneNum + ", children=" + children + "]";
	}

	public User() {
		super();
	}

	public User(String id, String realName, String password, String sex,
			String ethnicity, Date bitrhday, String nativePlace,
			String birthPlace, String maritalStatus, String cooupation,
			String educatedLevel, String address, String phoneNum,
			Set<Child> children) {
		super();
		this.id = id;
		this.realName = realName;
		this.password = password;
		this.sex = sex;
		this.ethnicity = ethnicity;
		this.bitrhday = bitrhday;
		this.nativePlace = nativePlace;
		this.birthPlace = birthPlace;
		this.maritalStatus = maritalStatus;
		this.cooupation = cooupation;
		this.educatedLevel = educatedLevel;
		this.address = address;
		this.phoneNum = phoneNum;
		this.children = children;
	}
	
	

}
