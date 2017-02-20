package com.inc.gtc.sms.resp;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.inc.gtc.sms.SmsContants;

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
 * 邮件回复resp
 * @author atian
 *
 */
public class RecvSmsMsg {

	private String mobile;
	
	private String text;
	
	private Date replyTime;
	
	
	
	public String getMobile() {
		return mobile;
	}



	public String getText() {
		return text;
	}



	public Date getReplyTime() {
		return replyTime;
	}



	public static  RecvSmsMsg create(Map<String,Object> vals)
	{
		RecvSmsMsg recvMsg = new RecvSmsMsg();
		recvMsg.mobile = "15123901329"/*(String)vals.get(SmsContants.KEY_MOBILE)*/;
		recvMsg.text = (String)vals.get(SmsContants.KEY_TEXT);
		if (vals.containsKey(SmsContants.KEY_REPLY_TIME))
		{
			try {
				recvMsg.replyTime = SmsContants.sdf.parse((String)vals.get(SmsContants.KEY_REPLY_TIME));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return recvMsg;
	}
}
