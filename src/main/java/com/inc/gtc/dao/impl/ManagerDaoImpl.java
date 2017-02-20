package com.inc.gtc.dao.impl;

import org.springframework.stereotype.Repository;

import com.inc.gtc.dao.ManagerDao;
import com.inc.gtc.domain.Manager;

@Repository("managerDao")
public class ManagerDaoImpl extends BaseJdbcDaoImpl<Manager> implements ManagerDao{

	

}
