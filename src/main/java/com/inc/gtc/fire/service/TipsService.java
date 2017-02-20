package com.inc.gtc.fire.service;

import com.inc.gtc.fire.domain.Tips;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2013-5-17 上午10:51:51
 * 类说明
 */
public interface TipsService extends BaseService<Tips>{
	
	/**根据编码获取**/
	Tips getTipByCode(String code);
	Tips getTipByCodeFromCache(String code);
}
