package com.eagle.community.cultural_recreation.entity;

import java.util.List;

/*为文化娱乐类信息的分页组件类*/
public class Pagination {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPages;
	
	private List<RecreationInfo> info;

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

	public List<RecreationInfo> getInfo() {
		return info;
	}

	public void setInfo(List<RecreationInfo> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", totalPages="
				+ totalPages + ", info=" + info + "]";
	}

	public Pagination(int currentPage, int pageSize, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
	
}
