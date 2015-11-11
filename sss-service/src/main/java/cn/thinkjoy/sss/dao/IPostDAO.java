/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  PostDAO.java 2015-11-11 11:46:41 $
 */
package cn.thinkjoy.sss.dao;

import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.sss.domain.Post;

public interface IPostDAO extends IBaseDAO<Post>{
	
	Post findByName(String name);
	Post findByDesc(String desc);

}
