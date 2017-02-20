package com.inc.gtc.fire.dao;

import com.inc.gtc.fire.domain.DisposalStep;
import com.itc.dao.BaseDao;

/**
 * @author itc.chenzhi
 * @version 创建时间：2013-5-17 上午10:42:38
 * 类说明
 */
public interface DisposalStepDao extends BaseDao<DisposalStep>{

	/**根据步骤编码获取步骤**/
	DisposalStep getStepByCode(String code);
}
