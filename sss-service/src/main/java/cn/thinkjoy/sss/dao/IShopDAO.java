/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShopDAO.java 2015-11-11 11:46:42 $
 */
package cn.thinkjoy.sss.dao;

import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.sss.domain.Shop;

public interface IShopDAO extends IBaseDAO<Shop>{
	
	Shop findByShopName(String shopName);
	Shop findByDifficulty(String difficulty);

}
