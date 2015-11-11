/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShopliabilitiesDAO.java 2015-11-11 11:46:42 $
 */
package cn.thinkjoy.sss.dao;

import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.sss.domain.Shopliabilities;

public interface IShopliabilitiesDAO extends IBaseDAO<Shopliabilities>{
	
	Shopliabilities findByName(String name);
	Shopliabilities findByPeriod(String period);

}
