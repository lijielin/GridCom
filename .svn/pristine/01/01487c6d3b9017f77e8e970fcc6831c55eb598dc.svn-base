package com.inc.gtc.sms.req;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.inc.gtc.sms.SmsContants;

/**
 * 获取回复短信
 * 	start_time	String	是	短信回复开始时间	2013-08-11 00:00:00
	end_time	String	是	短信回复结束时间	2013-08-12 00:00:00
	page_num	Integer	是	页码，默认值为1	1
	page_size	Integer	是	每页个数，最大100个	20
	mobile	String	否	填写时只查该手机号的回复，不填时查所有的回复	15205201314
	return_fields		否	返回字段（暂未开放）	
	sort_fields		否	排序字段（暂未开放）	默认按提交时间降序
 * @author atian
 *
 */
public class GetReplyReq extends AbstractReq{
	
	private static final int DEFAULT_PAGE_NUM = 1;
	private static final int DEFAULT_PAGE_SIZE = 50;
	
	private Date startTime;
	
	private Date endTime;
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	public GetReplyReq()
	{
		pageNum = DEFAULT_PAGE_NUM;
		pageSize = DEFAULT_PAGE_SIZE;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Map<String,String> getReqEntity()
	{
		Map<String,String> data = super.getReqEntity();
		data.put("start_time",SmsContants.sdf.format(startTime));
		data.put("end_time",SmsContants.sdf.format(endTime));
		data.put("page_num",pageNum.toString());
		data.put("page_size",pageSize.toString());
		return data;
	}
	
	public String getUrl()
	{
		return "https://sms.yunpian.com/v1/sms/get_reply.json";
	}

}
