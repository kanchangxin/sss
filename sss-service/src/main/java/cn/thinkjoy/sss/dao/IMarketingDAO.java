/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  MarketingDAO.java 2015-11-11 11:46:40 $
 */
package cn.thinkjoy.sss.dao;

import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.sss.domain.Marketing;

public interface IMarketingDAO extends IBaseDAO<Marketing>{
	
	Marketing findByName(String name);

}
