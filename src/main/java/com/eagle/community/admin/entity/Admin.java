package com.eagle.community.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//管理员用户实体类
@Entity
@Table(name="HBC_ADMIN")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,length=5)
	private int id;
	
	@Column(name="user_name",length=20)
	@NotNull(message="用户名不能为空")
	private String userName;
	
	@Column(name="password",length=20)
	@NotNull(message="密码不能为空s")
	private String password;
	
	@Column(name="last_login_ip",length=15)
	private String lastLoginIP;
	
	@Column(name="last_login_date")
	private Date lastLoginDate;
	
	public Admin() {
		super();
	}

	public Admin(int id, String userName, String password, String lastLoginIP,
			Date lastLoginDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.lastLoginIP = lastLoginIP;
		this.lastLoginDate = lastLoginDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password="
				+ password + ", lastLoginIP=" + lastLoginIP
				+ ", lastLoginDate=" + lastLoginDate + "]";
	}
	
	
	
	
}
