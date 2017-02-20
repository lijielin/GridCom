package com.inc.gtc.sms.resp;

import java.util.Map;

import com.inc.gtc.fire.util.GsonUtils;

/*{
    "code": 0,
    "msg": "OK",
    "sms_reply": [{
        "mobile": "15253878027",         //回复短信的手机号
        "text": "很好用,已收到,谢谢",       //短信的内容
        "reply_time": "2013-07-23 16:14:15" //回复短信的时间
    }, {
        "mobile": "15222043793",
        "text": "很快啊，已经收到了！ ^_^",
        "reply_time": "2013-07-22 20:33:22"
    }, ]
}*/
/**
 * 短信回复
 * @author atian
 *
 */
public class SmsResp {

	private Map<String,Object> values;
	
	
	
	public Object getVal(String key)
	{
		return values.get(key);
	}
	
	public static SmsResp build(String json)
	{
		SmsResp resp = new SmsResp();
		try {
			resp.values = GsonUtils.convertFromJson(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
		
	}

}
