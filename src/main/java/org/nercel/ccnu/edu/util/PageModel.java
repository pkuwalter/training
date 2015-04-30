package org.nercel.ccnu.edu.util;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 封装分页信息
 * 
 * @author zds
 * 
 * @param <E>
 */
@XmlRootElement
public class PageModel<E> {

	// 结果集
	private List<E> list;

	// 查询记录数
	private int totalRecords;

	// 每页多少条数据
	private int pageSize;

	// 第几页
	private int pageNo;

	// 总页数
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}

	// 取得首页
	public int getTopPageNo() {
		return 1;
	}

	// 取得末页
	public int getBottomPageNo() {
		return getTotalPages();
	}

	// 取得上一页
	public int getPreviousPageNo() {
		return pageNo - 1 <= 0 ? 1 : pageNo - 1;
	}

	// 取得下一页
	public int getNextPageNo() {
		return pageNo + 1 > getTotalPages() ? getTotalPages() : pageNo + 1;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
