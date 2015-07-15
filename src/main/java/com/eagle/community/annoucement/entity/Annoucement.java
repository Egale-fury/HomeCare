package com.eagle.community.annoucement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

/*
 * 通知公告
 * 例如一些服务类信息（包括：疾控中心、社区医疗中心及联系方式，生活服务类组织及其联系方式，紧急救援及联系方式）
 * */
@Entity
@Table(name="HBC_ANNOUCEMENT")
public class Annoucement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="title",length=50)
	@NotBlank(message="公告的标题不能为空")
	private String title;
	
	@Column(name="source",length=50)
	@NotBlank(message="发布源不能为空")
	private String source;//
	
	@Column(name="release_time",updatable=false)
	@NotNull
	private Date releaseTime;
	
	@Column(name="content")
	@NotBlank(message="内容不能为空")
	@Type(type = "text")
	private String content;

	@Column(name="count",columnDefinition="INT default 0")
	private int count;
	
	public Annoucement(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Annoucement [id=" + id + ", title=" + title + ", source="
				+ source + ", releaseTime=" + releaseTime + ", content="
				+ content + ", count=" + count + "]";
	}
	
	
	//重写hashCode和equals方法,方便在hibernate控制下对象的持久化
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Annoucement other = (Annoucement) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
}
