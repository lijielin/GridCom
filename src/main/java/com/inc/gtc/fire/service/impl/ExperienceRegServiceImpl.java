package com.inc.gtc.fire.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.ExperienceRegDao;
import com.inc.gtc.fire.domain.ExperienceReg;
import com.inc.gtc.fire.service.ExperienceRegService;
import com.itc.service.BaseServiceImpl;


/**
 * @author itc.tzj
 * @version 创建时间：2012-3-27 下午4:02:32
 * 体验登记
 */
@Service("experienceRegService")
public class ExperienceRegServiceImpl extends BaseServiceImpl<ExperienceReg,ExperienceRegDao> implements ExperienceRegService{
	

	@Resource(name="experienceRegDao")
	public void setExperienceRegDao(ExperienceRegDao dao)
	{
		super.setDao(dao);
	}

}
