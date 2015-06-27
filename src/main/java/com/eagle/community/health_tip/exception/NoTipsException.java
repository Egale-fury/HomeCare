package com.eagle.community.health_tip.exception;

import com.eagle.community.exception.BaseWebApplicationException;

public class NoTipsException extends BaseWebApplicationException {

	public NoTipsException() {
		super(404, "库中暂时还未添加健康小贴士", "未添加健康小贴士信息");
		// TODO Auto-generated constructor stub
	}

}
