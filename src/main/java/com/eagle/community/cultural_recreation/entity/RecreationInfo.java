package com.eagle.community.cultural_recreation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

/*文化娱乐类信息栏目*/

@Entity
@Table(name="HBC_RECREATIONINFO")
public class RecreationInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title",length=100)
	@NotBlank(message="标题不能为空")
	private String title;

	@Column(name="content")
	@Type(type="text")
	@NotBlank(message="内容不能为空")
	private String content;
	
	@Column(name="count")
	private int count;
	
	@Column(name="release_time",updatable=false)
	private Date releaseTime;
	
	@Column(name="source",length=50)
	private String source;
	
	@Column(name="keyWords",length=20)
	@NotBlank(message ="关键词不能为空")
	private String keyWords;

	public RecreationInfo() {
		super();
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

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		RecreationInfo other = (RecreationInfo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecreationInfo [id=" + id + ", title=" + title + ", content="
				+ content + ", count=" + count + ", releaseTime=" + releaseTime
				+ ", source=" + source + ", keyWord=" + keyWords + "]";
	}

}
