/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  MaterialsDAO.java 2015-11-11 11:46:41 $
 */
package cn.thinkjoy.sss.dao;

import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.sss.domain.Materials;

public interface IMaterialsDAO extends IBaseDAO<Materials>{
	
	Materials findByName(String name);
	Materials findByUnit(String unit);

}
