package com.inc.gtc.sms.req;

import java.util.Map;

/**
 * 获取回复短信
 * @author atian
 *
 */
public class PullReplyReq extends AbstractReq{
	
	private static final int DEFAULT_PAGE_SIZE = 50;
	
	private Integer pageSize;
	
	public PullReplyReq()
	{
		pageSize = DEFAULT_PAGE_SIZE;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public Map<String,String> getReqEntity()
	{
		Map<String,String> data = super.getReqEntity();
		data.put("page_size",pageSize.toString());
		return data;
	}
	
	public String getUrl()
	{
		return "https://sms.yunpian.com/v1/sms/pull_reply.json";
	}

}
