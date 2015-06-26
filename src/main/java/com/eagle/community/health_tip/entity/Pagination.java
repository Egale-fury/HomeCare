package com.eagle.community.health_tip.entity;

import java.util.List;

public class Pagination {

	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPages;
	private List<HealthTip> tips;
	
	public Pagination() {
		super();
	}


	public Pagination(int currentPage, int pageSize, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
	
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
	public List<HealthTip> getTips() {
		return tips;
	}
	public void setTips(List<HealthTip> tips) {
		this.tips = tips;
	}
	
	
}
