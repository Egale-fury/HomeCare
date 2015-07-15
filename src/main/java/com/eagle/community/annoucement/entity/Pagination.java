package com.eagle.community.annoucement.entity;

import java.util.List;

/*
 * 为了显示通知公告信息的分页对象
 * 
 * */
public class Pagination {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPages;
	private List<Annoucement> annoucements;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Annoucement> getAnnoucements() {
		return annoucements;
	}

	public void setAnnoucements(List<Annoucement> annoucements) {
		this.annoucements = annoucements;
	}

	public Pagination(int currentPage, int pageSize, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", totalPages="
				+ totalPages + ", annoucements=" + annoucements + "]";
	}

	
	
}
