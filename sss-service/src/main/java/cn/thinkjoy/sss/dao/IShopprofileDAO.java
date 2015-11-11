/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShopprofileDAO.java 2015-11-11 11:46:43 $
 */
package cn.thinkjoy.sss.dao;

import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.sss.domain.Shopprofile;

public interface IShopprofileDAO extends IBaseDAO<Shopprofile>{
	
	Shopprofile findByKeyType(String keyType);
	Shopprofile findByKeyName(String keyName);
	Shopprofile findByKeyValue(String keyValue);
	Shopprofile findByValueUnit(String valueUnit);

}
